package edu.gqq.mockito;

public class CollaboratorForPartialMocking {
    private String _value;

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

    public String privateFieldCaller() {
        return this._value;
    }
}
