package se.lexicon;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

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

        examples.toMap().forEach((s, personList) -> {
            System.out.println(s);
            personList.forEach(System.out::println);
        });



    }
}
