package CEMS.src.application;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.ibatis.jdbc.ScriptRunner;
public class DatabaseRunner {

    public static void setUPDB() throws Exception {
        String script = "CEMS/src/resources/cems_database_1.sql";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            new ScriptRunner(DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mysql", "CEMSAdmin", "CEMS321"))
                    .runScript(new BufferedReader(new FileReader(script)));
        } catch (SQLException sqlException) {
            if (sqlException.getErrorCode() == 1007) {
                // Database already exists error
                System.out.println(sqlException.getMessage());
            } else {
                sqlException.printStackTrace();
            }
        }
    }
}