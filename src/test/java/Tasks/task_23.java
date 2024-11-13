package Tasks;

import Utilities.DBUtility;

import java.sql.ResultSet;
import java.sql.SQLException;

public class task_23 extends DBUtility {
    public static void main(String[] args) throws SQLException {
        DBConnectionOpen();

        String sql = " select departments.dept_name, count(*) as Number_of_employees\n" +
                "from employees\n" +
                "left join dept_emp on employees.emp_no= dept_emp.emp_no\n" +
                "left join departments on departments.dept_no= dept_emp.dept_no\n" +
                "group by departments.dept_name;";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            // Example of processing the data, adjust as needed based on column names
            String dept_name = resultSet.getString("dept_name");
            int Number_of_employees = resultSet.getInt("Number_of_employees");
            System.out.println("dept_name: "+ dept_name+ ", Number_of_employees: " + Number_of_employees );
        }

        DBConnectionCLose();



    }
}
