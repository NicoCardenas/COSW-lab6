package com.escuelaing.cosw.taskplanner.Persistance;

import java.util.List;

import com.escuelaing.cosw.taskplanner.Entities.User;

public interface UserPersistance {
    List<User> getUsersList();
    
    User getUserById(String userId);
    
    User createUser(User user);
    
    User updateUser(User user);
    
    void removeUser(String userId);
}