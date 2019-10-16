package migsoft.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class MainController {

    @RequestMapping("")
    public String hello() {
        return "HOME";
    }
}
