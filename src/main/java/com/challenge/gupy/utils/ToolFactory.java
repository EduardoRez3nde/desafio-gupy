package com.challenge.gupy.utils;

import com.challenge.gupy.entity.Employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ToolFactory {

    public static LocalDate dateFormat(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date, formatter);
    }

    public static Integer age(LocalDate date) {
        LocalDate now = LocalDate.now();
        Period period = Period.between(date, now);
        return period.getYears();
    }

    public static void formatTitle(String title) {
        System.out.printf("------------------------------%n%s: %n-----------------------------%n", title);
    }

    public static void addEmployeeList(List<Employee> employees) {
        employees.add(new Employee("Maria", dateFormat("18/10/2000"), new BigDecimal(2009.44), "Operador"));
        employees.add(new Employee("João", dateFormat("12/05/1990"), new BigDecimal(2284.38), "Operador"));
        employees.add(new Employee("Caio", dateFormat("02/05/1961"), new BigDecimal(9836.14), "Coordenador"));
        employees.add(new Employee("Miguel", dateFormat("14/10/1988"), new BigDecimal(19119.88), "Diretor"));
        employees.add(new Employee("Alice", dateFormat("05/01/1995"), new BigDecimal(2234.68), "Recepicionista"));
        employees.add(new Employee("Heitor", dateFormat("19/11/1999"), new BigDecimal(1582.72), "Operador"));
        employees.add(new Employee("Arthur", dateFormat("31/03/1993"), new BigDecimal(4071.84), "Contador"));
        employees.add(new Employee("Laura", dateFormat("08/07/1994"), new BigDecimal(3017.45), "Gerente"));
        employees.add(new Employee("Heloísa", dateFormat("24/05/2003"), new BigDecimal(1606.85), "Eletricista"));
        employees.add(new Employee("Helena", dateFormat("02/09/1996"), new BigDecimal(2799.93), "Gerente"));
    }
}
