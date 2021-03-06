package com.xwiggy.food.controller;
import com.xwiggy.food.dao.UserDaoImpl;
import com.xwiggy.food.model.User;
import com.xwiggy.food.utility.StrongAES;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
public class RegistrationController {

    @Autowired
    private UserDaoImpl userDao;

    @RequestMapping("/register")
    public User showRegister() {
        return new User();
    }
    

    @PostMapping("/register")
    public User addUser(@RequestBody User user, Model model) {
        System.out.println(user.toString());
        userDao.register(user);
        return user;
    }

    @PostMapping("/checkUserName")
    public boolean checkAvailability(@RequestBody String username, Model model){
        return userDao.usernameExists(username);
    }
    
    @RequestMapping("/xxx")
    private String xxx(){
        return new StrongAES().encrypt("");
    }

}
