/* Задание 1: Прочитать файл (около 50 байт) в байтовый массив
              и вывести этот массив в консоль.
*/

package lesson3;

import java.io.*;

public class ReadFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("C:/Users/Руслан/IdeaProjects/untitled/src/lesson3/file.txt")) {
            byte[] barr  = new byte[512];
            int count;
            if ((count = in.read(barr)) > 0)
                System.out.println(new String(barr, 0, count, "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
