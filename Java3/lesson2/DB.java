/* Сделать методы для работы с БД
   (CREATE, UPDATE, DELETE, INSERT, SELECT)
*/   

import java.sql.*;

public class DB {
    private static Connection connection;
    private static Statement stmt;
    private static ResultSet result;

    public static void create() {
	try {
            stmt.executeUpdate("CREATE TABLE students (Name CHAR(20), Age INT)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
    public static void update() {
        try {
            stmt.executeUpdate("UPDATE students SET Name = 'Дмитрий' WHERE Age = 10");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
    public static void delete() {
        try {
            stmt.executeUpdate("DELETE TABLE students");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
    public static void insert() {
        try {
            stmt.executeUpdate("INSERT INTO table VALUES ('Александр', 10)");
	    stmt.executeUpdate("INSERT INTO table VALUES ('Петр', 12)");
	    stmt.executeUpdate("INSERT INTO table VALUES ('Василий', 13)");
	    stmt.executeUpdate("INSERT INTO table VALUES ('Никита', 11)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
    public static void select() {
        try (result = stmt.executeQuery("SELECT * FROM sudents")) {
            if(result.next())
	        System.out.println(result.getString(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
    public static void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:mydb.db");
            stmt = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
    public static void main(String[] args) {
        try {
	    connect();
			
	    create();
	    insert();
	    update();
	    select();
	    delete();
	}
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
	    disconnect();
	}
    }
}	
	