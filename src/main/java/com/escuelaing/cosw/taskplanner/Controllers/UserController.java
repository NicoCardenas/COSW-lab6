package com.escuelaing.cosw.taskplanner.Controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.escuelaing.cosw.taskplanner.Entities.User;
import com.escuelaing.cosw.taskplanner.Services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    UserService us;

    // ================= Get ================= //
    @GetMapping()
    public ResponseEntity<?> getUsersList() {
        try {
            return new ResponseEntity<>(us.getUsersList(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable String userId) {
        try {
            return new ResponseEntity<>(us.getUserById(userId), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
        }
    }

    // ================= Post ================= //
    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        try {
            return new ResponseEntity<>(us.createUser(user), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Can't create user", HttpStatus.NOT_FOUND);
        }
    }

    // ================= Uptate ================= //
    @PutMapping(consumes = "application/json")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        try{
            return new ResponseEntity<>(us.updateUser(user), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Not found",HttpStatus.NOT_FOUND);            
        } 
    }
    // ================= Delete ================= //
    @DeleteMapping("/{userId}")
    public void removeUser(@PathVariable String userId) {
        us.removeUser(userId);
    }
}