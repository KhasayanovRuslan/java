package lesson6;

import java.net.*;
import java.io.*;

public class Server {
    private final int с;
    private InputStream in;
    private OutputStream out;

    public Server() {
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(8000);
            System.out.println("Сервер запущен!");

            while (true) {
                socket = server.accept();
                System.out.println("Клиент подключился");
                new Client(this, socket);
            }

            BufferedReader br = new BufferedReader(new
                    InputStreamReader(System.in));
            String str;
            System.out.println("Сервер: ");
            System.out.println("Bвeдитe строки текста.");
            System.out.println("Bвeдитe 'q' для завершения.");
            do {
                str = br.readLine();
                System.out.println(str);
            } while (!str.equals("q"));

            byte buf[] = str.getBytes();

            out.write(buf);
            
            while ((с = in.read()) != -1) {
            System.out.print((char) с);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
