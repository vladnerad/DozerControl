package entitiesToSave;

import database.DBHelper;
import database.TableNames;

public class CabinEntityToSave implements SavableToDB {

    private int id_cabin_type,
            id_air_conditioner,
            id_air_heater,
            id_filt_vent_set,
            id_radio_player,
            id_rops,
            id_antivandal_lattice;

    public void setId_cabin_type(int id_cabin_type) {
        this.id_cabin_type = id_cabin_type;
    }

    public void setId_air_conditioner(int id_air_conditioner) {
        this.id_air_conditioner = id_air_conditioner;
    }

    public void setId_air_heater(int id_air_heater) {
        this.id_air_heater = id_air_heater;
    }

    public void setId_filt_vent_set(int id_filt_vent_set) {
        this.id_filt_vent_set = id_filt_vent_set;
    }

    public void setId_radio_player(int id_radio_player) {
        this.id_radio_player = id_radio_player;
    }

    public void setId_rops(int id_rops) {
        this.id_rops = id_rops;
    }

    public void setId_antivandal_lattice(int id_antivandal_lattice) {
        this.id_antivandal_lattice = id_antivandal_lattice;
    }

    @Override
    public int saveToDB() {

        DBHelper.putDataToDB(String.format("INSERT INTO %s (id_cabin_type, id_air_conditioner, id_air_heater, id_filt_vent_set, id_radio_player, id_rops, id_antivandal_lattice) VALUES(" +
                        "\'%d\', \'%d\', \'%d\', \'%d\', \'%d\', \'%d\', \'%d\');",
                TableNames.cabinTable,
                id_cabin_type,
                id_air_conditioner,
                id_air_heater,
                id_filt_vent_set,
                id_radio_player,
                id_rops,
                id_antivandal_lattice));

        return 0;
    }
}
