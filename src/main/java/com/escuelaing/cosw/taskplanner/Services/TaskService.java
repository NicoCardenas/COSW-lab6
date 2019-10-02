package com.escuelaing.cosw.taskplanner.Services;

import java.util.List;

import com.escuelaing.cosw.taskplanner.Entities.Task;
import com.escuelaing.cosw.taskplanner.Entities.User;
import com.escuelaing.cosw.taskplanner.Persistance.TaskPersistance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TaskService
 */
@Service
public class TaskService {

    @Autowired
    TaskPersistance tp;

    public List<Task> geTasks() {
        return tp.geTasksList();
    }

    public Task getTaskById(String id) {
        return tp.getTaskById(id);
    }

    public List<Task> getTasksByUserId(String userId) {
        return tp.getTasksByUserId(userId);
    }

    public Task assignTaskToUser(String taskId, User user) {
        return tp.assignTaskToUser(taskId, user);
    }

    public Task updateTask(Task task) {
        return tp.updateTask(task);
    }

    public void removeTask(String id) {
        tp.removeTask(id);
    }
}