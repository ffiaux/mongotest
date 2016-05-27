package com.ffiaux.web.controllers;

import com.ffiaux.db.EmployeeRepository;
import com.ffiaux.model.Employee;
import com.ffiaux.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ffiaux on 24/05/2016.
 */
@Controller
public class IndexController {
    @Autowired
    private EmployeeRepository repository;

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        repository.deleteAll();

        repository.save(new Employee("Honey", "Edwards", 40, "h.edwards@randatmail.com", "9011-2075", 3756.42));
        repository.save(new Employee("Sydney", "Turner", 38, "s.turner@randatmail.com", "6652-5891", 5065.51));
        repository.save(new Employee("Harold", "Stewart", 35, "h.stewart@randatmail.com", "9123-4592", 1198.44));
        repository.save(new Employee("Eleanor", "Wright", 30, "e.wright@randatmail.com", "3864-2583", 7021.82));
        repository.save(new Employee("Julian", "Harper", 39, "j.harper@randatmail.com", "5020-2888", 6202.91));
        repository.save(new Employee("Clark", "Stewart", 35, "c.stewart@randatmail.com", "7796-0845", 3164.29));
        repository.save(new Employee("Connie", "Holmes", 30, "c.holmes@randatmail.com", "9926-1815", 7271.03));
        repository.save(new Employee("Maximilian", "Cooper", 31, "m.cooper@randatmail.com", "5992-3780", 6707.04));
        repository.save(new Employee("Garry", "Morris", 39, "g.morris@randatmail.com", "6078-5660", 9520.40));
        repository.save(new Employee("Aston", "Harrison", 37, "a.harrison@randatmail.com", "3177-3362", 9463.23));

        return "Teste";
    }

    @RequestMapping(method= RequestMethod.GET, path = "/list")
    public @ResponseBody List<Employee> list() {
        return repository.findAll();
    }

    @RequestMapping(method= RequestMethod.GET, path = "/message")
    public @ResponseBody Message message() {
        return new Message("Hello");
    }

    @RequestMapping(method= RequestMethod.GET, path = "/messages")
    public @ResponseBody List<Message> messages() {
        List<Message> messages = new ArrayList<Message>();
        messages.add(new Message("Hello"));
        messages.add(new Message("World"));

        return messages;
    }
}