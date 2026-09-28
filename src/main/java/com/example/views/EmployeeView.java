package com.example.views;

import java.util.List;

import com.example.models.Employee;

public class EmployeeView {
    ConsoleView console;
    public EmployeeView() {
        this.console = new ConsoleView();
    }
    public void printEmplopyee(List<Employee> empList) {        
        for(Employee emp : empList) {
            console.print(
                emp.getId() + ", " +
                emp.getName() + ", " +
                emp.getCity()  + ", " +
                emp.getSalary()
            );
        }
    }

    public Employee inputEmployee() {
        Employee emp = new Employee();
        emp.setName(console.input("Név: "));
        emp.setCity(console.input("Település: "));
        String salaryStr = console.input("Fizetés: ");
        emp.setSalary(Integer.parseInt(salaryStr));
        return emp;
    }
    public Employee inputEmployeeWithId() {
        Employee emp = new Employee();
        
        String idStr = console.input("Id: ");
        emp.setId(Integer.parseInt(idStr));

        emp.setName(console.input("Név: "));
        emp.setCity(console.input("Település: "));
        String salaryStr = console.input("Fizetés: ");
        emp.setSalary(Integer.parseInt(salaryStr));
        return emp;
    }

    public int inputIdForDelete() {
        String idStr = console.input("Törlendő dolgozó azonosítója: ");
        return Integer.parseInt(idStr);
    } 
}
