package com.gopichand.dao;

import com.gopichand.beans.Employee;
import com.gopichand.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public String addEmployee(Employee employee) {
        String status="";
        try{
            Connection connection= ConnectionFactory.getConnection();
            Statement statement=connection.createStatement();
            int rowCount=statement.executeUpdate("insert into emp1 values("+employee.getEno()+",'"+employee.getEname()+"',"+employee.getEsal()+",'"+employee.getEaddr()+"')");
            if(rowCount==1)
            {
                status="success";
            }
            else
            {
                status="failure";
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public Employee searchEmployee(int eno) {
        Employee employee=null;
        try{
            Connection connection= ConnectionFactory.getConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from emp1 where eno = "+eno);
            boolean b=resultSet.next();
            if(b==true)
            {
                employee=new Employee();
                employee.setEno(resultSet.getInt("ENO"));
                employee.setEname(resultSet.getString("ENAME"));
                employee.setEsal(resultSet.getFloat("ESAL"));
                employee.setEaddr(resultSet.getString("EADDR"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public String updateEmployee(Employee employee) {
        String status="";
        try
        {
            Connection connection= ConnectionFactory.getConnection();
            Statement statement=connection.createStatement();
            int rowCount=statement.executeUpdate("update emp1 set Ename='"+employee.getEname()+"',Esal="+employee.getEsal()+",Eaddr='"+employee.getEaddr()+"' where ENO="+employee.getEno());
            if(rowCount==1)
            {
                status="success";
            }
            else
            {
                status="failure";
            }
        }
        catch(Exception e)
        {   status="failure";
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public String deleteEmployee(int eno) {
        String status="";
        try
        {
            Connection connection= ConnectionFactory.getConnection();
            Statement statement=connection.createStatement();
            int rowCount=statement.executeUpdate("delete from emp1 where eno = "+eno);
            if(rowCount==1)
            {
                status="success";
            }
            else {
                status="failure";
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }
}
