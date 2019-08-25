import java.io.File;
import java.util.Collection;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
/*
Исправлено: добавлена обработка длинных тире, многоточия и ковычки



 */
public class Main {
    public static void main(String[] args) {
       try {
           String path = "";
           if (path==""){
               Scanner in=new Scanner(System.in);
               System.out.println("Введите путь к файлу: ");
               path = in.nextLine();

           }
           Scanner scanner = new Scanner(new File(path));
           //Добавила "Cp1251", что бы у меня распознавало кириллицу

         /*JButton open = new JButton();
           JFileChooser fc = new JFileChooser();
           fc.setCurrentDirectory(new java.io.File("*.txt"));
           fc.setDialogTitle("Open your TestFile");
           fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
           if(fc.showOpenDialog(open)==JFileChooser.APPROVE_OPTION){
               System.out.println("You chose: " + fc.getSelectedFile().getAbsolutePath());
           }

          */

           Map<String, Integer> statistics = new TreeMap<>();
           Collection<String> collection = statistics.keySet();


           Integer max = 0;
           double all = 0;
           while (scanner.hasNext()) {
               String word = scanner.useDelimiter("[\\s,-.;:()\"—…]+").next();
               Integer cout = statistics.get(word);
               if (cout == null) {
                   cout = 0;
               }
               statistics.put(word, ++cout);
               all++;

               if (statistics.get(word) > max) {
                   max = statistics.get(word);
               }
           }
           for (Map.Entry item :
                   statistics.entrySet()) {
               System.out.println(item);
           }
           System.out.println("Maximum:");

           for (String key :
                   collection) {
               Integer i = statistics.get(key);
               if (max.equals(i)) {
                   System.out.print(key + " ");
                   System.out.println("repeat " + max + " times");
                   System.out.println("frequency:" + max / all);


               }


           }
       } catch (Exception e){
           System.out.println("Файл не найден!");
       }




    }

}
