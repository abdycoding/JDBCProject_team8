package Tasks;

import Utilities.DBUtility;

import java.sql.ResultSet;
import java.sql.SQLException;

public class task_21c extends DBUtility {
    public static void main(String[] args) throws SQLException {
        DBConnectionOpen();

        String sql = "select count(*) as NumberOfEmployees from employees\n" +
                "group by employees.gender;";

        ResultSet resultSet = statement.executeQuery(sql);

        System.out.println("c: Find the number of male and female employees by grouping:");
        while (resultSet.next()) {
            // Example of processing the data, adjust as needed based on column names
            int NumberOfEmployees = resultSet.getInt("NumberOfEmployees");

            System.out.println( "NumberOfEmployees: " + NumberOfEmployees );
        }

        DBConnectionCLose();



    }
}
