package Tasks;

import Utilities.DBUtility;

import java.sql.ResultSet;
import java.sql.SQLException;

public class task_26 extends DBUtility {
    public static void main(String[] args) throws SQLException {
        DBConnectionOpen();

        String sql = "  select employees.*  , salaries.salary, departments.dept_name, titles.title\n" +
                " from employees\n" +
                " left join titles on titles.emp_no = employees.emp_no\n" +
                " left join salaries on salaries.emp_no = employees.emp_no\n" +
                " left join dept_emp on employees.emp_no = dept_emp.emp_no\n" +
                " left join departments on departments.dept_no = dept_emp.dept_no\n" +
                " where employees.first_name = 'Annemarie' and employees.last_name='Redmiles';\n" +
                " ";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            // Example of processing the data, adjust as needed based on column names
            int empNo = resultSet.getInt("emp_no");
            String first_name = resultSet.getString("first_name");
            String last_name = resultSet.getString("last_name");
            String gender = resultSet.getString("gender");
            String dateofBirth = resultSet.getString("birth_date");
            String hire_date = resultSet.getString("hire_date");
            int salary = resultSet.getInt("salary");
            String dept_name = resultSet.getString("dept_name");
            String title = resultSet.getString("title");

            System.out.println("emp_no: " + empNo + ", first_name: " + first_name + ", last_name: " + last_name + ", gender: " + gender +
                    ", dateofBirth: " + dateofBirth + ", hire_date: " + hire_date+
                    ", salary: "+ salary + ", dept_name: " +dept_name+ ", title: " + title);
        }

        DBConnectionCLose();
    }}