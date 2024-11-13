package Tasks;

import Utilities.DBUtility;

import java.sql.ResultSet;
import java.sql.SQLException;

public class task_22a extends DBUtility {
    public static void main(String[] args) throws SQLException {
        DBConnectionOpen();

        String sql = "  select count(distinct employees.first_name) as Unique_First_Name\n" +
                " from employees;";

        ResultSet resultSet = statement.executeQuery(sql);

        System.out.println(" a: Find out how many employees have unique first names");
        while (resultSet.next()) {
            // Example of processing the data, adjust as needed based on column names
            int Unique_First_Name = resultSet.getInt("Unique_First_Name");
            System.out.println( "Unique_First_Name: " + Unique_First_Name );
        }

        DBConnectionCLose();



    }
}
