package cn.tedu.jdbc;

import org.junit.Test;

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


        rs.close();
        st.close();
        conn.close();

    }

    @Test
    public void Insert() throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        String url = "jdbc:mysql://localhost:3306/db_bbw?characterEncoding=utf-8";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        //3.获取传输器
        Statement st = conn.createStatement();
        //4.执行sql语句并返回执行的结果
        String sql = "insert into account values(NULL,'john',3500)";
        int i = st.executeUpdate(sql);
        //5.处理结果
        System.out.println("影响行数：" + i);
        //6.释放资源
        st.close();
        conn.close();
    }

    @Test
    public void Update() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/db_bbw?characterEncoding=utf-8";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        Statement st = conn.createStatement();
        String sql = "update account set money=1500 where name='john'";
        st.executeUpdate(sql);
        st.close();
        conn.close();
    }

    @Test
    public void find() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/db_bbw?characterEncoding=utf-8";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        Statement st = conn.createStatement();
        String sql = "select * from account where name='john'";
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double money = rs.getDouble("money");
            System.out.println(id + ":" + name + ":" + money);
        }
        rs.close();
        st.close();
        conn.close();

    }

    @Test
    public void del() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/db_bbw?characterEncoding=utf-8";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        Statement st = conn.createStatement();
        String sql = "delete from account where name='john'";
        st.executeUpdate(sql);
        st.close();
        conn.close();
    }
}
