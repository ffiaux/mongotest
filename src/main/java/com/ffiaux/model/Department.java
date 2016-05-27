package com.ffiaux.model;

import org.springframework.data.annotation.Id;

/**
 * Created by ffiaux on 26/05/2016.
 */
public class Department {
    @Id
    private String id;
    private String name;
    private Employee boss;

    public Department() {}

    public Department(String name) {
        this.name = name;
    }

    public Department(String name, Employee boss) {
        this.name = name;
        this.boss = boss;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getBoss() {
        return boss;
    }

    public void setBoss(Employee boss) {
        this.boss = boss;
    }
}