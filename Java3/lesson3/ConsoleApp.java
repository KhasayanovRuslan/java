/* Задание 3: Написать консольное приложение, которое умеет постранично читать текстовые файлы (размером > 10 mb).
              Вводим страницу (за страницу можно принять 1800 символов), программа выводит ее в консоль.
              Контролируем время выполнения: программа не должна загружаться дольше 10 секунд,
              а чтение – занимать свыше 5 секунд.
*/

package lesson3;

import java.io.*;
import java.util.*;

public class ConsoleApp {
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("demo.txt"))) {
            Scanner scan = new Scanner(System.in);

            System.out.println("Ввeдитe строки текста.");

            long tt = 0;
            long t = System.currentTimeMillis();
            while(scan.hasNextLine()) {
                String str = scan.nextLine();
                if (str.equals("конец")) break;
                tt = System.currentTimeMillis()-t;
                writer.write(str);
            }
            System.out.println(System.currentTimeMillis()-t-tt);

            scan.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("demo.txt"))) {
            String str;

            long t = System.currentTimeMillis();
            while((str = reader.readLine()) != null ) {
                System.out.println(str);
            }
            System.out.println(System.currentTimeMillis()-t);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
