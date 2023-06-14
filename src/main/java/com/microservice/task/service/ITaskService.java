package com.microservice.task.service;

import com.microservice.task.entity.Task;

import java.util.List;

public interface ITaskService {
    Task addTask(Task task);

    List<Task> getTask();

    Task editTask(Task task);

    void deleteTask(int id);
}
