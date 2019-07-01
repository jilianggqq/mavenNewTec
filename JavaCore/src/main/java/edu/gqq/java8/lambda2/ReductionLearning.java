package edu.gqq.java8.lambda2;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReductionLearning {

    /**
     * The first one reduces a stream of elements to exactly one element of the stream.
     */
    @Test
    public void testReduce1() {
        List<Person> persons = Arrays.asList(new Person("Max", 18), new Person("Peter", 24), new Person("Pamela", 23), new Person("David", 12));
        persons.stream().reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2).ifPresent(System.out::println);
        int addAge = persons.stream().mapToInt(x -> x.getAge()).reduce(0, (a1, a2) -> a1 + a2);
        assertEquals(77, (int) addAge);

        // creating a list of Strings
        List<String> words = Arrays.asList("GFG", "Geeks", "for",
                "GeeksQuiz", "GeeksforGeeks");

        // 2(important). When a stream executes in parallel, the Java runtime splits the stream into multiple substreams.
        // In such cases, we need to use a function to combine the results of the substreams into a single one.
        //  This is the role of the combiner – in the above snippet, it’s the Integer::sum method reference.
        // The lambda expression passed to
        // reduce() method takes two Strings
        // and returns the the longer String.
        // The result of the reduce() method is
        // an Optional because the list on which
        // reduce() is called may be empty.
        Optional<String> reduce = words.stream().reduce((x, y) -> x.length() >= y.length() ? x : y);
        System.out.println(reduce.isPresent() ? reduce.get() : "no value");

        // 3. To put it simply,  if we use sequential streams and the types of the accumulator arguments and the types of its implementation match, we don’t need to use a combiner.
        List<Person> users = Arrays.asList(new Person("John", 30), new Person("Julie", 35));
        int computedAges = users.stream().reduce(0, (partialAgeResult, user) -> partialAgeResult + user.getAge(), (x, y) -> x + y);
        String contactName = users.stream().reduce("", (contactStr, user) -> contactStr + user.getName(), String::concat);
        Assert.assertEquals(65, computedAges);
        Assert.assertEquals("JohnJulie", contactName);
    }

    /**
     * The second reduce method accepts both an identity value and a BinaryOperator accumulator. <br>
     * This method can be utilized to construct a new Person with the aggregated names and ages from all other persons in the stream:
     */
    @Test
    public void testReduce2() {
        List<Person> persons = Arrays.asList(new Person("Max", 18), new Person("Peter", 24), new Person("Pamela", 23), new Person("David", 12));

        Person result =
                persons
                        .stream()
                        .reduce(new Person("", 0), (p1, p2) -> {
                            p1.setAge(p1.getAge() + p2.getAge());
                            p1.setName(p1.getName() + p2.getName());
                            return p1;
                        });

        System.out.format("name=%s; age=%s", result.getName(), result.getAge());
        // name=MaxPeterPamelaDavid; age=76


    }

    /**
     * The third reduce method accepts three parameters:<br>
     * an identity value, a BiFunction accumulator and a combiner function of type BinaryOperator.
     */
    @Test
    public void testReduce3() {
        List<Person> persons = Arrays.asList(new Person("Max", 18), new Person("Peter", 24), new Person("Pamela", 23), new Person("David", 12));
        Integer addAge = persons.stream().reduce(0, (p, v) -> {
            System.out.format("accumulator: sum=%s; person=%s\n", p, p);
            return p += v.getAge();
        }, (x, y) -> {
            System.out.format("combiner: sum1=%s; sum2=%s\n", x, y);
            return x + y;
        });

        IntSummaryStatistics addAge2 = persons.stream().collect(Collectors.summarizingInt(x -> x.getAge()));
        // G.println(addAge);
        // how to get a sum (mapToInt is really wonderful).
        int addAge3 = persons.stream().mapToInt(p -> p.getAge()).sum();

        assertEquals(77, (int) addAge);
        assertEquals(77, (int) addAge3);
        assertEquals(77, addAge2.getSum());

    }
}
