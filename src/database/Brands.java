package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Brands implements Processable {
    //must be Singleton

    private static volatile Brands instance;

    private Brands() {
    }

    public static Brands getInstance(){
        Brands result = instance;
        if (result == null) {
            synchronized (Brands.class) {
                result = instance;
                if (result == null) {
                    instance = result = new Brands();
                }
            }
        }
        return instance;
    }

    private ArrayList<String> types = new ArrayList<>();

    public ArrayList<String> getTypes() {
        return types;
    }

    @Override
    public String getSQLcommand() {
        return "SELECT model FROM brands;";
    }

    @Override
    public void process(ResultSet resultSet) {
        try {
            types.add(resultSet.getString(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
