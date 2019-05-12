package com.piscessera.unittest.rdb.demo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CommonUtil {
    public static boolean isNullObject(Object object) {
        if (object == null) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isConnectionEmpty(Connection connection) {
        if (connection == null) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isStatementEmpty(Statement statement) {
        if (statement == null) {
            return true;
        } else {
            return false;
        }
    }

    public static void closeProcess(Connection connection, Statement statement) throws SQLException {
        if (isConnectionEmpty(connection)) {
            connection.close();
        }
        if (isStatementEmpty(statement)) {
            statement.close();
        }
    }
}
