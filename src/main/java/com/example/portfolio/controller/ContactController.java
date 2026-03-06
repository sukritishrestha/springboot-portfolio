package com.example.portfolio.controller;
import com.example.portfolio.model.Contact;
import com.example.portfolio.service.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ContactController {

    private final EmailService emailService;

    public ContactController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/contact")
    public String contactPage(Model model) {
        if (!model.containsAttribute("contact")) {
            model.addAttribute("contact", new Contact());
        }
        return "contact";
    }

    @PostMapping("/contact")
    public String sendContact(@ModelAttribute Contact contact, RedirectAttributes redirectAttributes) {
        emailService.sendContactEmail(contact);

        redirectAttributes.addFlashAttribute("success", "✅ Message sent! I’ll get back to you soon.");
        return "redirect:/";
    }
}