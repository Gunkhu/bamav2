package com.example.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeeService {
    
    Database database;
    public EmployeeService(Database database) {
        this.database = database;
    }

    public ArrayList<Employee> getEmployees() {
        try {
            return tryGetEmployees();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    private ArrayList<Employee> tryGetEmployees() throws SQLException {
        ArrayList<Employee> empList = new ArrayList<>();
        Connection con = database.connect();
        String sql = "select * from employees";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()) {
            Employee emp = new Employee();
            emp.setId(rs.getInt("id"));
            emp.setName(rs.getString("name"));
            emp.setCity(rs.getString("city"));
            emp.setSalary(rs.getInt("salary"));
            
            empList.add(emp);
        }
        con.close();
        return empList;
    }

    public void insertEmployee(Employee emp) {
        try {
            tryInsertEmployee(emp);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
    private void tryInsertEmployee(Employee emp) throws SQLException {
        Connection con = this.database.connect();
        String sql = """
                insert into employees
                (name, city, salary)
                values
                (?, ?, ?)
                """;
        PreparedStatement p = con.prepareStatement(sql);
        p.setString(1, emp.getName());
        p.setString(2, emp.getCity());
        p.setInt(3, emp.getSalary());
        int num = p.executeUpdate();
        System.out.println("Num: " + num);
        con.close();
    }


    public void deleteById(int id) {
        try {
            tryDeleteById(id);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    private void tryDeleteById(int id) throws SQLException {
        Connection con = this.database.connect();
        String sql = "delete from employees where id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
        con.close();
    }

    public void update(Employee emp) {
        try {
            tryUpdate(emp);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    private void tryUpdate(Employee emp) throws SQLException {
        Connection con = this.database.connect();
        String sql = """
        update employees 
        set name=?, city=?, salary=? 
        where id=?
        """;
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, emp.getName());
        ps.setString(2, emp.getCity());
        ps.setInt(3, emp.getSalary());
        ps.setInt(4, emp.getId());
        ps.execute();
        con.close();
    }

}
