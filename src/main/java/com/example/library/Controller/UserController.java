package com.example.library.Controller;

import com.example.library.Book;
import com.example.library.Service.UserService;
import com.example.library.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public User AddUser(@RequestBody User user)
    {
        return userService.saveUser(user);
    }

    @GetMapping("/getUsers")
    public List<User> GetUsers()
    {
        return userService.getUsers();
    }

    @GetMapping("/getUserById")
    public User GetUserById(String Name)
    {
        return userService.getUserById(Name);
    }

    @DeleteMapping("/deleteUser")
    public String DeleteUser(int Id)
    {
        return userService.deleteUser(Id);
    }

    @PutMapping("/updateUser")
    public User UpdateUser(User user)
    {
        return userService.updateUser(user);
    }
}
