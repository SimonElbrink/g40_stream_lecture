package se.lexicon;

import se.lexicon.model.Gender;
import se.lexicon.model.Person;
import se.lexicon.model.PersonDto;
import se.lexicon.service.People;

import java.time.LocalDate;
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
        Optional<Person> youngest =
                personStream
                .max(Comparator.comparing(Person::getDateOfBirth));

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

    public Set<Person> collectToSet(){
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

    public Map<Boolean, List<Person>> toMapBoolean(){
        return people.stream()
                .collect(Collectors.partitioningBy(person -> person.getGender().equals(Gender.FEMALE)));
    }


    public Person findById(int id){
        return people.stream()
                .filter(person -> person.getPersonId() == id)
                .findFirst()
                .orElseThrow(RuntimeException::new);

//        for (Person p : people) {
//            if (p.getPersonId() == id){
//                return p;
//            }
//        }
//        return null;
    }


    public List<Person> findByLastName(String lastname){
        return people.stream()
                .filter(person -> person.getLastName().equals(lastname))
//                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
                .collect(Collectors.toList());
    }

    public List<PersonDto> findByBirthdateYearReturnFullName(int year){
        return people.stream()
//                .peek(System.out::println)
                .filter(person -> person.getDateOfBirth().getYear() == year)
//                .peek(System.out::println) // After Filtering
//                .map(person -> person.getFirstName() + " " + person.getLastName())
//                .map(person -> new PersonDto(person.getPersonId(), person.getFirstName() + " " + person.getLastName()))
//                .map((person -> convert(person)))
                .map(this::convert)
                //Peek after converting to personDto
                .peek(System.out::println)
                .collect(Collectors.toCollection( ArrayList::new));

    }

    private PersonDto convert(Person person){
        if (person == null) return null;
        return new PersonDto(person.getPersonId(), person.getFirstName() + " " + person.getLastName());
    }


    public LocalDate[] createCalenderYear(int year){

        LocalDate seed = LocalDate.ofYearDay(year, 1);

        return Stream.iterate(seed, (date) -> date.plusDays(1))
                .limit(seed.isLeapYear() ? 366 : 365)
                .toArray(LocalDate[]::new);
    }


    public List<Person> getSortedCollection(){
        return people.stream()
                .sorted(
                        Comparator.comparing(Person::getLastName)
                                .thenComparing(Person::getFirstName)
                                .thenComparing(Person::getDateOfBirth)
                                .thenComparing(Person::getPersonId)
                )
                .collect(Collectors.toList());
    }














}
