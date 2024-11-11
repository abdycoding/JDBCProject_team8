package Tasks;

import Utilities.DBUtility;

import java.sql.*;

public class task_1 extends DBUtility
{
    public static void main(String[] args) throws SQLException {
      DBConnectionOpen();

        String sql = "SELECT * FROM employees " +
                "INNER JOIN dept_emp ON employees.emp_no = dept_emp.emp_no " +
                "WHERE dept_emp.dept_no = 'D001'";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            // Example of processing the data, adjust as needed based on column names
            int empNo = resultSet.getInt("emp_no");
            String empName = resultSet.getString("first_name"); // Adjust based on actual column name
            // Print or use the data as needed
            String deptNo= resultSet.getString("dept_no");

            System.out.println("Emp No: " + empNo + ", Name: " + empName + ", dept_no: " + deptNo);
        }

       DBConnectionCLose();



    }
}
