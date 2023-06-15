package com.microservice.task.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name ="task")
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;
    private String description;
    @Enumerated(EnumType.STRING)
    private EtatTask etatTask;

}
