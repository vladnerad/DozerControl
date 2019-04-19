package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PumpReductor implements Processable {
    //must be Singleton

    private static volatile PumpReductor instance;

    private PumpReductor() {
    }

    public static PumpReductor getInstance(){
        PumpReductor result = instance;
        if (result == null) {
            synchronized (PumpReductor.class) {
                result = instance;
                if (result == null) {
                    instance = result = new PumpReductor();
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
        return "SELECT model FROM pump_reductor_types;";
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