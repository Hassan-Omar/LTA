
package com.fym.lta.Bao;


public class BaoFactory {

    public UserBao CreateUserBao() {
        return new UserBaoImp();
    }


    public RoleBao CreateRoleBao() {
        return new RoleBaoImp();
    }

    public ScreenBao CreateScreenBao() {
        return new ScreenBaoImp();
    }

    public LocationBao createLocationBao() {
        return new LocationBaoImp();
    }

    public CourseBao CreateCourseBao() {
        return new CourseBaoImp();
    }

    public SchedualBao CreateSchedualBao() {
        return new SchedualBaoImp();
    }

    public SlotBao CreateSlotBao() {
        return new SlotBaoImp();
    }

    public DepartmentBao CreateDepartmentBao() {
        return new DepartmentBaoImp();
    }

    public BuildingBao CreateBuildingBao() {
        return new BuildingBaoImp();
    }

    public FloorBao CreateFloorBao() {
        return new FloorBaoImp();
    }

    public LocationTypeBao CreateLocationTypeBao() {
        return new LocationTypeBaoImp();
    }

    public EquipmentBao CreateEquipmentBao() {
        return new EquipmentBaoImp();
    }

    public EmployeeBao CreateemployeeBao() {
        return new EmployeeBaoImp();
    }

    public LoginEngine CreateLoginEngine() {
        return new LoginEngine();
    }


}
