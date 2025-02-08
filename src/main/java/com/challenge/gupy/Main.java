package com.challenge.gupy;

import com.challenge.gupy.entity.Employee;
import com.challenge.gupy.entity.Person;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

import static com.challenge.gupy.utils.ToolFactory.*;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        addEmployeeList(employees);

        employees.removeIf(employee -> employee.getName().equals("João"));

        employees.forEach(System.out::println);

        formatTitle("Aumento de Salário em 10%%");
        employees.stream().map(employee -> {
            Employee emp = new Employee(
                    employee.getName(),
                    employee.getBirthDate(),
                    employee.increaseSalary(),
                    employee.getFunction());
            return emp;
        }).forEach(System.out::println);

        // Agrupa funcionários por função
        Map<String, List<Employee>> listFunctionEmployee = employees
                .stream().collect(Collectors.groupingBy(Employee::getFunction));

        formatTitle("Funcionário por Função: ");
        listFunctionEmployee.forEach((function, listEmployee) -> {
            System.out.printf("## Função: %s:%n%n", function);
            listEmployee.forEach(System.out::println);
            System.out.println("-----------------------");
        });

        formatTitle("Aniversariantes de Outubro e Dezembro:");
        employees.stream()
                .filter(emp -> emp.getBirthDate().getMonthValue() == 10 || emp.getBirthDate().getMonthValue() == 12)
                .forEach(System.out::println);

        formatTitle("Funcionário mais Velho:");
        employees.stream()
                .min(Comparator.comparing(Person::getBirthDate))
                .ifPresent(employee ->
                        System.out.printf("Nome: %s%nIdade: %d%n", employee.getName(), age(employee.getBirthDate())));

        formatTitle("Lista de Funcionários ordenada por Nome: ");
        employees.sort(Comparator.comparing(Employee::getName));
        employees.forEach(System.out::println);

        formatTitle("Total dos Salários:");
        BigDecimal total = employees.stream()
                .map(Employee::getSalary)
                .reduce(BigDecimal.ZERO, (salary1, salary2) -> salary1.add(salary2));
        System.out.printf("Total: %s%n", NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(total));

        formatTitle("Total de Quantos Salários Minimos um Funcionário Recebe:");
        employees.forEach(emp -> {
            BigDecimal count = emp.getSalary().divide(BigDecimal.valueOf(1212.00), 2, RoundingMode.HALF_UP);
            System.out.printf("Nome: %s%nTotal de Salários Minimos: %s%n%n", emp.getName(), count);
        });
    }
}