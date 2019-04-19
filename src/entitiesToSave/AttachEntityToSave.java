package entitiesToSave;

public class AttachEntityToSave implements SavableToDB {

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

    @Override
    public int saveToDB() {
        return 0;
    }
}
