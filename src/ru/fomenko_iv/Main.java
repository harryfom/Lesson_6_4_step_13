package ru.fomenko_iv;

import java.io.IOException;
import java.io.InputStream;
import java.io.StreamTokenizer;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

/*
 Напишите программу, читающую из System.in текст в кодировке UTF-8, подсчитывающую в нем частоту появления слов, и в
 конце выводящую 10 наиболее часто встречающихся слов.

 Словом будем считать любую непрерывную последовательность символов, состоящую только из букв и цифр. Например, в
 строке "Мама мыла раму 33 раза!" ровно пять слов: "Мама", "мыла", "раму", "33" и "раза".

 Подсчет слов должен выполняться без учета регистра, т.е. "МАМА", "мама" и "Мама" — это одно и то же слово.
 Выводите слова в нижнем регистре.

 Если в тексте меньше 10 уникальных слов, то выводите сколько есть.

 Если в тексте некоторые слова имеют одинаковую частоту, т.е. их нельзя однозначно упорядочить только по частоте,
 то дополнительно упорядочите слова с одинаковой частотой в лексикографическом порядке.

 Задача имеет красивое решение через стримы без циклов и условных операторов. Попробуйте придумать его.

 Sample Input 1:
Мама мыла-мыла-мыла раму!
Sample Output 1:
мыла
мама
раму

Sample Input 2:
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam,
tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus
imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet,
consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.
Sample Output 2:
consectetur
faucibus
ipsum
lorem
adipiscing
amet
dolor
eget
elit
mi

 */
public class Main {
    public static void main(String[] args) throws IOException {
//        System.out.println("6.4 Stream API – Шаг 13");
        //Сделать Stream из System.in
        Scanner scanner = new Scanner(System.in, "UTF-8")
                .useDelimiter("[^\\p{L}\\p{Digit}]+");

        // Сложить в ХЭШ сразу с подсчетом вхождений
        HashMap<String, Integer> hashMap = new HashMap<>();
        scanner.forEachRemaining(n ->
                hashMap.put(n.toLowerCase(),hashMap.get(n.toLowerCase()) == null ? 1 : hashMap.get(n.toLowerCase())+1));

        // Сортируем, ограничиваем кол-во, берем ключ и выводим

        hashMap.entrySet().stream()
                .sorted(new MyComparator())
                .map(Map.Entry::getKey)
                .limit(10)
                .forEach(System.out::println);
    }
//    public static class MyComparator implements Comparator{
//        @Override
//        public int compare(Object o1, Object o2) {
//            if (o1 == o2){
//                return 0;
//            }
//            Map.Entry<String,Integer> e1 = (Map.Entry<String,Integer>)o1;
//            Map.Entry<String,Integer> e2 = (Map.Entry<String,Integer>)o2;
//            int retval = e2.getValue().compareTo(e1.getValue());
//            if (retval == 0) {
//                retval = e1.getKey().compareTo(e2.getKey());
//            }
//            return retval;
//        }
//    }

}
