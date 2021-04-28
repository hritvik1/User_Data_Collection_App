package com.hritvik.UserDataCollection.controller;

import com.hritvik.UserDataCollection.model.UserData;
import com.hritvik.UserDataCollection.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class UserDataController {

    @Autowired
    private UserDataService userDataService;

    @RequestMapping(value = "/")
    public String index() {
        return "redirect:/addUser";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/addUser")
    public String getFromData(Model model) {
        UserData userData = new UserData();
        model.addAttribute("newUserData", userData);
        return "addUser";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addUser")
    public String addNewUser(UserData newUser) {
        userDataService.addNewUser(newUser);
        return "redirect:/displayUser";
    }

    @RequestMapping(value = "/displayUser")
    public void displayAllUsers(Model model) {
        List<UserData> allUsersData = userDataService.getAllUsersData();
        model.addAttribute("usersData", allUsersData);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteUser")
    public String deleteUser(@RequestParam(name = "userId") Integer userId) {
        userDataService.deleteUser(userId);
        return "redirect:/displayUser";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/updateUser")
    public String getUserData(@RequestParam(name = "userId") Integer userId, Model model) {
        UserData oldData = userDataService.getUserData(userId);
        model.addAttribute("oldData", oldData);
        return "updateUser";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateUser")
    public String updatedUserData(@RequestParam(name = "userId") Integer userId, UserData newData) {
        newData.setId(userId);
        userDataService.updateUserData(newData);
        return "redirect:/displayUser";
    }
}
