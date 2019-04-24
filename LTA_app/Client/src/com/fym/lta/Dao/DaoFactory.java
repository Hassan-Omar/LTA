package com.fym.lta.Dao;


public class DaoFactory {

    public UserDao CreateUserDao() {
        return new UserDaoImp();
    }

    public RoleDao CreateRoleDao() {
        return new RoleDaoImp();
    }

    public ScreenDao CreateScreenDao() {
        return new ScreenDaoImp();
    }

    public LocationDao createLocationDao() {
        return new LocationDaoImp();
    }

    public CourseDao CreateCourseDao() {
        return new CourseDaoImp();
    }

    public SchedualDao CreateSchedualDao() {
        return new SchedualDaoImp();
    }

    public SlotDao CreateSlotDao() {
        return new SlotDaoImp();
    }

    public DepartmentDao CreateDepartmentDao() {
        return new DepartmentDaoImp();
    }

    public BuildingDao CreateBuildingDao() {
        return new BuildingDaoImp();
    }

    public FloorDao CreateFloorDao() {
        return new FloorDaoImp();
    }

    public LocationTypeDao CreateLocationTypeDao() {
        return new LocationTypeDaoImp();
    }

    public EquipmentDao CreateEquipmentDao() {
        return new EquipmentDaoImp();
    }

    public EmployeeDao CreateEmployeeDao() {
        return new EmployeeDaoImp();
    }

}
