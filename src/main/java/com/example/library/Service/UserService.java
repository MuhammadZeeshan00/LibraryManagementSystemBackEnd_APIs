package com.example.library.Service;

import com.example.library.Book;
import com.example.library.Repository.BookRepository;
import com.example.library.Repository.UserRepository;
import com.example.library.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public User saveUser(User user){

        return userRepository.save(user);
    }

    public List<User> getUsers()
    {
        return  userRepository.findAll();
    }

    public User getUserById(String name)
    {
        return userRepository.findByName(name);
    }

    public User updateUser(User user)
    {
        User existingUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        existingUser.setEmail(user.getEmail());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setPhoneNo(user.getPhoneNo());
        return userRepository.save(existingUser);
    }

    public String deleteUser(int id)
    {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "User with ID " + id + " has been deleted successfully.";
        } else {
            return "User with ID " + id + " does not exist.";
        }
    }
}
