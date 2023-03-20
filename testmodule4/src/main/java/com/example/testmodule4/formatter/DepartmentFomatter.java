package com.example.testmodule4.formatter;

import com.example.testmodule4.model.Department;
import com.example.testmodule4.service.IDepartmentService;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class DepartmentFomatter implements Formatter<Department> {
    private IDepartmentService iDepartmentService;

    public DepartmentFomatter(IDepartmentService iDepartmentService) {
        this.iDepartmentService = iDepartmentService;
    }
    @Override
    public Department parse(String text, Locale locale) throws ParseException {
        return iDepartmentService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Department object, Locale locale) {
        return null;
    }
}
