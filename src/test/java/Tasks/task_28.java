package Tasks;

import Utilities.DBUtility;

import java.sql.ResultSet;
import java.sql.SQLException;

public class task_28 extends DBUtility {
    public static void main(String[] args) throws SQLException {
        DBConnectionOpen();

        String sql = "select employees.*, salaries.salary \n" +
                "from employees\n" +
                "left join salaries on salaries.emp_no = employees.emp_no\n" +
                "where salaries.salary > '50000' and employees.hire_date > '1994-02-24';\n";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int empNo = resultSet.getInt("emp_no");
            String first_name = resultSet.getString("first_name");
            String last_name = resultSet.getString("last_name");
            String gender = resultSet.getString("gender");
            String dateofBirth = resultSet.getString("birth_date");
            String hire_date = resultSet.getString("hire_date");
            int salary = resultSet.getInt("salary");


            System.out.println("emp_no: " + empNo + ", first_name: " + first_name + ", last_name: "
                    + last_name + ", gender: " + gender +
                    ", dateofBirth: " + dateofBirth + ", hire_date: " + hire_date+
                    ", salary: " +salary);
        }

        DBConnectionCLose();
    }}