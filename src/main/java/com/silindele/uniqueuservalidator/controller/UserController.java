package com.silindele.uniqueuservalidator.controller;

import com.silindele.uniqueuservalidator.dto.UserDto;
import com.silindele.uniqueuservalidator.domain.User;
import com.silindele.uniqueuservalidator.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @RequestMapping("/signup")
    public String signup(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "signup";
    }



    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String userSignup(@Valid UserDto userDto,
                             BindingResult bindingResult,
                             Model model
                             ){
            if(bindingResult.hasErrors()){
                return "signup";
            }
            User user = new User();
            user.setUsername(userDto.getUsername());
            user.setEmail(userDto.getEmail());
            userRepository.saveAndFlush(user);
            model.addAttribute("message", "You have been registered successfully");
            return "success";
        }


}
