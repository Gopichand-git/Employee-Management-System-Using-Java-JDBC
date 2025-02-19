package com.gopichand.factory;

import com.gopichand.service.EmployeeService;
import com.gopichand.service.EmployeeServiceImpl;

public class EmployeeServiceFactory {
    private static EmployeeService employeeService;
    static {
        employeeService = new EmployeeServiceImpl();
    }
    public static EmployeeService getEmployeeService() {
        return employeeService;
    }
}
