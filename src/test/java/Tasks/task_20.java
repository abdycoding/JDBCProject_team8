package Tasks;

import Utilities.DBUtility;

import java.sql.ResultSet;
import java.sql.SQLException;

public class task_20 extends DBUtility
{
    public static void main(String[] args) throws SQLException {
      DBConnectionOpen();

        String sql = "  select employees.first_name, employees.last_name, employees.hire_date, salaries.salary, departments.dept_name\n" +
                " from employees\n" +
                " left join salaries on salaries.emp_no = employees.emp_no\n" +
                " left join dept_emp on employees.emp_no= dept_emp.emp_no\n" +
                " left join departments on departments.dept_no= dept_emp.dept_no\n" +
                " where  departments.dept_name='Sales' and  employees.hire_date between '1985-01-01' and '1989-12-31'\n" +
                " order by salaries.salary desc ;";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            // Example of processing the data, adjust as needed based on column names
            String empName = resultSet.getString("first_name");
            String empSurname= resultSet.getString("last_name");
            String hire_date= resultSet.getString("hire_date" );
            int salary= resultSet.getInt("salary" );
            String dept_name= resultSet.getString("dept_name" );


            System.out.println( "Name: " + empName +" Surname: " +empSurname +  ", hire_date: " + hire_date+ ", salary " + salary+ ", dept_name" + dept_name );
        }

       DBConnectionCLose();



    }
}
