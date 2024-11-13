package Tasks;

import Utilities.DBUtility;

import java.sql.ResultSet;
import java.sql.SQLException;

public class task_19 extends DBUtility
{
    public static void main(String[] args) throws SQLException {
      DBConnectionOpen();

        String sql = " select employees.first_name, employees.last_name, employees.hire_date\n" +
                " from employees\n" +
                " where employees.hire_date between '1985-01-01' and '1989-12-31'\n" +
                " order by employees.first_name, employees.last_name ;";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            // Example of processing the data, adjust as needed based on column names
            String empName = resultSet.getString("first_name");
            String empSurname= resultSet.getString("last_name");

            String hire_date= resultSet.getString("hire_date" );

            System.out.println( "Name: " + empName +" Surname: " +empSurname +  ", hire_date: " + hire_date);
        }

       DBConnectionCLose();



    }
}
