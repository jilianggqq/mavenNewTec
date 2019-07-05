package edu.gqq.java8.newfeature;

public class DefaultMethodDemo {
    public static void main(String[] args) {
        Formula f = x -> x * 3.62;
        System.out.println(f.calculate(10));
        System.out.println(f.sqrt(200));
    }
}

interface Formula {
    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}