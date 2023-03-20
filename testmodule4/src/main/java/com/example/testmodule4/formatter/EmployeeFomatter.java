package com.example.testmodule4.formatter;

import com.example.testmodule4.model.Employee;
import com.example.testmodule4.service.IEmployeeService;
import org.springframework.format.Formatter;
import java.text.ParseException;
import java.util.Locale;

public class EmployeeFomatter implements Formatter<Employee>{
    private IEmployeeService iEmployeeService;

    public EmployeeFomatter(IEmployeeService iEmployeeService) {
        this.iEmployeeService = iEmployeeService;
    }


    @Override
    public Employee parse(String text, Locale locale) throws ParseException {
        return iEmployeeService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Employee object, Locale locale) {
        return null;
    }
}
