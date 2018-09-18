package demo.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloBookController
{
    @GetMapping(value = "/book/hello")
    public String sayHello()
    {
        return "Hello，《Spring Boot 2.x 核心技术实战 - 上 基础篇》！";
    }
}
