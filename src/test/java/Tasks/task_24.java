package Tasks;

import Utilities.DBUtility;

import java.sql.ResultSet;
import java.sql.SQLException;

public class task_24 extends DBUtility {
    public static void main(String[] args) throws SQLException {
        DBConnectionOpen();

        String sql = "  select * from employees\n" +
                " where employees.hire_date  between '1990-02-20' and '1995-02-20';";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            // Example of processing the data, adjust as needed based on column names

            String first_name = resultSet.getString("first_name");
            String last_name = resultSet.getString("first_name");
            String hire_date = resultSet.getString("hire_date");

            System.out.println(" first_name: " + first_name +", last_name: " + last_name + ", hire_date: " + hire_date);
        }

        DBConnectionCLose();



    }
}
