/* Внести изменения в ClientHadler.java:
   1. Первое изменение: создать таблицу blacklist и заполнить ее;
   2. Второе изменение: изменить метод checkBlackList() для использования созданной таблицы.
*/

while (true) {
    String str = in.readUTF();
    if (str.startsWith("/")) {
        if (str.equals("/end")) {
            out.writeUTF("/serverclosed");
            break;
        }
        if (str.startsWith("/w ")) { // /w nick3 lsdfhldf sdkfjhsdf wkerhwr
            String[] tokens = str.split(" ", 3);
        //  String m = str.substring(tokens[1].length() + 4);
            server.sendPersonalMsg(ClientHandler.this, tokens[1], tokens[2]);
        }
        if (str.startsWith("/blacklist ")) { // /w nick3 lsdfhldf sdkfjhsdf wkerhwr
            String[] tokens = str.split(" ");
        //  blackList.add(tokens[1]);

            //Первое изменение
            stmt.executeUpdate("CREATE TABLE blacklist (id_user VARCHAR(100), id_black_user VARCHAR(100)");
            String thisNick = ClientHandler.this.getNick();
            String idUser = stmt.executeQuery("SELECT id FROM main WHERE nickname = '%s'", thisNick);
            String idBlackUser = stmt.executeQuery("SELECT id FROM main WHERE nickname = '%s'", tokens[1]);
            stmt.executeUpdate("INSERT INTO blacklist (id_user, id_black_user) VALUES (%s, %s)", (idUser, idBlackUser));
                                    
            sendMsg("Вы добавили пользователя  " + tokens[1] + " в черный список!");
        }
    } else {
                            

//Второе изменение
public boolean checkBlackList(String nick) throws SQLException {
    try (ResultSet result = stmt.executeQuery("SELECT * FROM blacklist")) {
        if (result.next()) {
            String thisNick = ClientHandler.this.getNick();
            String idUser = stmt.executeQuery("SELECT id FROM main WHERE nickname = '%s'", thisNick);
            String idBlackUser = stmt.executeQuery("SELECT id FROM main WHERE nickname = '%s'", nick);
            if (idUser = result.getString(1) & idBlackUser = result.getString(2)) return true;
        }
        return false;
    }
    catch (SQLException e) {
        for (Throwable t : e)
            t.printStackTrace();        
    }
}
