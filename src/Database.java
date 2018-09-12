import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Database implements DatabaseProperties {
    static Connection con;
    static Statement statement = null;
    static boolean running = true;

    public static void main(String args[]) {
        test();
    }

    public static void test() {

        loop:
        while (running) {
            System.out.println(running);
            Scanner userInputScanner = new Scanner(System.in);
            System.out.println("If you would like to test your connection to: '" + (databaseName) + "', please press 'test conn'.");
            System.out.println("If you would like to see what tables are held within: '" + (databaseName) + "', please press 'ls tables'.");
            System.out.println("If you would like to see a description of a table, please enter a valid table held in: '" + (databaseName) + "'.");
            System.err.println("If you would like to quit, please type: 'exit'.");
            String userInput = userInputScanner.nextLine();
            switch (userInput.toLowerCase()) {
                case "exit": {
                    System.out.println("exiting...");
                    running = false;
                    break loop;
                }
                case "test conn": {
                    //System.out.println(1);
                    System.out.println(connect());
                    System.out.println(" ");
                }
                break;
                case "ls tables": {
                    //System.out.println(2);
                    var tables = getTables(databaseName);
                    switch (tables.size()) {
                        case 0: {
                            System.out.println("The database: " + databaseName + " is empty.");
                        }
                        break;
                        case 1: {
                            System.out.println("The database: " + databaseName + " has 1 table:");
                        }
                        break;
                        default: {
                            System.out.println("The database: " + databaseName + " has " + tables.size() + " tables:");
                        }
                    }
                    for (String tableName : tables) {
                        System.out.println(tableName);
                        System.out.println(" ");
                    }
                }
                break;
                default: {
                    //System.out.println(3);
                    var listOfComparableTables = getTables(databaseName);
                    for (String tableName_ : listOfComparableTables) {
                        //System.out.println("Found name in list: " + tableName_ + " compared to: " + userInput + ": " + tableName_.contains("Table : " + userInput));
                        getTableInfo(userInput);
                        break;
                    }
                    System.out.println(4);
                    System.out.println("What you have requested is not a valid option, please type: 'ls tables' to view all tables if you are trying to see the contents of a table.");
                    System.out.println(" ");
                    System.out.println(" ");
                    //test();

                }
            }
        }
    }

    public static String connect() {
        String connection = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection((host + databaseName), userName, passWord);
            statement = con.createStatement();
            connection = "You have successfully connected to:" + (host + databaseName);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static ArrayList<String> getTables(String databaseName) {
        var listOfTables = new ArrayList<String>();
        try {
            connect();
            DatabaseMetaData metadata = con.getMetaData();


            // Specify the type of object; in this case we want tables

            String[] types = {"TABLE"};

            ResultSet resultSet = metadata.getTables(null, null, "%", types);


            while (resultSet.next()) {

                String tableName = resultSet.getString(3);
                String tableCatalog = resultSet.getString(1);
                String tableSchema = resultSet.getString(2);
                if (!tableName.contains("sys"))
                    listOfTables.add("Table : " + tableName + " || nCatalog : " + tableCatalog + " || nSchema : " + tableSchema);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listOfTables;
    }

    public static void getTableInfo(String tableName) {
        try {
            connect();
            String strQuery = "SELECT * FROM $tableName";
            String query = strQuery.replace("$tableName", tableName);
            PreparedStatement statement = con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();

            int rowCount = metaData.getColumnCount();

            System.out.println("Table Name : " + metaData.getTableName(2));
            System.out.println("Field \tsize\tDataType");

            for (int i = 0; i < rowCount; i++) {
                System.out.print(metaData.getColumnName(i + 1) + " \t");
                System.out.print(metaData.getColumnDisplaySize(i + 1) + "\t");
                System.out.println(metaData.getColumnTypeName(i + 1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void show(String user) throws SQLException {
        PreparedStatement statement = con.prepareStatement("SELECT * FROM user WHERE username=?");
        statement.setString(1, user);
        ResultSet storedPassword = statement.executeQuery();
        int count = 0;
        while (storedPassword.next()) {
            count++;
            System.out.println(user + " || " + storedPassword.getInt(1));
            System.out.println(user + " || " + storedPassword.getString(2));
            System.out.println(user + " || " + storedPassword.getString(3));
            System.out.println(user + " || " + storedPassword.getString(4));
            System.out.println(user + " || " + storedPassword.getString(5));
            System.out.println(user + " || " + storedPassword.getString(6));
            System.out.println(user + " || " + storedPassword.getInt(7));
            System.out.println(user + " || " + storedPassword.getInt(8));
            System.out.println(user + " || " + storedPassword.getString(9));

        }
    }

    /*public boolean login(String username_, String password_, boolean remember) {
        userJSONManager user = new userJSONManager("userData.json");
        if (remember) {
            user.setRememberMe(true);
        } else {
            user.setRememberMe(false);
        }
        try {
            show(username_);
            PreparedStatement statement = con.prepareStatement("SELECT password FROM user WHERE username=?");
            statement.setString(1, username_);
            ResultSet storedPassword = statement.executeQuery();
            String passwordStored = "";
            while (storedPassword.next()) {
                passwordStored = storedPassword.getString(1);
            }
            if (passwordStored.equals(password_)) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    public void signup(String email, String username, String password, boolean is18) {
        userJSONManager userjson = new userJSONManager("userData.json");
        userjson.signup(username, password, null);
        try {
            String ipAddress = InetAddress.getLocalHost().toString();

            String age = "-18";
            if (is18) {
                age = "+18";
            }
            String query = "SELECT count(*) FROM user";
            ResultSet result = statement.executeQuery(query);
            int size = 0;
            while (result.next()) {
                size = result.getInt(1);
            }
            statement.executeUpdate("INSERT INTO user " + "VALUES ( " + (size) +
                    ", '" + email +
                    "', '" + age +
                    "', '" + username.toLowerCase() +
                    "', '" + password +
                    "', '" + 0 +
                    "', '" + 0 +
                    "', '" + 0 +
                    "', '" + 0 +
                    "', '" + ipAddress +
                    "')");
        } catch (UnknownHostException | SQLException e) {
            e.printStackTrace();
        }
    }*/

    public void clearUsers() {
        try {
            String sql = "TRUNCATE user";
            // Execute deletion
            statement.executeUpdate(sql);
            // Use DELETE
            sql = "DELETE FROM user";
            // Execute deletion
            statement.executeUpdate(sql);
            return;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String fetchUserAndPass(String condition, String emailAddress) {
        try {
            PreparedStatement statement = con.prepareStatement("SELECT " + condition + " FROM user WHERE email=?");
            statement.setString(1, emailAddress);
            ResultSet storedPassword = statement.executeQuery();
            String passwordStored = "";
            while (storedPassword.next()) {
                passwordStored = storedPassword.getString(1);
            }
            return passwordStored;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }
}
