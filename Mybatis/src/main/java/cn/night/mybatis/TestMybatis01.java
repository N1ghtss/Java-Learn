package cn.night.mybatis;

import cn.night.mybatis.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestMybatis01 {
    public static void main(String[] args) throws Exception {
        // 1.读取mybatis核心配置文件中的配置信息（mybatis-config.xml）
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        // 2.基于上面的读取的配置信息获取SQL Session Factory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 3.打开与数据库的连接（通过工厂对象获取SQL Session对象）
        SqlSession session = factory.openSession();
        // 4.通过namespace+id找到要执行的sql语句并执行该语句
        List<Emp> list = session.selectList("EmpMapper.findAll");
        // 5.输出结果
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }
}
