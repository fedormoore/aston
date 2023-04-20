package ru.moore.lesson2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/get")
    public String get() {
        return "111";
    }
}
