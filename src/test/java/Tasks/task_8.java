package Tasks;

import Utilities.DBUtility;

import java.sql.ResultSet;
import java.sql.SQLException;

public class task_8 extends DBUtility
{
    public static void main(String[] args) throws SQLException {
      DBConnectionOpen();

        String sql = "select departments.dept_no, avg(salaries.salary) as AVGSALARY\n" +
                "from departments\n" +
                "left join dept_emp on  departments.dept_no = dept_emp.dept_no \n" +
                "left join employees on employees.emp_no= dept_emp.emp_no\n" +
                "left join salaries on employees.emp_no = salaries.emp_no\n" +
                "group by departments.dept_no;";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            // Example of processing the data, adjust as needed based on column names
            String deptNo = resultSet.getString("dept_no");
            String salary= resultSet.getString("AVGSALARY" );


            System.out.println( "Dept_no: " + deptNo + ", salary: " + salary ) ;
        }

       DBConnectionCLose();



    }
}
