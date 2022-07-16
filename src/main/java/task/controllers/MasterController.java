package task.controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@org.springframework.stereotype.Controller
@RequestMapping("/master")
public class MasterController {
    @GetMapping("/main")
    public String main() {
        return "master/master_main";
    }
}
