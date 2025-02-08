package com.challenge.gupy.entity;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

public class Employee extends Person {

    private BigDecimal salary;
    private String function;

    public Employee() {
        super();
    }

    public Employee(String name, LocalDate birthDate, BigDecimal salary, String function) {
        super(name, birthDate);
        this.salary = salary;
        this.function = function;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String formatSalary() {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return numberFormat.format(getSalary());
    }

    public BigDecimal increaseSalary() {
        return salary.add(salary.multiply(BigDecimal.TEN).divide(BigDecimal.valueOf(100)));
    }

    @Override
    public String toString() {
        return String.format("%sSalário: %s%nFunção: %s%n", super.toString(), formatSalary(), getFunction());
    }
}
