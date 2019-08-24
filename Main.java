import java.io.File;
import java.util.Collection;
import java.util.Map;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.TreeMap;
/*
Делает: открывает файл; считывает значения; сортирует по порядку;
считает, сколько раз повторяется слово;выводит слово, встречающееся
максимальное количество раз  его частоту, если таких слов несколько, выводит все;

Не делает: не работает с русским текстом;
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
       Scanner scanner=new Scanner(new File("test.txt"));
       Map<String,Integer>statistics=new TreeMap<>();
       Collection<String>collection=statistics.keySet();


       Integer max=0;
       double all=0;
       while(scanner.hasNext()){
           String word=scanner.useDelimiter("\\s+|,+|\\.+|;+|'+|\"+").next();
           Integer cout=statistics.get(word);
           if(cout==null){
               cout=0;
           }
           statistics.put(word, ++cout);
           all++;

           if (statistics.get(word)>max){
               max=statistics.get(word);
           }
           }
       for (Map.Entry item:
                statistics.entrySet()) {
            System.out.println(item);
       }
        System.out.println("Maximum:");

        for (String key:
             collection) {
            Integer i=statistics.get(key);
            if(max.equals(i)){
                System.out.print(key+" ");
                System.out.println("repeat "+max+" times");
                System.out.println("frequency:"+max/all);

        }


        }




    }

}
