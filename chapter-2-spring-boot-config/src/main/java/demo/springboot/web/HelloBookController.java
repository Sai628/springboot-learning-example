package demo.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.springboot.config.BookProperties;


@RestController
public class HelloBookController
{
    @Autowired
    private BookProperties bookProperties;

    @GetMapping(value = "/book/hello")
    public String sayHello()
    {
        return "Hello, " + bookProperties.getWriter() + " is writing " + bookProperties.getName() + " !";
    }
}
