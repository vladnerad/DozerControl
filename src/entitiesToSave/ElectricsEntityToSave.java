package entitiesToSave;

import database.DBHelper;
import database.TableNames;

public class ElectricsEntityToSave implements SavableToDB{
    private int id_motion_joystick,
            id_attach_joystick,
            id_lighters,
            id_battery,
            id_software_ver;

    private String serial_controller;

    public void setId_motion_joystick(int id_motion_joystick) {
        this.id_motion_joystick = id_motion_joystick;
    }

    public void setId_attach_joystick(int id_attach_joystick) {
        this.id_attach_joystick = id_attach_joystick;
    }

    public void setId_lighters(int id_lighters) {
        this.id_lighters = id_lighters;
    }

    public void setId_battery(int id_battery) {
        this.id_battery = id_battery;
    }

    public void setSerial_controller(String serial_controller) {
        this.serial_controller = serial_controller;
    }

    public void setId_software_ver(int id_software_ver) {
        this.id_software_ver = id_software_ver;
    }

    @Override
    public int saveToDB() {

        DBHelper.putDataToDB(String.format("INSERT INTO %s (serial, id_software_ver) VALUES " +
                "(\'%s\', %d);", TableNames.controllerTable, serial_controller, id_software_ver));

        DBHelper.putDataToDB(String.format("INSERT INTO %s (id_motion_joystick, id_attach_joystick, id_lighters, id_battery, serial_controller) VALUES(" +
                        "\'%d\', \'%d\', \'%d\', \'%d\', \'%s\');",
                TableNames.electricsTable,
                id_motion_joystick,
                id_attach_joystick,
                id_lighters,
                id_battery,
                serial_controller));

        return 0;
    }
}
