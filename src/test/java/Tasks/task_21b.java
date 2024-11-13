package Tasks;

import Utilities.DBUtility;

import java.sql.ResultSet;
import java.sql.SQLException;

public class task_21b extends DBUtility {
    public static void main(String[] args) throws SQLException {
        DBConnectionOpen();

        String sql = "select count(*) as NumberOfEmployees from employees\n" +
                "where employees.gender='F';";

        ResultSet resultSet = statement.executeQuery(sql);

        System.out.println("b: Determine the count of female employees");
        while (resultSet.next()) {
            // Example of processing the data, adjust as needed based on column names
            int NumberOfEmployees = resultSet.getInt("NumberOfEmployees");



            System.out.println( "NumberOfEmployees: " + NumberOfEmployees );
        }

        DBConnectionCLose();



    }
}
