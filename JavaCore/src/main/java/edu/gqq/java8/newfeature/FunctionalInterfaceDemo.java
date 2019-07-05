package edu.gqq.java8.newfeature;

import org.junit.Assert;

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        int val = 100;

        // 1. Converter is a generic interface.
        Converter<Integer, String> converter = x -> "value is " + x;
        String result = converter.convert(val);
        System.out.println(result);

        // 2. test method refer
        testMethodReference();

        //3. test constructor refer.
        testConstructorRefer();
    }

    /**
     * how the :: keyword works for constructors.
     */
    private static void testConstructorRefer() {
        // input two strings, output is Person.
        // we can use constructor reference way to initiate a PersonFactory class.
        PersonFactory pf = Person::new;
        Person me = pf.create("Qiqiang", "Guan");
        Assert.assertEquals("Qiqiang", me.firstName);
    }

    // examples for method reference.
    private static void testMethodReference() {
        // 1. static method. Input is a string, output is Integer.
        Converter<String, Integer> converter = Integer::valueOf;
        Integer intVal = converter.convert("567");
        System.out.println("int value is " + intVal);

        // 2. we can also reference methods:
        Something something = new Something();
        something.s = "Test";
        // 2.1 If input is instance of Something, we can use the following way.
        Converter<Something, String> converter1 = Something::startsWith;
        // 2.2 input is string, output is string. using this way.
        Converter<String, String> converter2 = something::startsWith2;

        String res1 = converter1.convert(something);
        String res2 = converter2.convert("AnotherTest");

        Assert.assertEquals("T", res1);
        Assert.assertEquals("A", res2);
    }
}

@FunctionalInterface
interface PersonFactory<T extends Person> {
    T create(String first, String second);
}

class Person {
    String firstName;
    String lastName;

    Person() {
    }

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

class Something {
    String s;

    String startsWith() {
        return String.valueOf(s.charAt(0));
    }

    String startsWith2(String str) {
        return String.valueOf(str.charAt(0));
    }
}

/**
 * A so called functional interface must contain exactly <b>one abstract method declaration</b>
 *
 * @param <F> Input
 * @param <T> Output
 */
@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
    // The compiler is aware of this annotation and throws a compiler error as soon as you try
    // to add a second abstract method declaration to the interface.
//    void print();
}