package database;

import id.AbstractId;
import id.AbstractIntermediateId;
import id.AbstractModel;
import id.AbstractModelsList;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class DBHelper {

    private static final String userName = "root";
    private static final String password = "root";
    private static final String connectionUrl = "jdbc:mysql://localhost:3306/dozers?autoReconnect=true&useSSL=false";

    public static void getDataFromDB(Processable processable) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = Objects.requireNonNull(statement).executeQuery(processable.getSQLcommand());
            while (resultSet.next()) {
                processable.process(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getIdFromModel(String model, String table){
        AbstractId.reset();
        AbstractId abstractId = AbstractId.getInstance(model, table);
        getDataFromDB(abstractId);
        return abstractId.getId();
    }

    public static ArrayList<String> getModelsFromTable(String table){
        AbstractModel.reset();
        AbstractModel abstractModel = AbstractModel.getInstance(table);
        getDataFromDB(abstractModel);
        return abstractModel.getModels();
    }

    public static int getIdFromFields(String table, HashMap<String, String> conditions){
        AbstractIntermediateId.reset();
        AbstractIntermediateId abstractIntermediateId = AbstractIntermediateId.getInstance(table, conditions);
        getDataFromDB(abstractIntermediateId);
        return abstractIntermediateId.getId();
    }

    public static ArrayList<String> getModelsFromField(String table, String field, int someId){
        AbstractModelsList.reset();
        AbstractModelsList abstractModelsList = AbstractModelsList.getInstance(table, field, someId);
        getDataFromDB(abstractModelsList);
        return abstractModelsList.getModels();
    }

    public static int putDataToDB(String sql){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
             Statement statement = connection.createStatement()) {
            return statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return 2222;
        }
    }
}
