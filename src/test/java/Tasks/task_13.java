package Tasks;

import Utilities.DBUtility;

import java.sql.ResultSet;
import java.sql.SQLException;

public class task_13 extends DBUtility
{
    public static void main(String[] args) throws SQLException {
      DBConnectionOpen();

        String sql = "  select employees.first_name, employees.last_name, salaries.salary\n" +
                "  from employees\n" +
                "left join salaries on employees.emp_no= salaries.emp_no\n" +
                "where salaries.to_date= (select max(to_date)\n" +
                "from salaries\n" +
                "where emp_no=employees.emp_no);";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            // Example of processing the data, adjust as needed based on column names
            String empName = resultSet.getString("first_name");
            String empSurname= resultSet.getString("last_name");

            String salary= resultSet.getString("salary" );

            System.out.println( "Name: " + empName +" Surname: " +empSurname +  ", salary: " + salary);
        }

       DBConnectionCLose();



    }
}
