package edu.gqq.java8.lambda2;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.function.IntConsumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.Test;

public class CollectorsLearning {

    public void testIntConsumer(IntConsumer i, int v) {
        i.accept(v);
    }

    List<Person> persons = Arrays.asList(new Person("Max", 18), new Person("Peter", 23), new Person("Pamela", 23), new Person("David", 12));

    @Test
    public void testOwnCollector() {
        Collector<Person, StringJoiner, String> personNameCollector = Collector.of(() -> new StringJoiner(" | "), // supplier
                (j, p) -> j.add(p.getName().toUpperCase()), // accumulator
                (j1, j2) -> j1.merge(j2), // combiner
                StringJoiner::toString); // finisher

        // Collector is hard to design, so I think I just use it right now.
        // Collector<Person, ArrayList<String>, String> personNameCollector2 = Collector.of(() -> new ArrayList<String>(), // supplier
        // (j, p) -> {
        // j.add(p);
        // return j;
        // } , (a1, a2) -> {
        // a1.addAll(a2);
        // } , x->x.toString());

        String names = persons.stream().collect(personNameCollector);

        System.out.println(names); // MAX | PETER | PAMELA | DAVID
    }

    @Test
    public void testCollect() {

        // 1. you can deep understand what is IntConsumer.
        testIntConsumer(x -> System.out.println(x), 3);
        testIntConsumer((int x) -> {
            System.out.println(x);
        }, 3);

        testIntConsumer(new IntConsumer() {

            @Override
            public void accept(int value) {
                // TODO Auto-generated method stub
                System.out.println(value);
            }
        }, 8);

        IntConsumer intConsumer = new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println("accept value : " + value);
            }
        };

        // 5. to list
        List<Person> filtered = persons.stream().filter(p -> p.getName().startsWith("P")).collect(Collectors.toList());

        System.out.println(filtered); // [Peter, Pamela]

        // 4.group by
        Map<Integer, List<Person>> personsByAge = persons.stream().collect(Collectors.groupingBy(p -> p.getAge()));

        personsByAge.forEach((age, p) -> System.out.format("age %s: %s\n", age, p));

        // 3. average Int.
        Double averageAge = persons.stream().collect(Collectors.averagingInt(p -> p.getAge()));

        System.out.println(averageAge); // 19.0

        IntSummaryStatistics ageSummary = persons.stream().collect(Collectors.summarizingInt(p -> p.getAge()));

        System.out.println(ageSummary);
        // IntSummaryStatistics{count=4, sum=76, min=12, average=19.000000, max=23}

        // 2. join string use collector.
        String phrase = persons.stream().filter(p -> p.getAge() >= 18).map(p -> p.getName()).collect(Collectors.joining(" , ", "In Germany ", " are of legal age."));

        System.out.println("join phrase is " + phrase);

        // 1.convert to map
        Map<Integer, String> map = persons.stream().collect(Collectors.toMap(p -> p.getAge(), p -> p.getName(), (name1, name2) -> name1 + ";" + name2));

        System.out.println("final map is " + map);
        // {18=Max, 23=Peter;Pamela, 12=David}
    }
}

class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name;
    }
}
