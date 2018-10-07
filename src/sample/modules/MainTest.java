package sample.modules;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class MainTest {

    public static void main(String[] args){
        System.out.println("Please enter a paragraph containing over 100 words");
        Scanner rawInput = new Scanner(System.in);
        String unformatted = rawInput.hasNextLine() ? rawInput.nextLine() : "";
        String formatted = unformatted.replaceAll("\\.|\\s+|,|^,\\s+",",").replaceAll(",,",",");
        StringBuilder stringBuilder = new StringBuilder(formatted);
        stringBuilder.setCharAt(formatted.length()-1, Character.MIN_VALUE);
        ArrayList<String> words = new ArrayList<>(){{
            addAll(Arrays.asList(stringBuilder.toString().split(",")));
        }};
        System.out.println(words.size());
        //This is how you can iterate through an array using the method reference of System.out.println();
        words.forEach(System.out::println);
        //This is how you can iterate through an array using a lambda expression.
        words.forEach(word -> System.out.println("Word: " + word + ", Size: " + word.length()));
        //This is how you can iterate through an array using a lambda method.
        AtomicInteger count = new AtomicInteger();
        words.forEach(word -> {
            System.out.println("Word: " + word + ", Size: " + word.length());
            count.getAndIncrement();
            System.out.println(count.get());
        });

    }
}
