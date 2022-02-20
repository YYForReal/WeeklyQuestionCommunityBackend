package com.hyy.weeklyquestionbackend.controller;

import com.hyy.weeklyquestionbackend.bean.User;
import com.hyy.weeklyquestionbackend.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Resource
    UserService userService;

    @GetMapping("/getAllUserId")
    public Set<String> getAllUserId() {
        return userService.getAllUserId();
    }

    @GetMapping("/getUserInfo")
    public User getUserInfoById(String userId) {
        return userService.getUserInfoById(userId);
    }

    @PostMapping("/postLoginInfo")
    public String insertLoginInfo(String userId, String password) {
        return userService.insertLoginInfo(userId, password) ? "OK" : "FAIL";
    }

    @PostMapping("/postAvatar")
    public String updateAvatarUrl(String userId, String avatar) {
        return userService.updateAvatarUrl(userId, avatar) ? "OK" : "FAIL";
    }

    @PostMapping("/postEmail")
    public String updateEmail(String userId, String email) {
        return userService.updateEmail(userId, email) ? "OK" : "FAIL";
    }

    @PostMapping("/postPassword")
    public String updatePassword(String userId, String password) {
        return userService.updatePassword(userId, password) ? "OK" : "FAIL";
    }

    @PostMapping("/postDes")
    public String updateDescription(String userId, String description) {
        return userService.updateDescription(userId, description) ? "OK" : "FAIL";
    }

    @PostMapping("/postName")
    public String updateUserName(String userId, String userName) {
        return userService.updateUserName(userId, userName) ? "OK" : "FAIL";
    }

    @PostMapping("/postBackground")
    public String updateBackground(String userId, String background) {
        return userService.updateBackground(userId, background) ? "OK" : "FAIL";
    }

    @GetMapping("/token")
    public boolean token(String userId, String password) {
        return userService.token(userId, password);
    }
}
