
package com.fym.lta.bao;



public class BaoFactory {

    public UserBao createUserBao() {
        return new UserBaoImp();
    }


    public RoleBao createRoleBao() {
        return new RoleBaoImp();
    }

    public ScreenBao createScreenBao() {
        return new ScreenBaoImp();
    }

    public LocationBao createLocationBao() {
        return new LocationBaoImp();
    }

    public CourseBao createCourseBao() {
        return new CourseBaoImp();
    }

    public SchedualBao createSchedualBao() {
        return new SchedualBaoImp();
    }

    public SlotBao createSlotBao() {
        return new SlotBaoImp();
    }

    public DepartmentBao createDepartmentBao() {
        return new DepartmentBaoImp();
    }

    public BuildingBao createBuildingBao() {
        return new BuildingBaoImp();
    }

    public FloorBao createFloorBao() {
        return new FloorBaoImp();
    }

    public LocationTypeBao createLocationTypeBao() {
        return new LocationTypeBaoImp();
    }

    public EquipmentBao createEquipmentBao() {
        return new EquipmentBaoImp();
    }

    public EmployeeBao createemployeeBao() {
        return new EmployeeBaoImp();
    }

    public LoginEngine createLoginEngine() {
        return new LoginEngine();
    }
    
 
  
    

}
