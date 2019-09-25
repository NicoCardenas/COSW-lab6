package com.escuelaing.cosw.taskplanner.Services;

import java.util.List;

import com.escuelaing.cosw.taskplanner.Entities.User;

public interface UserService {
    List<User> getUsersList();
    
    User getUserById(String userId);
    
    User createUser(User user);
    
    User updateUser(User user);
    
    void removeUser(String userId);
}