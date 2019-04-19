package entitiesToSave;

import database.DBHelper;
import database.TableNames;

import java.util.HashMap;

public class CoolSysEntityToSave implements SavableToDB{

    //КД системы охлаждения
    private int id_coolant_system_docs;
    //Тип радиатора ОЖ ДВС
    private int id_water_cooler_dvs;
    //Тип масляного радиатора ДВС
    private int id_oil_cooler_dvs;
    //Тип масляного радиатора ГСТ
    private int id_oil_cooler_hst;
    //Тип радиатора кондиционера
    private int id_air_cond_cooler;
    //Тип крыльчатки
    private int id_wing;
    //Тип привода крыльчатки
    private int id_wing_drive;
    //Тип вентилятора
    private int id_impeller_type;
    //Серийный номер установки ПЖД
    private String serial_pre_heater;
    //Модель ПЖД
    private int id_pre_heater_types;

    public void setId_coolant_system_docs(int id_coolant_system_docs) {
        this.id_coolant_system_docs = id_coolant_system_docs;
    }

    public void setId_water_cooler_dvs(int id_water_cooler_dvs) {
        this.id_water_cooler_dvs = id_water_cooler_dvs;
    }

    public void setId_oil_cooler_dvs(int id_oil_cooler_dvs) {
        this.id_oil_cooler_dvs = id_oil_cooler_dvs;
    }

    public void setId_oil_cooler_hst(int id_oil_cooler_hst) {
        this.id_oil_cooler_hst = id_oil_cooler_hst;
    }

    public void setId_air_cond_cooler(int id_air_cond_cooler) {
        this.id_air_cond_cooler = id_air_cond_cooler;
    }


    public void setSerial_pre_heater(String serial_pre_heater) {
        this.serial_pre_heater = serial_pre_heater;
    }

    public void setId_pre_heater_types(int id_pre_heater_types) {
        this.id_pre_heater_types = id_pre_heater_types;
    }

    public void setId_wing(int id_wing) {
        this.id_wing = id_wing;
    }

    public void setId_wing_drive(int id_wing_drive) {
        this.id_wing_drive = id_wing_drive;
    }

    @Override
    public int saveToDB() {
        DBHelper.putDataToDB(String.format("INSERT INTO %s (serial, id_pre_heater_types) VALUES " +
                "(\'%s\', %d);", TableNames.preHeaterTable, serial_pre_heater, id_pre_heater_types));

        HashMap<String, String> fields = new HashMap<>();
        fields.put("id_wing", String.valueOf(id_wing));
        fields.put("id_wing_drive", String.valueOf(id_wing_drive));
        id_impeller_type = DBHelper.getIdFromFields(TableNames.impellerTable, fields);
        //System.out.println(id_impeller_type);

        DBHelper.putDataToDB(String.format("INSERT INTO %s (id_coolant_system_docs, id_water_cooler_dvs, id_oil_cooler_dvs, id_oil_cooler_hst, id_air_cond_cooler, id_impeller_types, serial_pre_heater) VALUES(" +
                        "\'%d\', \'%d\', \'%d\', \'%d\', \'%d\', \'%d\', \'%s\');",
                TableNames.coolantSystem,
                id_coolant_system_docs,
                id_water_cooler_dvs,
                id_oil_cooler_dvs,
                id_oil_cooler_hst,
                id_air_cond_cooler,
                id_impeller_type,
                serial_pre_heater));
        return 0;
    }
}
