package com.microservice.task.service;

import com.microservice.task.entity.Task;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TaskServiceTest {
    @Autowired
    ITaskService iTaskService;

    @Test
    @Order(1)
    public void testGetTasks(){
        List<Task> taskList = iTaskService.getTask();
        Assertions.assertEquals(0, taskList.size());
    }
}
