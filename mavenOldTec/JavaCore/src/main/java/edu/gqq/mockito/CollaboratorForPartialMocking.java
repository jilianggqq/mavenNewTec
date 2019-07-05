package edu.gqq.mockito;

public class CollaboratorForPartialMocking {
    public static String staticMethod() {
        return "Hello Baeldung!";
    }

    public final String finalMethod() {
        return "Hello Baeldung!";
    }

    private String privateTestMethod() {
        return "Hello Baeldung!";
    }

    public String privateMethodCaller() {
        return privateTestMethod() + " Welcome to the Java world.";
    }
}
