package com.fym.lta.dao;



public class DaoFactory {

    public UserDao createUserDao() {
        return new UserDaoImp();
    }

    public RoleDao createRoleDao() {
        return new RoleDaoImp();
    }

    public ScreenDao createScreenDao() {
        return new ScreenDaoImp();
    }

    public LocationDao createLocationDao() {
        return new LocationDaoImp();
    }

    public CourseDao createCourseDao() {
        return new CourseDaoImp();
    }

    public SchedualDao createSchedualDao() {
        return new SchedualDaoImp();
    }

    public SlotDao createSlotDao() {
        return new SlotDaoImp();
    }

    public DepartmentDao createDepartmentDao() {
        return new DepartmentDaoImp();
    }

    public BuildingDao createBuildingDao() {
        return new BuildingDaoImp();
    }

    public FloorDao createFloorDao() {
        return new FloorDaoImp();
    }

    public LocationTypeDao createLocationTypeDao() {
        return new LocationTypeDaoImp();
    }

    public EquipmentDao createEquipmentDao() {
        return new EquipmentDaoImp();
    }

    public EmployeeDao createEmployeeDao() {
        return new EmployeeDaoImp();
    }
    
   
}
