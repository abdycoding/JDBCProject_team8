package Tasks;

import Utilities.DBUtility;

import java.sql.ResultSet;
import java.sql.SQLException;

public class task_27 extends DBUtility {
    public static void main(String[] args) throws SQLException {
        DBConnectionOpen();

        String sql = "select employees.*, dept_manager.*\n" +
                " from employees\n" +
                "left join dept_emp on employees.emp_no = dept_emp.emp_no\n" +
                " left join departments on departments.dept_no = dept_emp.dept_no\n" +
                " left join dept_manager on dept_manager.dept_no = dept_emp.dept_no\n" +
                " where departments.dept_no = 'd005';";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            // Example of processing the data, adjust as needed based on column names
            int empNo = resultSet.getInt("emp_no");
            String first_name = resultSet.getString("first_name");
            String last_name = resultSet.getString("last_name");
            String gender = resultSet.getString("gender");
            String dateofBirth = resultSet.getString("birth_date");
            String hire_date = resultSet.getString("hire_date");
            String dept_no = resultSet.getString("dept_no");


            System.out.println("emp_no: " + empNo + ", first_name: " + first_name + ", last_name: "
                    + last_name + ", gender: " + gender +
                    ", dateofBirth: " + dateofBirth + ", hire_date: " + hire_date+
                  ", dept_no: " +dept_no);
        }

        DBConnectionCLose();
    }}