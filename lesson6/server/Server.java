package lesson6;

import java.net.*;
import java.io.*;

public class Server {
    private final int �;
    private InputStream in;
    private OutputStream out;

    public Server() {
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(8000);
            System.out.println("������ �������!");

            while (true) {
                socket = server.accept();
                System.out.println("������ �����������");
                new Client(this, socket);
            }

            BufferedReader br = new BufferedReader(new
                    InputStreamReader(System.in));
            String str;
            System.out.println("������: ");
            System.out.println("B�e���e ������ ������.");
            System.out.println("B�e���e 'q' ��� ����������.");
            do {
                str = br.readLine();
                System.out.println(str);
            } while (!str.equals("q"));

            byte buf[] = str.getBytes();

            out.write(buf);
            
            while ((� = in.read()) != -1) {
            System.out.print((char) �);
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
