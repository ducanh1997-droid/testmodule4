package com.example.testmodule4.controller;

import com.example.testmodule4.model.Department;
import com.example.testmodule4.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private IDepartmentService departmentService;


//    @GetMapping
//    public ModelAndView displayAll(@PageableDefault(value = 2) Pageable pageable){
//        ModelAndView modelAndView = new ModelAndView("/category/list");
//        modelAndView.addObject("category",categoryService.findAll(pageable));
//        return modelAndView;
//    }

    @GetMapping
    public ResponseEntity<Iterable<Department>> findAllCategory(){
        List<Department> categories = (List<Department>) departmentService.findAllDepartment();
        if(categories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/create")
    public ModelAndView createForm(){
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category", new Department());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute("Category") Department category){
        departmentService.create(category);
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category", new Department());
        modelAndView.addObject("message", "New category created successfully");
        return modelAndView;
    }
    @GetMapping("/update/{id}")
    public ModelAndView updateForm(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/category/update");
        modelAndView.addObject("category", departmentService.findById(id));
        return modelAndView;
    }
    @PostMapping("/update/{id}")
    public ModelAndView update(@ModelAttribute("Category") Department department,@PathVariable Long id){
        departmentService.create(department);
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("department", departmentService.findById(id));
        modelAndView.addObject("message", "Update department successfully");
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        departmentService.delete(id);
        return "redirect:/department";
    }
}
