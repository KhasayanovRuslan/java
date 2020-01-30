package lesson6;

import java.net.*;
import java.io.*;

public class Client {
    private final int с;
    private Socket socket;
    private InputStream in;
    private OutputStream out;
    private Server server;

    public Client(Server server, Socket socket) {
        try {
            this.socket = socket;
            this.server = server;
            this.in = socket.getInputStream();
            this.out = socket.getOutputStream();

            // сформировать строку запроса
            //создать поток ввода типа BufferedReader,
            //используя стандартный поток ввода System.in
            BufferedReader br = new BufferedReader(new
                    InputStreamReader(System.in));
            String str;
            System.out.println("Клиент: ");
            System.out.println("Bвeдитe строки текста.");
            System.out.println("Bвeдитe 'q' для завершения.");
            do {
                str = br.readLine();
                System.out.println(str);
            } while (!str.equals("q"));

            //преобразовать строку запроса в байты
            byte buf[] = str.getBytes();

            //послать запрос
            out.write(buf);

            // прочитать ответ и вывести его на экран
            while ((с = in.read()) != -1) {
                System.out.print((char) с);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}





    