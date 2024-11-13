package Tasks;

import Utilities.DBUtility;

import java.sql.ResultSet;
import java.sql.SQLException;

public class task_22b extends DBUtility {
    public static void main(String[] args) throws SQLException {
        DBConnectionOpen();

        String sql = " select count(distinct departments.dept_name) as Departments\n" +
                " from departments; ";

        ResultSet resultSet = statement.executeQuery(sql);

        System.out.println(" b: Identify the number of distinct department names");
        while (resultSet.next()) {
            // Example of processing the data, adjust as needed based on column names
            int Departments = resultSet.getInt("Departments");
            System.out.println( "Departments: " + Departments );
        }

        DBConnectionCLose();



    }
}
