package org.hashgeek.model;

/**
 * Created with IntelliJ IDEA.
 * User: Basu
 * Date: 3/25/12
 * Time: 3:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class Person {
    private String name;
    private Integer employeeId;

    public Person(String name, Integer employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }
}
