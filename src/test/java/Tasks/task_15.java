package Tasks;

import Utilities.DBUtility;

import java.sql.ResultSet;
import java.sql.SQLException;

public class task_15 extends DBUtility
{
    public static void main(String[] args) throws SQLException {
      DBConnectionOpen();

        String sql = " select concat(employees.first_name, ' ', employees.last_name) as FullName , avg(salaries.salary)as AvgSalary, departments.dept_name as Department\n" +
                " from employees\n" +
                "left join dept_emp on employees.emp_no = dept_emp.emp_no\n" +
                "left join departments on dept_emp.dept_no = departments.dept_no\n" +
                "left join salaries on employees.emp_no = salaries.emp_no \n" +
                "  where departments.dept_name = 'Research'\n" +
                "    group by FullName\n" +
                "  order by AvgSalary desc\n" +
                "  limit 1;";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            // Example of processing the data, adjust as needed based on column names
            String empName = resultSet.getString("FullName");
            String salary1 = resultSet.getString("AvgSalary");
            String Department= resultSet.getString("Department");


            System.out.println( "Name: " + empName +" salary1: " + salary1 + ", Department:"+ Department );
        }

       DBConnectionCLose();



    }
}
