package com.yu.week05.code.database.jdbc;

import java.sql.*;
import java.util.*;

public class MySqlJdbc {
    private Connection connection =null;
    private PreparedStatement preparedStatement = null;

    private void createConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mall", "root", "123456");
            if (connection != null) {
                System.out.println("Connection successful!");
            } else {
                System.out.println("Connection failed!");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public boolean insert(String table, String colum, List<Object> values){
       StringBuilder  sql = new StringBuilder( "insert into "+table+" " + colum + " values (");
        List<String> valueList = new ArrayList<>();
        values.forEach(value->{
            valueList.add("?");
        });
        String join = String.join(",", valueList);
        sql.append(join).append(")");
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
            for (int i = 0; i < values.size(); i++) {
                int j = i+1;
                preparedStatement.setObject(j,values.get(i));
            }
            return preparedStatement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public List<Map<String, Object>> query(String table, Map<String, Object> values, String condition){
        try {
            String sqlTemplate  = "select " + values.keySet().toString().substring(1,
                    values.keySet().toString().length()-1) + " from " + table;
            if (condition != null) {
                sqlTemplate += " where " + condition;
            }

            preparedStatement = connection.prepareStatement(sqlTemplate);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Map<String, Object>> list = new ArrayList<>();
            while (resultSet.next()) {
                for (String key: values.keySet()) {
                    values.put(key, resultSet.getObject(key));
                }
                list.add(new HashMap<>(values));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    private void close() throws SQLException {
        preparedStatement.close();
        connection.close();
        System.out.println("Connection close");
    }
    public static void main(String[] args) {
        Map<String, Object> valuesMap = new HashMap<>();
        valuesMap.put("id", 0);
        valuesMap.put("name", "name");
        valuesMap.put("password", "password");
        valuesMap.put("phoneNumber", 0);
        valuesMap.put("money", 0);
        System.out.println(valuesMap.keySet().toString().substring(1, valuesMap.keySet().toString().length() - 1));

        try {
            MySqlJdbc mysqlJdbc = new MySqlJdbc();
            mysqlJdbc.createConnection();

            String table = "users";
            String columns = "(name, password, phoneNumber, money)";
            List<Object> values = Arrays.asList("name", "password", 0, 0);

            mysqlJdbc.insert(table, columns, values);

            List<Map<String, Object>> results = mysqlJdbc.query(table, valuesMap, null);
            for (Map r : results) {
                System.out.println(r.toString());
            }

            mysqlJdbc.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
