package com.example.spring_mvc.controller;

import com.example.spring_mvc.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/employee")
public class MyController {

    @RequestMapping("/")
    public String showFirstView() {
        return "first-view";
    }

    @RequestMapping("/askDetails")
    public String askEmployeeDetails(Model model) {
        model.addAttribute("employee", new Employee());
        return "ask-emp-details-view";
    }

    // HttpServletRequest - содержит много информации о Http request
    // String empName = request.getParameter("employeeName");
    // Второй подход - через @RequestParam("employeeName")
    // При работе с формами, аннотация @ModelAttribute в параметре метода
    // Controller-а, даёт доступ к конкретному атрибуту Модели
    // С помощью BindingResult мы узнаём, что прошла валидация или нет
    @RequestMapping("/showDetails")
    public String showDetails(@Valid @ModelAttribute("employee") Employee emp, BindingResult bindingResult) {
        // Проверяем, что прошла валидация или нет
        if (bindingResult.hasErrors()) {
            return "ask-emp-details-view";
        } else {
            return "show-emp-details-view";
        }
    }

}