import java.sql.*;

public class Demo {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://ep-shrill-feather-a11madqq.ap-southeast-1.aws.neon.tech/WorkingDB?user=Navin-S-Patil&password=MGDfHBJ7R9WE&sslmode=require";
        String username = "navin-projects";
        String password = "MGDfHBJ7R9WE";

        try {

            String sql = "select * from test";

            Connection con = DriverManager.getConnection(url, username, password);

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getInt(1) + " : " + rs.getString(2));
            }

            con.close();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
}
