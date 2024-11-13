package Tasks;

import Utilities.DBUtility;

import java.sql.ResultSet;
import java.sql.SQLException;

public class task_11 extends DBUtility
{
    public static void main(String[] args) throws SQLException {
      DBConnectionOpen();

        String sql = " select employees.first_name, employees.last_name, salaries.salary, salaries.to_date,\n" +
                "salaries.salary - lag(salaries.salary) over (order by salaries.to_date) as Salary_difference\n" +
                "from employees\n" +
                "left join salaries on employees.emp_no = salaries.emp_no\n" +
                "where employees.emp_no = '10102'\n" +
                "order by salaries.to_date;";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            // Example of processing the data, adjust as needed based on column names
            String empName = resultSet.getString("first_name");
            String empSurname= resultSet.getString("last_name");
            String to_date= resultSet.getString("to_date" );
            String salary= resultSet.getString("salary" );

            System.out.println( "Name: " + empName +" Surname: " +empSurname + ", to_date: " + to_date+ ", salary: " + salary);
        }

       DBConnectionCLose();



    }
}
