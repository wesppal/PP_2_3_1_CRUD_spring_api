package web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Welcome to my CRUD api!");
        messages.add("I'm Spring CRUD api");
        messages.add("Java pre-project. Task 2.3.1");
        model.addAttribute("messages", messages);
        return "index";
    }

}