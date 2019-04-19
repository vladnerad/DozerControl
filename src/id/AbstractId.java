package id;

import database.Processable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AbstractId implements Processable {

    private int id;
    private String model;
    private String table;

    private static volatile AbstractId instance;

    private AbstractId(String model, String table) {
        this.model = model;
        this.table = table;
    }

    public static AbstractId getInstance(String model, String table){
        AbstractId result = instance;
        if (result == null) {
            synchronized (AbstractId.class) {
                result = instance;
                if (result == null) {
                    instance = result = new AbstractId(model, table);
                }
            }
        }
        return instance;
    }

    public static void reset(){
        instance = null;
    }

    public int getId(){
        return id;
    }

    @Override
    public String getSQLcommand() {
        return String.format("SELECT id FROM %s WHERE model = \'" + model + "\';", table);
    }

    @Override
    public void process(ResultSet resultSet) {
        try {
            id = resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
