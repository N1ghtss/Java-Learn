package cn.tedu.jdbc;

import java.sql.*;

public class Test01 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/db_bbw?characterEncoding=utf-8";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        Statement st = conn.createStatement();
        String sql = "select * from account";
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double money = rs.getDouble("money");
            System.out.println(id + ":" + name + ":" + money);
        }

    }
}
