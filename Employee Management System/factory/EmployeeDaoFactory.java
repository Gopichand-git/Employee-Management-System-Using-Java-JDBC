package com.gopichand.factory;

import com.gopichand.dao.EmployeeDao;
import com.gopichand.dao.EmployeeDaoImpl;

public class EmployeeDaoFactory {
    private static EmployeeDao employeeDao;
    static {
        employeeDao = new EmployeeDaoImpl();
    }
    public static EmployeeDao getEmployeeDao() {
        return employeeDao;
    }
}
