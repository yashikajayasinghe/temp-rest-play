package com.student.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;

/*
Using Lombok library to avoid Boilerplate coding for getters and setters
 */

@Getter
@Builder(toBuilder = true)
public class Student{


    private List<String> courses;

    private String email;

    private String firstName;

    private String lastName;

    private String programme;

}

