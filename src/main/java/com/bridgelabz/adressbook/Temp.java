package com.bridgelabz.adressbook;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Temp {

    public static Map<String,String> giveMap(){
        Map<String, String> gfg = new HashMap<String,String>();

        // enter name/url pair
        gfg.put("GFG", "geeksforgeeks.org");
        gfg.put("Practice", "practice.geeksforgeeks.org");
        gfg.put("Code", "code.geeksforgeeks.org");
        gfg.put("Quiz", "quiz.geeksforgeeks.org");
        return gfg;
    }

    static List<String> giveList(Map<String,String>  gfg) {
        List<String> list1 = null;
        for (String entry : gfg.values()) {
            String obj = entry;
            list1 = Arrays.stream(obj.split("")).toList();
//            list1.forEach(System.out::println);
        }
        return list1;
    }



    public static void main(String[] args) {

        Map<String,String> gfg = giveMap();

        List<String> words = giveList(gfg);

        System.out.println(words.toString());

    }

    //        List<String> list2 =
//                gfg.values().stream()
//                        .collect(
//                                Collectors.toList(
//                                        Function.identity(),
//                                        c -> c.split("").
//
//                                )
//                        );
//    List<String> list1;
//    for (Map.Entry<String,String> entry : gfg.entrySet()){
//        list1 = Arrays.stream(entry.getValue().split("")).toList();
////            list1.forEach(System.out::println);
//    }
//            System.out.println("Key = " + entry.getKey() +
//                    ", Value = " + entry.getValue());
}
