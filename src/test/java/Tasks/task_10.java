package Tasks;

import Utilities.DBUtility;

import java.sql.ResultSet;
import java.sql.SQLException;

public class task_10 extends DBUtility
{
    public static void main(String[] args) throws SQLException {
      DBConnectionOpen();

        String sql = " select employees.first_name, employees.last_name, employees.emp_no, salaries.salary\n" +
                "from employees\n" +
                "left join salaries on employees.emp_no = salaries.emp_no\n" +
                "where employees.emp_no = '10102';";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            // Example of processing the data, adjust as needed based on column names
            String empName = resultSet.getString("first_name");
            String empSurname= resultSet.getString("last_name");
            String emp_no= resultSet.getString("emp_no" );
            String salary= resultSet.getString("salary" );

            System.out.println( "Name: " + empName +" Surname: " +empSurname + ", emp_no: " + emp_no+ ", salary: " + salary);
        }

       DBConnectionCLose();



    }
}
