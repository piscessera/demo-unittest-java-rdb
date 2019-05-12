package com.piscessera.unittest.rdb.demo.repository;

import com.piscessera.unittest.rdb.demo.CommonUtil;
import com.piscessera.unittest.rdb.demo.model.Item;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class ItemRepository extends BaseRepository<Item> {

    public static final String TABLE = "item";
    public String ID = "id";

    public ItemRepository() {
        initial();
    }

    public Item create(Item entity) {
        Item result = null;

        String id = UUID.randomUUID().toString();
        entity.setId(id);

        Connection connection = null;
        Statement statement = null;

        try {
            Map<String, Object> map = mapObjectToRow(entity);
            String insertSql = generateInsertSql(map);
            String sql = String.format("INSERT INTO %s %s", TABLE, insertSql);

            connection = getDataSource().getConnection();
            statement = connection.createStatement();

            boolean executeResult = statement.execute(sql);
            CommonUtil.closeProcess(connection, statement);

            if (executeResult) {
                result = entity;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Item read(String id) {
        Item result = null;
        Connection connection = null;
        Statement statement = null;

        try {
            String sql = String.format("SELECT * FROM %s WHERE %s LIKE '%s'", TABLE, ID, id);

            connection = getDataSource().getConnection();
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            result = mapRowToObject(resultSet);

            CommonUtil.closeProcess(connection, statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Item> read(Item criteria) {
        return null;
    }

    public Item update(Item entity) {
        return null;
    }

    public boolean delete(String id) {
        return false;
    }

    public boolean delete(Item entity) {
        return false;
    }
}
