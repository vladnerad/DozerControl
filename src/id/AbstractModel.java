package id;

import database.Processable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AbstractModel implements Processable {

    private ArrayList<String> models;
    private String table;

    private static volatile AbstractModel instance;

    private AbstractModel(String table) {
        models = new ArrayList<>();
        this.table = table;
    }

    public static AbstractModel getInstance(String table){
        AbstractModel result = instance;
        if (result == null) {
            synchronized (AbstractModel.class) {
                result = instance;
                if (result == null) {
                    instance = result = new AbstractModel(table);
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
        return String.format("SELECT model FROM %s;", table);
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
