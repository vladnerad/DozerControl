package entitiesToSave;

import database.DBHelper;
import database.TableNames;

public class TransmissionEntityToSave implements SavableToDB{

    private int id;

    //Гидравлические насосы хода
    private String serial_hyd_pumps_motion_L;
    private String serial_hyd_pumps_motion_R;
    private int id_hyd_pumps_motion_types;
    //Гидравлические моторы хода
    private String serial_hyd_mot_motion_L;
    private String serial_hyd_mot_motion_R;
    private int id_hyd_mot_motion_types;
    //Планетарные редукторы
    private String serial_planet_reductor_L;
    private String serial_planet_reductor_R;
    private int id_planet_reductor_types;
    //Раздаточный редуктор для гидронасосов
    private String serial_pump_reductor;
    private int id_pump_reductor_types;


    public void setSerial_hyd_pumps_motion_L(String serial_hyd_pumps_motion_L) {
        this.serial_hyd_pumps_motion_L = serial_hyd_pumps_motion_L;
    }

    public void setSerial_hyd_pumps_motion_R(String serial_hyd_pumps_motion_R) {
        this.serial_hyd_pumps_motion_R = serial_hyd_pumps_motion_R;
    }

    public void setId_hyd_pumps_motion_types(int id_hyd_pumps_motion_types) {
        this.id_hyd_pumps_motion_types = id_hyd_pumps_motion_types;
    }

    public void setSerial_hyd_mot_motion_L(String serial_hyd_mot_motion_L) {
        this.serial_hyd_mot_motion_L = serial_hyd_mot_motion_L;
    }

    public void setSerial_hyd_mot_motion_R(String serial_hyd_mot_motion_R) {
        this.serial_hyd_mot_motion_R = serial_hyd_mot_motion_R;
    }

    public void setId_hyd_mot_motion_types(int id_hyd_mot_motion_types) {
        this.id_hyd_mot_motion_types = id_hyd_mot_motion_types;
    }

    public void setSerial_planet_reductor_L(String serial_planet_reductor_L) {
        this.serial_planet_reductor_L = serial_planet_reductor_L;
    }

    public void setSerial_planet_reductor_R(String serial_planet_reductor_R) {
        this.serial_planet_reductor_R = serial_planet_reductor_R;
    }

    public void setId_planet_reductor_types(int id_planet_reductor_types) {
        this.id_planet_reductor_types = id_planet_reductor_types;
    }

    public void setSerial_pump_reductor(String serial_pump_reductor) {
        this.serial_pump_reductor = serial_pump_reductor;
    }

    public void setId_pump_reductor_types(int id_pump_reductor_types) {
        this.id_pump_reductor_types = id_pump_reductor_types;
    }

    @Override
    public int saveToDB(){
        DBHelper.putDataToDB(String.format("INSERT INTO %s (serial, id_hyd_pumps_motion_types) VALUES " +
                "(\'%s\', %d), (\'%s\', %d);", TableNames.hydPumpMotionTable, serial_hyd_pumps_motion_L, id_hyd_pumps_motion_types, serial_hyd_pumps_motion_R, id_hyd_pumps_motion_types));

        DBHelper.putDataToDB(String.format("INSERT INTO %s (serial, id_hyd_mot_motion_types) VALUES " +
                "(\'%s\', %d), (\'%s\', %d);", TableNames.hydMotorMotionTable, serial_hyd_mot_motion_L, id_hyd_mot_motion_types, serial_hyd_mot_motion_R, id_hyd_mot_motion_types));

        DBHelper.putDataToDB(String.format("INSERT INTO %s (serial, id_planet_reductor_types) VALUES " +
                "(\'%s\', %d), (\'%s\', %d);", TableNames.planetReductorTable, serial_planet_reductor_L, id_planet_reductor_types, serial_planet_reductor_R, id_planet_reductor_types));

        if(id_pump_reductor_types!=1){
            DBHelper.putDataToDB(String.format("INSERT INTO %s (serial, id_pump_reductor_types) VALUES " +
                    "(\'%s\', %d);", TableNames.pumpReductorTable, serial_pump_reductor, id_pump_reductor_types));
        }

        DBHelper.putDataToDB(String.format("INSERT INTO %s (serial_hyd_pumps_motion_L, serial_hyd_pumps_motion_R, serial_hyd_mot_motion_L, serial_hyd_mot_motion_R, serial_planet_reductor_L, serial_planet_reductor_R, serial_pump_reductor) VALUES(" +
                        "\'%s\', \'%s\', \'%s\', \'%s\', \'%s\', \'%s\', \'%s\');",
                TableNames.transmissionTable,
                serial_hyd_pumps_motion_L,
                serial_hyd_pumps_motion_R,
                serial_hyd_mot_motion_L,
                serial_hyd_mot_motion_R,
                serial_planet_reductor_L,
                serial_planet_reductor_R,
                serial_pump_reductor));
        return 0;
    }
}
