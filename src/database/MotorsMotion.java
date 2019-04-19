package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MotorsMotion implements Processable {

    String brand;

    public MotorsMotion(String brand) {
        this.brand = brand;
    }

    private ArrayList<String> models = new ArrayList<>();

    public ArrayList<String> getModels() {
        return models;
    }

    @Override
    public String getSQLcommand() {
        return "SELECT model FROM hyd_mot_motion_types " +
                "WHERE id_brands = (SELECT id FROM brands WHERE name = \'" + brand + "\')";
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
