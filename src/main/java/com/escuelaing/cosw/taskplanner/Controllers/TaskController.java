package com.escuelaing.cosw.taskplanner.Controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.escuelaing.cosw.taskplanner.Entities.Task;
import com.escuelaing.cosw.taskplanner.Entities.User;
import com.escuelaing.cosw.taskplanner.Services.TaskService;

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
@RequestMapping("/api/v1/task")
public class TaskController {
    @Autowired
    TaskService ts;

    // ================= Get ================= //
    @GetMapping()
    public ResponseEntity<?> geTasksList() {
        try {
            return new ResponseEntity<>(ts.geTasks(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable String id) {
        try {
            return new ResponseEntity<>(ts.getTaskById(id), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Not found task", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getTasksByUserId(@PathVariable String userId) {
        try {
            return new ResponseEntity<>(ts.getTasksByUserId(userId), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Not found task", HttpStatus.NOT_FOUND);
        }
    }

    // ================= Post ================= //
    @PostMapping(value = "/{taskId}",consumes = "application/json")
    public ResponseEntity<?> assignTaskToUser(@PathVariable String taskId, @RequestBody User user) {
        try {
            return new ResponseEntity<>(ts.assignTaskToUser(taskId, user), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Can't create user", HttpStatus.NOT_FOUND);
        }
    }

    // ================= Uptate ================= //
    @PutMapping(consumes = "application/json")
    public ResponseEntity<?> updateTask(@RequestBody Task task) {
        try{
            return new ResponseEntity<>(ts.updateTask(task), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Not found",HttpStatus.NOT_FOUND);            
        } 
    }
    // ================= Delete ================= //
    @DeleteMapping("/{taskId}")
    public void removeTask(@PathVariable String taskId) {
       ts.removeTask(taskId);
    }
}