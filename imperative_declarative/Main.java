package imperative_declarative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static imperative_declarative.Main.Gender.*;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
          new Person("name1", MALE),
          new Person("name2", FEMALE),
          new Person("name3", FEMALE),
          new Person("name4", MALE),
          new Person("name5", FEMALE)
        );

        //Imperative Approach -- emirsel
        List<Person> females = new ArrayList<>();

        for(Person person : people) {
            if(FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }

        for (Person female: females) {
            System.out.println(female);
        }

        //Declarative approach -- bildirimsel
        final Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender); //extract variable opt+command+v
        people.stream()
                .filter(personPredicate)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    static class Person{
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender='" + gender + '\'' +
                    '}';
        }
    }

    enum Gender{
        MALE,FEMALE
    }
}
