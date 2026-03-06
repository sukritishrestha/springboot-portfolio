document.addEventListener("DOMContentLoaded", function () {

    const btn = document.getElementById("navToggle");
    const links = document.getElementById("navLinks");
    const toast = document.getElementById("toast");

    // Navbar toggle
    if (btn && links) {
        btn.addEventListener("click", () => {
            const isOpen = links.classList.toggle("show");
            btn.setAttribute("aria-expanded", String(isOpen));
        });

        links.querySelectorAll("a").forEach(a => {
            a.addEventListener("click", () => {
                links.classList.remove("show");
                btn.setAttribute("aria-expanded", "false");
            });
        });
    }

    // Toast hide
    if (toast) {
        setTimeout(() => {
            toast.classList.add("hide");
        }, 2500);

        setTimeout(() => {
            toast.remove();
        }, 3200);
    }

});