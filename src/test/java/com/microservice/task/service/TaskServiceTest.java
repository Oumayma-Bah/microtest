package com.microservice.task.service;

import com.microservice.task.entity.EtatTask;
import com.microservice.task.entity.Task;
import com.microservice.task.repository.TaskRepo;
import org.assertj.core.api.OptionalAssert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TaskServiceTest {
    @Autowired
    ITaskService iTaskService;
    @Mock
    TaskRepo taskRepo;
    @InjectMocks
    TaskService taskService;

    Task task= new Task(123,"task1",new Date(), new Date(),"dsc", EtatTask.IN_PROGRESS);
    List<Task> taskList = new ArrayList<Task>(){
        {
            add(new Task(122,"task2",new Date(), new Date(),"test", EtatTask.DONE));
            add(new Task(121,"task3",new Date(), new Date(),"lol", EtatTask.NOT_STARTED));
        }

    };

    @Test
    @Order(1)
    public void testGetAllTasks(){
        List<Task> taskList = iTaskService.getAllTasks();
        Assertions.assertEquals(0, taskList.size());
    }

    @Test
    public void testGetUser(){
           Mockito.when(taskRepo.findById(Mockito.anyInt())).thenReturn(Optional.of(task));
           Task task1= taskService.getTask(123);
           Assertions.assertNotNull(task1);
    }
}
