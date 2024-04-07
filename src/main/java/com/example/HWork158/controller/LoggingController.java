package com.example.HWork158.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping
public class LoggingController {

    @RequestMapping("/")
    public RedirectView defaultHome(){
        return new RedirectView("/note/list");
    }
}
