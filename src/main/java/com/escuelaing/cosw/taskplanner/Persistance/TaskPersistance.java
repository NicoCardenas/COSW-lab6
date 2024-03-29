package com.escuelaing.cosw.taskplanner.Persistance;

import java.util.List;

import com.escuelaing.cosw.taskplanner.Entities.Task;
import com.escuelaing.cosw.taskplanner.Entities.User;

public interface TaskPersistance {
    List<Task> geTasksList();
    
    Task getTaskById(String id);
    
    List<Task> getTasksByUserId(String userId);
    
    Task assignTaskToUser(String taskId, User user);
    
    Task updateTask(Task task);
    
    void removeTask(String taskId);
}