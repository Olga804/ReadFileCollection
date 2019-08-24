import java.io.File;
import java.util.Map;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.TreeMap;
/*
Делает: открывает файл; считывает значения; сортирует по порядку;
считает, сколько раз повторяется слово; предусмотрен ввод абсолютного пути к файлу;
работает только с латиницей;

Не делает: вывести слово встречающееся максимальное количество раз и его частоту повторений;
предусмотреть ввод относительного пути к файлу; ввод русских букв в файле;
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
       Scanner scanner=new Scanner(new File("C:\\test.txt"));
       Map<String,Integer>statistics=new TreeMap<>();



       while(scanner.hasNext()){
           String word=scanner.useDelimiter("\\s+").next();
           Integer cout=statistics.get(word);
           if(cout==null){
               cout=0;
           }
           statistics.put(word, ++cout);

           }
       for (Map.Entry item:
                statistics.entrySet()) {
            System.out.println(item);

       }

    }

}