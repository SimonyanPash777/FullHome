package com.example.fullhome.controller;

import com.example.fullhome.entity.User;
import com.example.fullhome.security.CurrentUser;
import com.example.fullhome.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user")
    public String userHome(@AuthenticationPrincipal CurrentUser currentUser,ModelMap modelMap) {
        modelMap.addAttribute("user", currentUser.getUser());
        return "index";
    }

    @GetMapping("/user/add")
    public String addUserPage() {
        return "register";
    }

    @PostMapping("/user/add")
    public String addUser(@ModelAttribute User user,
                          @RequestParam("userImage") MultipartFile file,

                          ModelMap modelMap) throws IOException {
        Optional<User> byEmail = userService.findByEmail(user.getEmail());
        if (byEmail.isPresent()) {
            modelMap.addAttribute("errorMessageEmail", "Email already in use");
            return "register";
        }
        if (!file.isEmpty() && file.getSize() > 0) {
            if (file.getContentType() != null && !file.getContentType().contains("image")) {
                modelMap.addAttribute("errorMessageFile", "Please choose only image");
                return "home";
            }
        }
        userService.saveUser(user, file);
        return "redirect:/index";
    }

    @GetMapping(value = "/users/getImage", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getImage(@RequestParam("fileName") String fileName) throws IOException {
        return userService.getUserImage(fileName);
    }

    @GetMapping("/user/delete")
    public String delete(@RequestParam("id") int id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

}
