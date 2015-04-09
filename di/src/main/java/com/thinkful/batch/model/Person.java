package com.thinkful.batch.model;

import lombok.Builder;
import lombok.Data;

@Data
public class Person {
    private String name;
    private String surname;
    private int age;
}
