package com.suchitra.employeeproducer.service;

import com.suchitra.employeeproducer.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class EmployeePublisher {

    @Autowired
    private KafkaTemplate<String,Object> template;

    public void sendEventsToTopic(Employee employee) {
        try {
            CompletableFuture<SendResult<String, Object>> future = template.send("emp-topic", employee).completable();
            future.whenComplete((result, ex) -> {
                if (ex == null) {
                    System.out.println("Sent message=[" + employee.toString() +
                            "] with offset=[" + result.getRecordMetadata().offset() + "]");
                } else {
                    System.out.println("Unable to send message=[" +
                            employee.toString() + "] due to : " + ex.getMessage());
                }
            });

        } catch (Exception ex) {
            System.out.println("ERROR : "+ ex.getMessage());
        }
    }
}
