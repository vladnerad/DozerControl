package entitiesToSave;

import database.DBHelper;
import database.TableNames;

public class HydCylEntityToSave implements SavableToDB{

    private int id_hyd_cyl_otv_lift,
            id_hyd_cyl_skew,
            id_hyd_cyl_ripper,
            id_extra_hyd_cyl,
            id_hyd_lock_skew,
            id_front_attach_type,
            id_back_attach_type,
            id_winch;

    public void setId_hyd_cyl_otv_lift(int id_hyd_cyl_otv_lift) {
        this.id_hyd_cyl_otv_lift = id_hyd_cyl_otv_lift;
    }

    public void setId_hyd_cyl_skew(int id_hyd_cyl_skew) {
        this.id_hyd_cyl_skew = id_hyd_cyl_skew;
    }

    public void setId_hyd_cyl_ripper(int id_hyd_cyl_ripper) {
        this.id_hyd_cyl_ripper = id_hyd_cyl_ripper;
    }

    public void setId_extra_hyd_cyl(int id_extra_hyd_cyl) {
        this.id_extra_hyd_cyl = id_extra_hyd_cyl;
    }

    public void setId_hyd_lock_skew(int id_hyd_lock_skew) {
        this.id_hyd_lock_skew = id_hyd_lock_skew;
    }

    public void setId_front_attach_type(int id_front_attach_type) {
        this.id_front_attach_type = id_front_attach_type;
    }

    public void setId_back_attach_type(int id_back_attach_type) {
        this.id_back_attach_type = id_back_attach_type;
    }

    public void setId_winch(int id_winch) {
        this.id_winch = id_winch;
    }

    public int getId_hyd_cyl_otv_lift() {
        return id_hyd_cyl_otv_lift;
    }

    public int getId_hyd_cyl_skew() {
        return id_hyd_cyl_skew;
    }

    public int getId_hyd_cyl_ripper() {
        return id_hyd_cyl_ripper;
    }

    public int getId_extra_hyd_cyl() {
        return id_extra_hyd_cyl;
    }

    public int getId_hyd_lock_skew() {
        return id_hyd_lock_skew;
    }

    public int getId_front_attach_type() {
        return id_front_attach_type;
    }

    public int getId_back_attach_type() {
        return id_back_attach_type;
    }

    public int getId_winch() {
        return id_winch;
    }

    @Override
    public int saveToDB() {

        DBHelper.putDataToDB(String.format("INSERT INTO %s (id_hyd_cyl_otv_lift, id_hyd_cyl_skew, id_hyd_cyl_ripper, id_extra_hyd_cyl, id_hyd_lock_skew, id_front_attach_type, id_back_attach_type, id_winch) VALUES(" +
                        "\'%d\', \'%d\', \'%d\', \'%d\', \'%d\', \'%d\', \'%d\', \'%d\');",
                TableNames.hydCylindersTable,
                id_hyd_cyl_otv_lift,
                id_hyd_cyl_skew,
                id_hyd_cyl_ripper,
                id_extra_hyd_cyl,
                id_hyd_lock_skew,
                id_front_attach_type,
                id_back_attach_type,
                id_winch));

        return 0;
    }
}
