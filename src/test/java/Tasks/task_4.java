package Tasks;

import Utilities.DBUtility;

import java.sql.ResultSet;
import java.sql.SQLException;

public class task_4 extends DBUtility
{
    public static void main(String[] args) throws SQLException {
      DBConnectionOpen();

        String sql = "select  concat(employees.first_name, ' ', employees.last_name) as FullName , avg(salaries.salary) as AvgSalary, employees.gender\n" +
                "from employees\n" +
                "left join salaries on employees.emp_no = salaries.emp_no\n" +
                "where employees.gender='M'\n" +
                "group by FullName;";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            // Example of processing the data, adjust as needed based on column names
            String empName = resultSet.getString("FullName");
            String salary= resultSet.getString("AvgSalary" );
            String gender= resultSet.getString("gender");

            System.out.println( "Name: " + empName + ", salary: " + salary + ", gender:" + gender) ;
        }

       DBConnectionCLose();



    }
}
