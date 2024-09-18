package com.dev.JobPortal.Controller;

import com.dev.JobPortal.entity.Users;
import com.dev.JobPortal.entity.UsersType;
import com.dev.JobPortal.services.UsersTypeService;
import com.dev.JobPortal.services.usersService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class UsersController {

    private  final UsersTypeService usersTypeService;
    private final usersService userservice;


    @Autowired
    public UsersController(UsersTypeService usersTypeService, usersService usersService) {
        this.userservice=usersService;
        this.usersTypeService = usersTypeService;
    }

    @GetMapping("/register")
    public String register(Model model){

        List<UsersType> usersType =usersTypeService.getAll();
        model.addAttribute("getAllTypes",usersType);

        model.addAttribute("user",new Users());

        return "register";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @PostMapping("/register/new")
    public String userRegistration(@Valid Users users,Model model){
        //        System.out.println("User:"+users);

        Optional<Users> userByEmail = userservice.getUserByEmail(users.getEmail());

        if (userByEmail.isPresent()){
            model.addAttribute("error","Email already registered!");
            List<UsersType> usersType =usersTypeService.getAll();
            model.addAttribute("getAllTypes",usersType);
            model.addAttribute("user",new Users());

            return "register";
        }

        userservice.addNew(users);
        return "RecruiterProfile";
    }



    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }

        return "redirect:/";
    }

}
