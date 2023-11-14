package com.suchitra.employeeproducer.controller;


import com.suchitra.employeeproducer.model.Employee;
import com.suchitra.employeeproducer.service.EmployeePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp-producer")
public class EmployeeController {

    @Autowired
    private EmployeePublisher publisher;


    @PostMapping("/publish")
    public void sendEvents(@RequestBody Employee employee) {
        publisher.sendEventsToTopic(employee);
    }
}
