package com.maanvith.task.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "employees")
public class Employee {
    @Id
    private Integer id;
    private String name;
    private String email;
    private String phoneNumber;
    private Integer level;
}
