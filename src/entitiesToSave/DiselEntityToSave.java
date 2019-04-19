package entitiesToSave;

import database.DBHelper;
import database.TableNames;

public class DiselEntityToSave implements SavableToDB{

    //Серийный номер двигателя
    private String serial_dvs;
    //Серийный номер ТНВД
    private String serial_tnvd;
    //Серийный номер турбокомпрессора
    private String serial_turbocomp;

    private int id_disel_types;

    public void setSerial_dvs(String serial_dvs) {
        this.serial_dvs = serial_dvs;
    }

    public void setSerial_tnvd(String serial_tnvd) {
        this.serial_tnvd = serial_tnvd;
    }

    public void setSerial_turbocomp(String serial_turbocomp) {
        this.serial_turbocomp = serial_turbocomp;
    }

    public void setId_disel_types(int id_disel_types) {
        this.id_disel_types = id_disel_types;
    }


    @Override
    public int saveToDB() {
        DBHelper.putDataToDB(String.format("INSERT INTO %s (serial, id_disel_types) VALUES " +
                "(\'%s\', %d);", TableNames.diselEngines, serial_dvs, id_disel_types));

        if(serial_turbocomp.equals("") || serial_turbocomp == null) {
            DBHelper.putDataToDB(String.format("INSERT INTO %s (serial_dvs, serial_tnvd) VALUES " +
                    "(\'%s\', \'%s\');", TableNames.disel, serial_dvs, serial_tnvd));
        } else {
            DBHelper.putDataToDB(String.format("INSERT INTO %s (serial_dvs, serial_tnvd, serial_turbocomp) VALUES " +
                    "(\'%s\', \'%s\', \'%s\');", TableNames.disel, serial_dvs, serial_tnvd, serial_turbocomp));
        }
        return 0;
    }
}
