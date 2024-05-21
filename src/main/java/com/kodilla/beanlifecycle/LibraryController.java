package com.kodilla.beanlifecycle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

@RestController
public class LibraryController {

    @Autowired
    private ApplicationContext context;

    @GetMapping("/createBean")
    public String createBean() {
        LibraryManager manager = context.getBean(LibraryManager.class);
        return "LibraryManager bean created!";
    }
}
