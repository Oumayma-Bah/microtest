package com.microservice.task.controller;

import com.microservice.task.entity.Task;
import com.microservice.task.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {
    @Autowired
    ITaskService iTaskService;

    @GetMapping("/getTask")
    public Iterable<Task> getTasks(){
        return iTaskService.getTask();
    }
    @PostMapping("/AddTask")
    public Task addTask(@RequestBody Task task){
        return iTaskService.addTask(task);
    }
    @PutMapping("/updateTask")
    public Task updateTask(@RequestBody Task task){
        return iTaskService.editTask(task);
    }
    @DeleteMapping("/deleteTask/{id}")
    public void deleteTask(@PathVariable int id){
        iTaskService.deleteTask(id);
    }
}
