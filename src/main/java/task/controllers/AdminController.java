package task.controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@org.springframework.stereotype.Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/main")
    public String main() {
        return "admin/admin_main";
    }
}
