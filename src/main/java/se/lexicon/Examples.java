package se.lexicon;

import se.lexicon.model.Person;
import se.lexicon.service.People;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Examples {
    private final List<Person> people = People.INSTANCE.getPeople();

    //Methods will be written here.

    public void countPeople(){

        //Creating a stream does not affect the List.
        Stream<Person> stream = people.stream();

        Long count = stream.count();

        System.out.println(count);

//        people.size();
    }

    public Person getOldestPersonDeclarative(){
        Optional<Person> oldest = people.stream()
                .min((Person p1, Person p2) -> p1.getDateOfBirth().compareTo(p2.getDateOfBirth()));

        return oldest.orElseThrow(RuntimeException::new);
    }

    public Person getOldestPersonImperative(){
        Person person = null;
        for (Person p : people) {
            if (person == null){
                person = p;
            }
            if (person.getDateOfBirth().isAfter(p.getDateOfBirth())){
                person = p;
            }
        }
        return Optional.ofNullable(person).orElseThrow(RuntimeException::new);
    }

    public Person getYoungest(){

        Stream<Person> personStream = people.stream();
        Optional<Person> youngest = personStream.max(Comparator.comparing(Person::getDateOfBirth));

        return youngest.orElseThrow(RuntimeException::new);
    }

    public Person findFirst(){
        return people.stream()
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public Person findAny(){
        return people.parallelStream()
                .findAny()
                .orElseThrow(RuntimeException::new);
    }

    public String namesInCommaSeparation(List<String> names){
        return names.stream()
                .reduce("", (s1, s2) -> s1 + "," +s2);
    }

    public Set<Person> CollectToSet(){
        return people.stream()
//                .collect(Collectors.toCollection(() -> new HashSet<>()));
//                .collect(Collectors.toCollection(HashSet::new));
                .collect(Collectors.toSet());
    }

    public Person[] collectToArray(){
        return people.stream()
                .toArray(Person[]::new);
    }

    //      K=LastName V=Person's with That lastName
    public Map<String, List<Person>> toMap(){
        return people.stream()
                .collect(Collectors.groupingBy(person -> person.getLastName()));
    }











}
