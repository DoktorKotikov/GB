package DB;

import java.sql.*;

public class Main {
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement ps;
    private static CallableStatement cs;

    public static void main(String[] args) {
        try {
            connect();
            dropAndCreate();
            prepareStatement();

            readExample();

//            cs = connection.prepareCall("{call insertPerson(?, ?, ?)}");
//            cs.setString(1, "ggg");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    private static void someMethod() throws SQLException {
        statement.executeUpdate("insert into students (name, score) values ('Petya', 50);");
        Savepoint savepoint = connection.setSavepoint();
        statement.executeUpdate("insert into students (name, score) values ('Vasya', 80);");
        connection.rollback(savepoint);
        statement.executeUpdate("insert into students (name, score) values ('Jorik', 100);");
        connection.setAutoCommit(true);
    }

    private static void readExample() throws SQLException {
        try (ResultSet rs = statement.executeQuery("select * from students where id < 10;")) {
            while (rs.next()){
                System.out.println(rs.getInt(1) );
            }
        }
    }

    private static void batchExample() throws SQLException {
        connection.setAutoCommit(false);
        long now = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++){
            ps.setString(1, "Vasya" + i + 1);
            ps.setInt(2, 100 + i);
            ps.addBatch();
        }
        ps.executeBatch();
        connection.commit();
        System.out.println((System.currentTimeMillis()- now) / 1000);
    }

    private static void prepareStatement() throws SQLException {
        ps = connection.prepareStatement("insert into students (name, score) values (?, ?);");
    }

    private static void deleteExample() throws SQLException {
        statement.execute("delete from students where id = 1;");
    }

    private static void updateExample() throws SQLException {
        statement.executeUpdate("update students set name = 'Petya' where name = 'Vasya';");
    }

    private static void insertExample() throws SQLException {
        statement.executeUpdate("insert into students (name, score) values ('Vasya', 500);");
    }

    private static void dropAndCreate() throws SQLException {
        //statement.executeUpdate("DROP table if exists students;");
        statement.executeUpdate("CREATE table if not exists students (id integer primary key autoincrement, name text, score integer);");
    }

    private static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:somedb.db");
        statement = connection.createStatement();
    }

    private static void disconnect() {
        try {
            if (statement != null) statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            if (connection != null) connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
