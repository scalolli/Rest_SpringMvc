package org.hashgeek.controller;

import org.hashgeek.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
class RestController {

//    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
//    @ResponseBody
//    protected String helloWorld() {
//            return "Hello fucking cruel World ola ola ola ";
//    }
//
//    @RequestMapping(value = "/bye", method = RequestMethod.GET)
//    @ResponseBody
//    protected String bye() {
//        return "Bye bye !!";
//    }

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    @ResponseBody
    protected List<Person> getPerson() {
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("Basu", 123));
        persons.add(new Person("Amit", 125));
        return persons;
    }


}