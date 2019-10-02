package com.escuelaing.cosw.taskplanner.Services;

import java.util.List;

import com.escuelaing.cosw.taskplanner.Entities.User;
import com.escuelaing.cosw.taskplanner.Persistance.UserPersistance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserService
 */
@Service
public class UserService {

    @Autowired
    UserPersistance up;

    public List<User> getUsers() {
        return up.getUsersList();
    }

    public User getUserById(String userId) {
        return up.getUserById(userId);
    }

    public User createUser(User user) {
        return up.createUser(user);
    }
    
    public User updateUser(User user) {
        return up.updateUser(user);
    }

    public void removeUser(String userId) {
        up.removeUser(userId);
    }
}