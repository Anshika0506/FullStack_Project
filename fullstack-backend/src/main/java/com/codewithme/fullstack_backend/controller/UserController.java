package com.codewithme.fullstack_backend.controller;
import com.codewithme.fullstack_backend.exception.UserNotFoundException;
import com.codewithme.fullstack_backend.model.User;
import com.codewithme.fullstack_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    User newUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    @GetMapping("/users")
    List<User> getAllusers(){
        return userRepository.findAll();

    }

  @GetMapping("/user/{id}")
  User getUserById(@PathVariable Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

  }

       @PutMapping("/user/{id}")
       User updateUser(@RequestBody User updatedUser, @PathVariable Long id) {
         return userRepository.findById(id)
            .map(user -> {
                user.setName(updatedUser.getName());
                user.setUsername(updatedUser.getUsername());
                user.setEmail(updatedUser.getEmail());
              return userRepository.save(user);
            })
            .orElseThrow(() -> new UserNotFoundException(id));
}

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return "User with ID " + id + " has been deleted.";
    }



}




