package com.microservice.task.service;

import com.microservice.task.entity.Task;

public interface ITaskService {
    Task addTask(Task task);

    Iterable<Task> getTask();

    Task editTask(Task task);

    void deleteTask(int id);
}
