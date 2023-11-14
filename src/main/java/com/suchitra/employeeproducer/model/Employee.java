package com.suchitra.employeeproducer.model;

import jdk.jfr.DataAmount;
import lombok.Data;

@Data
public class Employee {

    private int id;
    private String name;
    private String email;
    private String contactNo;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", contactNo='" + contactNo + '\'' +
                '}';
    }
}
