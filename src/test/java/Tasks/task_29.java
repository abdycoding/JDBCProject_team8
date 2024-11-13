package Tasks;

import Utilities.DBUtility;

import java.sql.ResultSet;
import java.sql.SQLException;

public class task_29 extends DBUtility {
    public static void main(String[] args) throws SQLException {
        DBConnectionOpen();

        String sql = "   select employees.*, departments.dept_name, titles.title\n" +
                " from employees\n" +
                "left join dept_emp on employees.emp_no = dept_emp.emp_no\n" +
                "left join departments on dept_emp.dept_no = departments.dept_no\n" +
                "left join titles on titles.emp_no = employees.emp_no\n" +
                " where departments.dept_name = 'Sales' and titles.title = 'Manager'; ";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            // Example of processing the data, adjust as needed based on column names
            int empNo = resultSet.getInt("emp_no");
            String first_name = resultSet.getString("first_name");
            String last_name = resultSet.getString("last_name");
            String gender = resultSet.getString("gender");
            String dateofBirth = resultSet.getString("birth_date");
            String hire_date = resultSet.getString("hire_date");
            String dept_name = resultSet.getString("dept_name");
            String title = resultSet.getString("title");

            System.out.println("emp_no: " + empNo + ", first_name: " + first_name + ", last_name: " + last_name + ", gender: " + gender +
                    ", dateofBirth: " + dateofBirth + ", hire_date: " + hire_date+ ", dept_name: " +dept_name+ ", title: " + title);
        }

        DBConnectionCLose();
    }}