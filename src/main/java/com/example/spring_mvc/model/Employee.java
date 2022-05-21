package com.example.spring_mvc.model;

import com.example.spring_mvc.validation.CheckEmail;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Employee {

    @Size(min = 2, message = "name must be min 2 symbols")
    @NotBlank(message = "не может содержать только пробелы")
    private String name;
    @NotBlank(message = "surname is required field")
    private String surname;
    private String department;
    @Min(value = 500, message = "must be greater than 499")
    @Max(value = 1000, message = "must be less than 1001")
    private int salary;
    private String carBrand;
    @Pattern(regexp = "\\d{3}-\\d{2}-\\d{2}", message = "please use pattern XXX-XX-XX")
    private String phoneNumber;
    @CheckEmail
    private String email;
    private Map<String, String> departmentsList;
    private Map<String, String> carBrandsList;
    private Map<String, String> languagesList;
    private String[] languages;

    public Employee() {
        departmentsList = new HashMap<>();
        departmentsList.put("IT", "Information Technology");
        departmentsList.put("HR", "Human Resources");
        departmentsList.put("Sales", "Sales");
        carBrandsList = new HashMap<>();
        carBrandsList.put("BMW", "BMW");
        carBrandsList.put("Audi", "Audi");
        carBrandsList.put("MB", "Mercedes-Benz");
        languagesList = new HashMap<>();
        languagesList.put("English", "EN");
        languagesList.put("Deutsch", "DE");
        languagesList.put("French", "FR");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }

}