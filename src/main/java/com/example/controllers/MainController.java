package com.example.controllers;

import java.util.ArrayList;
import java.util.Properties;

import com.example.models.EmployeeService;
import com.example.models.Mariadb;
import com.example.models.Config;
import com.example.models.Employee;
import com.example.models.Sqlite;
import com.example.views.EmployeeView;
import com.example.views.MenuView;

public class MainController {
    private final EmployeeView employeeView;
    private EmployeeService employeeService;
    private boolean isRuning = true;

    public MainController() {
        this.employeeView = new EmployeeView();
        Config config = new Config();
        Properties prop = config.read();
        String dialect = prop.getProperty("dialect");
        if(dialect.equals("sqlite")) {
            this.employeeService = new EmployeeService(new Sqlite());
        } if(dialect.equals("mariadb")) {
            this.employeeService = new EmployeeService(new Mariadb());
        }else {
            System.err.println("Hiba! Nem támogatott adatbázis dialketus!");
        }
        
    }

    public void start() {
        MenuView menu = new MenuView();
        while(isRuning) {
            String choice = menu.showMenuAndGetChoice();
            handleMenuChoice(choice);
        }
    }

    public void handleMenuChoice(String choice) {
        switch(choice) {
            case "1":
                ArrayList<Employee> empList = employeeService.getEmployees();
                employeeView.printEmplopyee(empList);
                break;
            case "2":
                Employee emp = employeeView.inputEmployee();
                employeeService.insertEmployee(emp);
                break;
            case "3":
                Employee updateEmp = employeeView.inputEmployeeWithId();
                employeeService.update(updateEmp);
                break;
            case "4":
                int id = employeeView.inputIdForDelete();
                employeeService.deleteById(id);
                break;
            case "5":
                isRuning = false;
                break;

        }
    }
}
