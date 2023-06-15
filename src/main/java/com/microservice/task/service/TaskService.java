package com.microservice.task.service;

import com.microservice.task.repository.TaskRepo;
import com.microservice.task.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements ITaskService {
    @Autowired
    private TaskRepo taskRepo;

    @Override
    public Task addTask(Task task){
        return taskRepo.save(task);
    }

    @Override
    public List<Task> getAllTasks(){
        return taskRepo.findAll();
    }
    @Override
    public Task getTask(int id) { return taskRepo.findById(id).orElse(null); }

    @Override
    public Task editTask(Task task){
        return taskRepo.save(task);
    }

    @Override
    public void deleteTask(int id){
        taskRepo.deleteById(id);
    }

}
