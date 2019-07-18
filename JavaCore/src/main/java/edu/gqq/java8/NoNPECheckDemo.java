package edu.gqq.java8;


import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

public class NoNPECheckDemo {
    public static void main(String[] args) {
        Outer outer = new Outer();

        /**
         * The flowing code helps you to understand Function.
         *
         */
//        1. basic one.
        Function<Outer, Nested> getNested1 = new Function<Outer, Nested>() {
            @Override
            public Nested apply(Outer outer) {
                return null;
            }
        };

        // 2. lambda expression.
        Function<Outer, Nested> getNested2 = outer2 -> {
            return new Nested();
        };

        // 3. Class way.
        Function<Outer, Nested> nested3 = Outer::getNested; // input is Outer instance, output is Nested instance.

        method1(outer);

        method2(outer);
    }

    private static void method2(Outer outer) {
        resolve(() -> outer.getNested().getInner().getFoo())
                .ifPresent(System.out::println);
    }

    private static <T> Optional<T> resolve(Supplier<T> supplier) {
        try {
            return Optional.ofNullable(supplier.get());
        } catch (NullPointerException e) {
            return Optional.empty();
        }
    }


    private static void method1(Outer outer) {
        outer.nested = new Nested();
        outer.nested.inner = new Inner();
        outer.nested.inner.foo = "foo in inner";

        Optional<Inner> inner1 = Optional.of(outer)
                .map(outer1 -> outer1.getNested())
                .map(nested -> nested.getInner());


        Optional<String> foo = Optional.of(outer)
                .map((Outer::getNested))
                .map(Nested::getInner)
                .map(Inner::getFoo);

        //the same as inner1.ifPresent(inner -> System.out.println(inner));
        //only one parameter can use the following abbreviated way.
        foo.ifPresent(System.out::println);
        foo.ifPresentOrElse(System.out::println, () -> System.out.println("foo is null"));
    }

}

class Outer {
    Nested nested;

    Nested getNested() {
        return nested;
    }
}

class Nested {
    Inner inner;

    Inner getInner() {
        return inner;
    }
}

class Inner {
    String foo;

    String getFoo() {
        return foo;
    }
}