package com.microservice.task.DTO;

import com.microservice.task.entity.EtatTask;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TaskDTO implements Serializable {
    private int id;
    private String name;
    private Date startDate;
    private Date endDate;
    private String description;
    private EtatTask etatTask;
}
