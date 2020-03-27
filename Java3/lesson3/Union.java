/* Задание 2: Последовательно сшить 5 файлов в один
   (файлы примерно 100 байт). Может пригодиться следующая конструкция: ArrayList<InputStream>
   al = new ArrayList<>(); ... Enumeration<InputStream> e = Collections.enumeration(al);
*/

package lesson3;

import java.util.*;
import java.io.*;

public class Union {
    public static void main(String[] args) throws IOException {
        ArrayList<InputStream> al = new ArrayList<>();
        al.add(new FileInputStream("C:/Users/Руслан/IdeaProjects/untitled/src/lesson3/1.txt"));
        al.add(new FileInputStream("C:/Users/Руслан/IdeaProjects/untitled/src/lesson3/2.txt"));
        al.add(new FileInputStream("C:/Users/Руслан/IdeaProjects/untitled/src/lesson3/3.txt"));
        al.add(new FileInputStream("C:/Users/Руслан/IdeaProjects/untitled/src/lesson3/4.txt"));
        al.add(new FileInputStream("C:/Users/Руслан/IdeaProjects/untitled/src/lesson3/5.txt"));

        SequenceInputStream in = new SequenceInputStream(Collections.enumeration(al));
        int x;
        while ((x = in.read()) != -1) {
            System.out.print((char)x);
        }
        in.close();
    }
}

