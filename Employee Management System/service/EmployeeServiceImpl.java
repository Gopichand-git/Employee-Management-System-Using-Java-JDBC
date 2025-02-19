package com.gopichand.service;

import com.gopichand.beans.Employee;
import com.gopichand.dao.EmployeeDao;
import com.gopichand.factory.EmployeeDaoFactory;
import com.gopichand.factory.EmployeeServiceFactory;

public class EmployeeServiceImpl implements EmployeeService {
   EmployeeDao employeeDao = EmployeeDaoFactory.getEmployeeDao();
    @Override
    public String addEmployee(Employee employee) {
        String status=employeeDao.addEmployee(employee);
        return status;
    }

    @Override
    public Employee searchEmployee(int eno) {
        Employee employee=employeeDao.searchEmployee(eno);
        return employee;
    }

    @Override
    public String updateEmployee(Employee employee) {
        String status=employeeDao.updateEmployee(employee);
        return status;
    }

    @Override
    public String deleteEmployee(int eno) {
        String status=employeeDao.deleteEmployee(eno);
        return status;
    }
}
