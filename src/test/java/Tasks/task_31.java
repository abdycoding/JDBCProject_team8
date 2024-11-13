package Tasks;

import Utilities.DBUtility;

import java.sql.ResultSet;
import java.sql.SQLException;

public class task_31 extends DBUtility {
    public static void main(String[] args) throws SQLException {
        DBConnectionOpen();

        String sql = " select concat(employees.first_name, ' ', employees.last_name)as Fullname, salaries.salary, departments.dept_no\n" +
                " from employees\n" +
                "left join dept_emp on employees.emp_no = dept_emp.emp_no\n" +
                " left join departments on departments.dept_no = dept_emp.dept_no\n" +
                " left join salaries on salaries.emp_no=employees.emp_no\n" +
                " where departments.dept_no = 'd004'\n" +
                " order by salaries.salary desc\n" +
                " limit 1;";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {

            String first_name = resultSet.getString("Fullname");
            int salary = resultSet.getInt("salary");
            int dept_no = resultSet.getInt("dept_no");


            System.out.println("Fullname: " + first_name + ", first_name: " +
                    ", salary: "+ salary + ", dept_no: " +dept_no);
        }

        DBConnectionCLose();
    }}