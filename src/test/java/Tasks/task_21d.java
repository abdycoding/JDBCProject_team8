package Tasks;

import Utilities.DBUtility;

import java.sql.ResultSet;
import java.sql.SQLException;

public class task_21d extends DBUtility {
    public static void main(String[] args) throws SQLException {
        DBConnectionOpen();

        String sql = " select count(*) as NumberOfEmployees from employees;";

        ResultSet resultSet = statement.executeQuery(sql);

        System.out.println(" d: Calculate the total number of employees in the company");
        while (resultSet.next()) {
            // Example of processing the data, adjust as needed based on column names
            int NumberOfEmployees = resultSet.getInt("NumberOfEmployees");
            System.out.println( "NumberOfEmployees: " + NumberOfEmployees );
        }

        DBConnectionCLose();



    }
}
