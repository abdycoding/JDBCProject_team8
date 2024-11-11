package Utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DBUtility {
    private static Connection connection;
    public static Statement statement;


    public static ArrayList<ArrayList<String>> getListData(String sorgu) throws SQLException {
        DBConnectionOpen();
        ArrayList<ArrayList<String>> data= new ArrayList<>();
        try {


            ResultSet rs = statement.executeQuery(sorgu);
            ResultSetMetaData rsmd = rs.getMetaData();
            rsmd.getColumnCount();

            while (rs.next()) {
                List<String> row = new ArrayList<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    row.add(rs.getString(i) + "\t");
                }
                data.add((ArrayList<String>) row);
            }
        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        DBConnectionCLose();

        return data;
    }

    public static void DBConnectionOpen() {
        String url="jdbc:mysql://demo.mersys.io:33906/employees";
        String username="student";
        String password="DEkzTd3#pzPm";;

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void DBConnectionCLose() {
        try {

            connection.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
