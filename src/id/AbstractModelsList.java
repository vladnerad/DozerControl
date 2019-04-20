package id;

import database.Processable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AbstractModelsList implements Processable {

    private ArrayList<String> models;
    private String table;
    private String field;
    private int someId;

    private static volatile AbstractModelsList instance;

    private AbstractModelsList(String table, String field, int someId) {
        models = new ArrayList<>();
        this.table = table;
        this.someId = someId;
        this.field = field;
    }

    public static AbstractModelsList getInstance(String table, String field, int someId){
        AbstractModelsList result = instance;
        if (result == null) {
            synchronized (AbstractModelsList.class) {
                result = instance;
                if (result == null) {
                    instance = result = new AbstractModelsList(table, field, someId);
                }
            }
        }
        return instance;
    }

    public static void reset(){
        instance = null;
    }

    public ArrayList<String> getModels(){
        return models;
    }

    @Override
    public String getSQLcommand() {
        return String.format("SELECT model FROM %s WHERE %s = %d;", table, field, someId);
    }

    @Override
    public void process(ResultSet resultSet) {
        try {
            models.add(resultSet.getString(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
