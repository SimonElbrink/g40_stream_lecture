package se.lexicon;


import se.lexicon.model.Person;
import se.lexicon.model.PersonDto;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

/**
 * Hello world!
 *
 */
public class App 
{



    public static void main(String[] args )
    {
        Examples examples = new Examples();

        //Examples will be executed here.

//        examples.countPeople();
//        System.out.println("examples.getOldestPerson() = " + examples.getOldestPerson());
//        System.out.println(examples.getOldestPersonImperative());

//        System.out.println(examples.findFirst());
//        System.out.println(examples.findAny());

//        List<String> names = Arrays.asList(
//                "Simon", "Ulf", "Erik", "Mehrdad"
//        );
//
//        String commaSeparatedNameString = examples.namesInCommaSeparation(names).replaceFirst(",", "");
//
//        System.out.println(commaSeparatedNameString);


//        examples.toMap().forEach((lastName, personList) -> {
//                System.out.println(lastName);
//                personList.forEach(System.out::println);
//            }
//        );

//        examples.toMapBoolean().forEach((aBoolean, personList) -> {
//            System.out.println(aBoolean);
//            personList.forEach(System.out::println);
//        });

//        Person foundPersonById = examples.findById(9001);
//
//        System.out.println(foundPersonById);

//
//        List<Person> names = examples.findByLastName("Nilsson");
//        names.forEach(System.out::println);

//        LocalDate[] calenderOfYear2025 = examples.createCalenderYear(2025);
//        Arrays.stream(calenderOfYear2025)
//                .forEach(System.out::println);

//        List<PersonDto> fullNamesOfADate = examples.findByBirthdateYearReturnFullName(1997);

//        fullNamesOfADate.forEach(System.out::println);

        List<Person> sortedCollection = examples.getSortedCollection();
        sortedCollection.forEach(System.out::println);





    }
}
