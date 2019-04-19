package database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DozerEntity implements Processable {

    private String SQLcommand;
    private int dozerSerial;

    private String pumpsBrand;
    private String pumpsType;     //ISPRAVIT'
    private String pumpsType_id;
    private String motorsBrand;
    private String motorsType;
    private String motorsType_id;
    private String pumpLserial;
    private String pumpRserial;
    private String motLserial;
    private String motRserial;

    public String getPumpLserial() {
        return pumpLserial;
    }

    public String getPumpsBrand() {
        DBHelper.getDataFromDB(new Processable() {
            @Override
            public String getSQLcommand() {
                return "SELECT * FROM brands WHERE brand_id = (SELECT brand_id FROM hydpumpsmotion WHERE hp_id =" + pumpsType_id + ");";
            }

            @Override
            public void process(ResultSet resultSet) {
                try {
                    pumpsBrand = resultSet.getString(2);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        return pumpsBrand;
    }

    public String getMotorsBrand() {
        DBHelper.getDataFromDB(new Processable() {
            @Override
            public String getSQLcommand() {
                return "SELECT * FROM brands WHERE brand_id = (SELECT brand_id FROM hydmotorsmotion WHERE hm_id =" + motorsType_id + ");";
            }

            @Override
            public void process(ResultSet resultSet) {
                try {
                    motorsBrand = resultSet.getString(2);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        return motorsBrand;
    }

    public String getPumpRserial() {
        return pumpRserial;
    }

    public String getMotLserial() {
        return motLserial;
    }

    public String getMotRserial() {
        return motRserial;
    }

    public String getPumpsType() {
        DBHelper.getDataFromDB(new Processable() {
            @Override
            public String getSQLcommand() {
                return "SELECT * FROM hydpumpsmotion WHERE hp_id = " + pumpsType_id + ";";
            }

            @Override
            public void process(ResultSet resultSet) {
                try {
                    pumpsType = resultSet.getString(2);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        return pumpsType;
    }

    public String getMotorsType() {
        DBHelper.getDataFromDB(new Processable() {
            @Override
            public String getSQLcommand() {
                return "SELECT * FROM hydmotorsmotion WHERE hm_id = " + motorsType_id + ";";
            }

            @Override
            public void process(ResultSet resultSet) {
                try {
                    motorsType = resultSet.getString(2);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        return motorsType;
    }

    public DozerEntity(int dozerSerial) {
        this.dozerSerial = dozerSerial;
        SQLcommand = "SELECT * FROM complictation WHERE serial_n = " + dozerSerial + ";";
    }

    @Override
    public String getSQLcommand() {
        return SQLcommand;
    }

    @Override
    public void process(ResultSet resultSet){
        try {
            pumpsType_id = resultSet.getString(2);
            motorsType_id = resultSet.getString(4);
            pumpLserial = resultSet.getString(3);
            pumpRserial = resultSet.getString(3);
            motLserial = resultSet.getString(5);
            motRserial = resultSet.getString(5);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
