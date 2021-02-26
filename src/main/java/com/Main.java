package com;

import com.queuetest.ObjectQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication //annotation implies the @Configuration,
// @ComponentScan, and @EnableAutoConfiguration annotations.
//By default, the @ComponentScan annotation will scan for components in the current
// package and all its sub-packages.
@ComponentScan("com")
@EnableSwagger2
public class Main {

    public static void main(String[] args) {
        ObjectQueue queue = new ObjectQueue();
        
        SpringApplication.run(Main.class, args);
        System.out.println("ljsdhfpuahWE");

        for (int i = 0; i < 10; i++) {
            queue.push("element#: " + i);
        }

        System.out.print("size before GET element: " + queue.size() + "    ");
        while (queue.size() > 0) {
            System.out.println("get 3 element: " + queue.get(3));
            System.out.print("size before: " + queue.size() + "    ");
            String s = (String) queue.pull();
            System.out.println(s);
            System.out.println("Queue size after: " + queue.size());
        }




    }

}
