package com.dev.JobPortal.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/portal")
public class HomeController {

    @GetMapping("/home")
    public String register(){

        return "index.html";
    }




}
