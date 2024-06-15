package com.example.practicals;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamClass {

    public static void main(String[] args) {
       testStream();
    }
    public static void testStream() {
        ArrayList<String> names = new ArrayList();
        names.add("Pooja");
        names.add("Shivansh");
        names.add("Arun");
        names.add("Abhay");
        names.add("Kunal");
        names.add("Shital");
        int count=0;
        for(int i=0;i<names.size();i++){
            String actual=names.get(i);
            if(actual.startsWith("A")){
                count++;
                System.out.println(actual);
            }

        }
    }
@Test
    public void streamFilter() {

        ArrayList<String> names = new ArrayList();
        names.add("Pooja");
        names.add("Shivansh");
        names.add("Arun");
        names.add("Abhay");
        names.add("Kunal");
        names.add("Shital");
        System.out.println("----------------------------------------");
        //count the number of words starts with A
        Long c=names.stream().filter(s->s.startsWith("A")).count();
        System.out.println(c);
        //Give sorted list with alphabet starts with A
    long a=names.stream().filter(s->s.contains("a")).count();
    System.out.println(a);
        List<String> newList = names.stream().filter(s -> s.startsWith("A")).sorted().collect(Collectors.toList());
        System.out.println(newList);
        System.out.println("----------------------------------------");

        // Give whole list in ascending order
        List<String> newList2 = names.stream().sorted().collect(Collectors.toList());
        System.out.println(newList2);

        System.out.println("----------------------------------------");

        //gives names ends with l and print in console
        names.stream().filter(s -> s.endsWith("l")).forEach(s -> System.out.println(s));

        System.out.println("----------------------------------------");
        names.stream().filter(s -> s.startsWith("A")).sorted().collect(Collectors.toList()).forEach(s -> System.out.println(s));

        //create list uisng stream
    Long d=Stream.of("Pooja","Arun","Chetan","Abhay","Shital","shivansh").filter(s->{
      s.startsWith("A");
      return true;
    }).count();
    System.out.println(d);
    }
}
