package com.piscessera.unittest.rdb.demo.repository;

import com.piscessera.unittest.rdb.demo.CommonUtil;
import com.piscessera.unittest.rdb.demo.model.Item;
import lombok.Getter;
import lombok.Setter;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class BaseRepository<T> {
    @Getter @Setter
    private DataSource dataSource;

    public void initial() {
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.loadConfig(getClass());
        if (dataSource == null) {
            dataSource = DataSourceBuilder.createDataSource(dataSourceConfig);
        }
    }

    public Item mapRowToObject(ResultSet resultSet) throws SQLException {
        Item object = new Item();
        object.setId(resultSet.getString("ID"));
        object.setName(resultSet.getString("NAME"));
        return object;
    }

    public Map<String, Object> mapObjectToRow(Item data) throws SQLException {
        Map<String, Object> row = new HashMap<String, Object>();

        if (!CommonUtil.isNullObject(data.getId())) row.put("ID", data.getId());
        if (!CommonUtil.isNullObject(data.getName())) row.put("NAME", data.getName());

        return row;
    }

    public String generateInsertSql(Map<String, Object> map) {
        StringBuilder insertColumns = new StringBuilder();
        StringBuilder insertValues = new StringBuilder();

        insertColumns.append("(");
        insertValues.append(" VALUES (");

        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, Object> entry = iterator.next();

            insertColumns.append(entry.getKey());
            if (entry.getValue() instanceof String) insertValues.append("'");
            insertValues.append(entry.getValue());
            if (entry.getValue() instanceof String) insertValues.append("'");

            if (iterator.hasNext()) {
                insertColumns.append(",");
                insertValues.append(",");
            }
        }
        insertColumns.append(")");
        insertValues.append(")");

        return insertColumns.toString() + insertValues.toString();
    }

    public abstract T create(T entity);
    public abstract T read(String id);
    public abstract List<T> read(T criteria);
    public abstract T update(T entity);
    public abstract boolean delete(String id);
    public abstract boolean delete(T entity);
}
