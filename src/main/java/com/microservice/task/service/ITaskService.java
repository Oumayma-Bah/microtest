package com.microservice.task.service;

import com.microservice.task.entity.Task;

import java.util.List;

public interface ITaskService {
    Task addTask(Task task);

    Task getTask(int id);

    Task editTask(Task task);

    void deleteTask(int id);

    List<Task> getAllTasks();
}
