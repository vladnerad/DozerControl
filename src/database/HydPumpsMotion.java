package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HydPumpsMotion  implements Processable{

    private static volatile HydPumpsMotion instance;

    private HydPumpsMotion() {
    }

    public static HydPumpsMotion getInstance(){
        HydPumpsMotion result = instance;
        if (result == null) {
            synchronized (HydPumpsMotion.class) {
                result = instance;
                if (result == null) {
                    instance = result = new HydPumpsMotion();
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
        return "SELECT hp_model FROM hydpumpsmotion;";
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
