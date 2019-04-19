package entitiesToSave;

import database.DBHelper;
import database.TableNames;

import java.util.HashMap;

public class AttachEntityToSave implements SavableToDB {

    private HydCylEntityToSave hydCylEntityToSave;

    public AttachEntityToSave(HydCylEntityToSave hydCylEntityToSave) {
        this.hydCylEntityToSave = hydCylEntityToSave;
        this.hydCylEntityToSave.saveToDB();

        HashMap<String, String> fields = new HashMap<>();
        fields.put("id_hyd_cyl_otv_lift", String.valueOf(hydCylEntityToSave.getId_hyd_cyl_otv_lift()));
        fields.put("id_hyd_cyl_skew", String.valueOf(hydCylEntityToSave.getId_hyd_cyl_skew()));
        fields.put("id_hyd_cyl_ripper", String.valueOf(hydCylEntityToSave.getId_hyd_cyl_ripper()));
        fields.put("id_extra_hyd_cyl", String.valueOf(hydCylEntityToSave.getId_extra_hyd_cyl()));
        fields.put("id_hyd_lock_skew", String.valueOf(hydCylEntityToSave.getId_hyd_lock_skew()));
        fields.put("id_front_attach_type", String.valueOf(hydCylEntityToSave.getId_front_attach_type()));
        fields.put("id_back_attach_type", String.valueOf(hydCylEntityToSave.getId_back_attach_type()));
        fields.put("id_winch", String.valueOf(hydCylEntityToSave.getId_winch()));

        id_hyd_cylinders = DBHelper.getIdFromFields(TableNames.hydCylindersTable, fields);
    }

    private String serial_attach_pump,
            serial_fan_pump,
            serial_fan_motor,
            serial_extra_attach_pump,
            serial_extra_attach_motor,
            serial_hyd_distributor;

    private int id_hyd_cylinders,
            id_attach_pump_types,
            id_fan_pump_types,
            id_fan_mot_types,
            id_hyd_distributor_types;

    public void setSerial_attach_pump(String serial_attach_pump) {
        this.serial_attach_pump = serial_attach_pump;
    }

    public void setSerial_fan_pump(String serial_fan_pump) {
        this.serial_fan_pump = serial_fan_pump;
    }

    public void setSerial_fan_motor(String serial_fan_motor) {
        this.serial_fan_motor = serial_fan_motor;
    }

    public void setSerial_extra_attach_pump(String serial_extra_attach_pump) {
        this.serial_extra_attach_pump = serial_extra_attach_pump;
    }

    public void setSerial_extra_attach_motor(String serial_extra_attach_motor) {
        this.serial_extra_attach_motor = serial_extra_attach_motor;
    }

    public void setSerial_hyd_distributor(String serial_hyd_distributor) {
        this.serial_hyd_distributor = serial_hyd_distributor;
    }

    public void setId_attach_pump_types(int id_attach_pump_types) {
        this.id_attach_pump_types = id_attach_pump_types;
    }

    public void setId_fan_pump_types(int id_fan_pump_types) {
        this.id_fan_pump_types = id_fan_pump_types;
    }

    public void setId_fan_mot_types(int id_fan_mot_types) {
        this.id_fan_mot_types = id_fan_mot_types;
    }

    public void setId_hyd_distributor_types(int id_hyd_distributor_types) {
        this.id_hyd_distributor_types = id_hyd_distributor_types;
    }

    @Override
    public int saveToDB() {

        DBHelper.putDataToDB(String.format("INSERT INTO %s (serial, id_attach_pump_types) VALUES " +
                "(\'%s\', %d);", TableNames.attachPumpTable, serial_attach_pump, id_attach_pump_types));
        DBHelper.putDataToDB(String.format("INSERT INTO %s (serial, id_fan_pump_types) VALUES " +
                "(\'%s\', %d);", TableNames.fanPumpTable, serial_fan_pump, id_fan_pump_types));
        DBHelper.putDataToDB(String.format("INSERT INTO %s (serial, id_fan_mot_types) VALUES " +
                "(\'%s\', %d);", TableNames.fanMotorTable, serial_fan_motor, id_fan_mot_types));
        DBHelper.putDataToDB(String.format("INSERT INTO %s (serial, id_hyd_distributor_types) VALUES " +
                "(\'%s\', %d);", TableNames.hydDustributorTable, serial_hyd_distributor, id_hyd_distributor_types));


        DBHelper.putDataToDB(String.format("INSERT INTO %s (serial_attach_pump, serial_fan_pump, serial_fan_motor, serial_hyd_distributor, id_hyd_cylinders) VALUES(" +
                        "\'%s\', \'%s\', \'%s\', \'%s\', \'%d\');",
                TableNames.attachmentsTable,
                serial_attach_pump,
                serial_fan_pump,
                serial_fan_motor,
                serial_hyd_distributor,
                id_hyd_cylinders));

        return 0;
    }
}
