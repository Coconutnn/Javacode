package com;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import javax.sql.DataSource;
import java.sql.SQLException;

public class DBConfig {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/tangshi?characterEncoding=utf8&useSSL=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

        // 用的饿汉模式的单例
        private static volatile DataSource dataSource = null;

    public static DataSource getDataSource() {
        // 通过这个方法来创建 DataSource 的实例
        if (dataSource == null) {
            synchronized (DBConfig.class) {
                if (dataSource == null) {
                    dataSource = (DataSource) new MysqlDataSource();
                    MysqlDataSource tmpDataSource = (MysqlDataSource) dataSource;
                    tmpDataSource.setURL(URL);
                    tmpDataSource.setUser(USERNAME);
                    tmpDataSource.setPassword(PASSWORD);
                }
            }
        }
        return dataSource;
    }
    public static com.mysql.jdbc.Connection getConnection() {
        try {
            return (com.mysql.jdbc.Connection) getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
