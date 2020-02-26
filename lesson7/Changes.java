/* Задание: 1. Реализовать личные сообщения, если клиент пишет «/w nick3 Привет», 
               то только клиенту с ником nick3 должно прийти сообщение «Привет»
            2. Реализовать проверку используется ли такой ник уже в чате.
*/

/* Необходимо ввести изменения в ClientHadler.java:
   1. В цикл авторизации: применить метод isNickBusy() для проверки ника;
   2. В цикл обмена сообщениями: применить метод sendMsgToNick()
      для отправки сообщения определенному нику.
*/
while (true) {
    String str = in.readUTF();
    if (str.startsWith("/auth")) {
        String[] tokes = str.split(" ");
        String newNick = AuthService.getNickByLoginAndPass(tokes[1], tokes[2]);
        if (newNick != null) {
            // Применяется метод isNickBusy() для проверки ника
            if (!server.isNickBusy(newNick)) {
                sendMsg("/authok " + newNick);
                nick = newNick;
                server.broadcastMsg(nick + " зашел в чат");
                server.subscribe(ClientHandler.this);
                break;
            } else {
                  sendMsg("Учетная запись уже используется");
            }
        } else {
        sendMsg("Неверный логин/пароль");
        }
    }
} 
 
while (true) {
    String str = in.readUTF();  

    if (str.equals("/end")) {
        out.writeUTF("/serverClosed");
        break;
    }

    // Применяется метод sendMsgToNick() для отправки сообщения определенному нику
    if (str.startsWith("/w" + nick)) {
       System.out.println("Client: " + str);
       str = str.substring(3);
       server.sendMsgToNick(str, nick); 
    }

    System.out.println("Client: " + str);
    server.broadcastMsg(nick + ": " + str); 
}                              

                            
/* Добавление 2 методов в ServerMain.java:
   1. метод isNickBusy() для проверки ника;
   2. метод sendMsgToNick() для отправки сообщения определенному нику.
*/
public void sendMsgToNick(String msg, nick) {
    for (ClientHandler o: clients) {
        if (o.nick.equals(nick)) o.sendMsg(msg);
    }
}

public boolean isNickBusy(String nick) {
    for (ClientHandler o: clients) {
        if (o.nick.equals(nick)) return true;
    }
    return false;
}