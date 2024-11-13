package Tasks;

import Utilities.DBUtility;

import java.sql.ResultSet;
import java.sql.SQLException;

public class task_25 extends DBUtility {
    public static void main(String[] args) throws SQLException {
        DBConnectionOpen();

        String sql = "  select *  \n" +
                " from employees\n" +
                " where employees.first_name = 'Annemarie' and employees.last_name='Redmiles';";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            // Example of processing the data, adjust as needed based on column names
            int empNo= resultSet.getInt("emp_no");
            String first_name = resultSet.getString("first_name");
            String last_name = resultSet.getString("last_name");
            String gender = resultSet.getString("gender");
            String dateofBirth = resultSet.getString("birth_date");
            String hire_date = resultSet.getString("hire_date");

            System.out.println("emp_no: " + empNo + ", first_name: " + first_name +", last_name: " + last_name + ", gender: " + gender+
                    ", dateofBirth: " + dateofBirth+", hire_date: " + hire_date);
        }

        DBConnectionCLose();



    }
}
