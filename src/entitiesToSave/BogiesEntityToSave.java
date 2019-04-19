package entitiesToSave;

import database.DBHelper;
import database.TableNames;

public class BogiesEntityToSave implements SavableToDB{

    private int id_bogies_types,
            id_one_flange_rollers,
            id_two_flange_rollers,
            id_pull_on_wheel_types,
            id_leader_wheel_types,
            id_caterpillar_types;

    public void setId_bogies_types(int id_bogies_types) {
        this.id_bogies_types = id_bogies_types;
    }

    public void setId_one_flange_rollers(int id_one_flange_rollers) {
        this.id_one_flange_rollers = id_one_flange_rollers;
    }

    public void setId_two_flange_rollers(int id_two_flange_rollers) {
        this.id_two_flange_rollers = id_two_flange_rollers;
    }

    public void setId_pull_on_wheel_types(int id_pull_on_wheel_types) {
        this.id_pull_on_wheel_types = id_pull_on_wheel_types;
    }

    public void setId_leader_wheel_types(int id_leader_wheel_types) {
        this.id_leader_wheel_types = id_leader_wheel_types;
    }

    public void setId_caterpillar_types(int id_caterpillar_types) {
        this.id_caterpillar_types = id_caterpillar_types;
    }

    @Override
    public int saveToDB() {

        DBHelper.putDataToDB(String.format("INSERT INTO %s (id_bogies_types, id_one_flange_rollers, id_two_flange_rollers, id_pull_on_wheel_types, id_leader_wheel_types, id_caterpillar_types) VALUES(" +
                        "\'%d\', \'%d\', \'%d\', \'%d\', \'%d\', \'%d\');",
                TableNames.bogiesTable,
                id_bogies_types,
                id_one_flange_rollers,
                id_two_flange_rollers,
                id_pull_on_wheel_types,
                id_leader_wheel_types,
                id_caterpillar_types));

        return 0;
    }
}
