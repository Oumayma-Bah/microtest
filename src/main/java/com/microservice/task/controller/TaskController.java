package com.microservice.task.controller;

import com.microservice.task.DTO.TaskDTO;
import com.microservice.task.entity.Task;
import com.microservice.task.service.ITaskService;
import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@RestController
public class TaskController {
    @Autowired
    ITaskService iTaskService;

    @GetMapping("/getTask")
    public List<Task> getTasks(){
        return iTaskService.getAllTasks();
    }
    @PostMapping("/AddTask")
    public Task addTask(@RequestBody Task task){

        return iTaskService.addTask(task);
    }
    @PutMapping("/updateTask")
    public Task updateTask(@RequestBody TaskDTO task){
        Task persistentTask = new Task();
        return iTaskService.editTask(persistentTask);
    }
    @DeleteMapping("/deleteTask/{id}")
    public void deleteTask(@PathVariable int id){
        iTaskService.deleteTask(id);
    }
}
