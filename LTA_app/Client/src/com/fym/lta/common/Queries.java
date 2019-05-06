package com.fym.lta.common;


public class Queries {

    //_____________________________ USER MODULE _______________________________________
    public static final String INSER_NEW_USER =
        "INSERT INTO USERS (USERNAME,PASSWORD,ROLE_ID,INSERTION_DATE,UPDATE_DATE" +
        ",INSERTED_BY,UPDATED_BY,EMAIL,EMP_ID) " + "VALUES (?,?,?,?,?,?,?,?,?)";

    public static final String LIST_ALL_USER =
        "SELECT EMPLOYEE.FNAME , EMPLOYEE.SNAME , EMPLOYEE.TNAME , EMPLOYEE.FAMILY_NAME " +
        ",USERS.USERNAME ,USERS.INSERTION_DATE ,USERS.UPDATE_DATE ,USERS.INSERTED_BY ,USERS.UPDATED_BY ,USERS.EMAIL,ROLE.CODE " +
        "FROM EMPLOYEE , USERS , ROLE " + "WHERE EMPLOYEE.ID = USERS.EMP_ID AND ROLE.ROLEID = USERS.ROLE_ID  ";

    public static final String DELETE_USER = "DELETE FROM USERS WHERE EMAIL = ? ";

    public static final String UPDATE_USER =
        "UPDATE USERS SET USERNAME = ?, PASSWORD = ?, ROLE_ID = ? " +
        ",UPDATED_BY = ? ,UPDATE_DATE = ? WHERE EMAIL = ? ";

    public static final String IS_USERNAME_EXIST = "SELECT USERNAME FROM USERS WHERE USERNAME = ?";

    public static final String USER_SEARCH =
        "SELECT EMPLOYEE.FNAME , EMPLOYEE.SNAME , EMPLOYEE.TNAME , EMPLOYEE.FAMILY_NAME " +
        ",USERS.USERNAME ,USERS.INSERTION_DATE ,USERS.UPDATE_DATE ,USERS.INSERTED_BY ,USERS.UPDATED_BY ,USERS.EMAIL,ROLE.CODE " +
        "FROM EMPLOYEE , USERS , ROLE " +
        "WHERE EMPLOYEE.ID = USERS.EMP_ID AND ROLE.ROLEID = USERS.ROLE_ID AND LOWER(EMAIL) LIKE ? ";

    public static final String LOGIN_CHECK = "SELECT USERNAME,PASSWORD FROM USERS WHERE USERNAME = ? AND PASSWORD = ?";

    public static final String IS_USER_EXIST = "SELECT EMAIL ,USERNAME FROM USERS WHERE EMAIL = ? OR USERNAME = ?";
    //___________________________________________________________________________________


    //____________________________ ROLES MODULE _________________________________
    public static final String INSER_NEW_ROLE =
        "INSERT INTO ROLE (CODE ,DESCRIPTION ,INSERTED_BY ,UPDATED_BY ,INSERTION_DATE ,UPDATE_DATE ) VALUES(?,?,?,?,?,?)";

    public static final String LIST_ALL_ROLES = "SELECT CODE , DESCRIPTION ,ROLEID  FROM ROLE";

    public static final String DELETE_ROLE = " DELETE FROM ROLE WHERE CODE = ?";

    public static final String IS_ROLE_EXIST = "SELECT CODE FROM ROLE WHERE CODE = ?";

    public static final String UPDATE_ROLE =
        "UPDATE ROLE SET DESCRIPTION = ? ,UPDATED_BY = ? ,UPDATE_DATE = ?  WHERE CODE = ?";

    public static final String ROLE_SEARCH = "SELECT CODE , DESCRIPTION ,ROLEID FROM ROLE WHERE LOWER(CODE) LIKE ?";

    public static final String CURRENT_ROLE =
        "SELECT ROLE.ROLEID FROM ROLE ,USERS WHERE  USERS.ROLE_ID = ROLE.ROLEID AND USERS.USERNAME  = ?";

    //___________________________________________________________________________________


    //____________________________ AUTHNTICATION MODULE _________________________________

    public static final String ROLE_SCREEN_INSERT =
        "INSERT INTO ROLE_SCREEN (ROLEID ,SCREENID ,PERMISSIONTYPE ) VALUES (?,?,?)";

    public static final String GET_CURRENT_PERMISSION =
        "SELECT PERMISSIONTYPE FROM ROLE_SCREEN WHERE ROLEID = ? AND SCREENID = ? ";

    public static final String GET_AVAILABLE_SCREENS = "SELECT SCREENID FROM ROLE_SCREEN WHERE ROLEID = ? ";
    //___________________________________________________________________________________


    //____________________________ STAFF MEMBERS MODULE _________________________________
    public static final String INSER_NEW_EMPLOYEE =
        "INSERT INTO EMPLOYEE (FNAME,SNAME,TNAME,FAMILY_NAME) VALUES (?,?,?,?)";

    public static final String LIST_ALL_EMPLOYEE = "SELECT * FROM EMPLOYEE";

    public static final String DELETE_EMPLOYEE = "DELETE FROM EMPLOYEE WHERE ID = ? ";

    public static final String IS_EMPLOYEE_EXIST = "SELECT ID FROM EMPLOYEE WHERE FNAME = ?";

    public static final String UPDATE_EMPLOYEE =
        "UPDATE EMPLOYEE SET  FNAME = ?, SNAME = ?, TNAME = ?,FAMILY_NAME = ? WHERE ID = ?";

    public static final String EMPLOYEE_SEARCH = "SELECT * FROM EMPLOYEE WHERE LOWER(FNAME) LIKE ?";

    //___________________________________________________________________________________


    //________________________________ BUILDING MODULE __________________________________
    public static final String INSER_NEW_BUILDING =
        "INSERT INTO BUILDING (CODE,DESCRIPTION,INSERTION_DATE,UPDATE_DATE,INSERTED_BY,UPDATED_BY)" +
        "VALUES (?,?,?,?,?,?)";

    public static final String DELETE_BUILDING = "DELETE FROM BUILDING WHERE B_ID = ? ";

    public static final String IS_BUILDING_EXIST = "SELECT B_ID FROM BUILDING WHERE CODE = ?";

    public static final String LIST_ALL_BUILDINGS = "SELECT * FROM BUILDING ";

    public static final String BUILDINGS_SEARCH = "SELECT * FROM BUILDING WHERE LOWER(CODE) LIKE ?";
    //___________________________________________________________________________________

    //________________________________ BUILDING_FLOOR MODULE __________________________________
      public static final String INSER_NEW_FLOOR =
          "INSERT INTO FLOOR (CODE,DESCRIPTON,INSERTION_DATE,UPDATE_DATE,INSERTED_BY,UPDATED_BY)" +
          "VALUES (?,?,?,?,?,?)";

      public static final String DELETE_FLOOR = "DELETE FROM FLOOR WHERE CODE = ? ";

      public static final String IS_FLOOR_EXIST = "SELECT ID FROM FLOOR WHERE CODE = ?";
      
      public static final String UPDATE_FLOOR =
          "UPDATE FLOOR SET  DESCRIPTON = ? , UPDATED_BY = ? ,UPDATE_DATE = ? WHERE CODE = ?";

      public static final String LIST_ALL_FLOORS = "SELECT * FROM FLOOR ";
      
      public static final String FLOORS_SEARCH = "SELECT * FROM FLOOR WHERE LOWER(CODE) LIKE ?";
      //___________________________________________________________________________________
      
      
      
      //________________________________ LOCATION_TYPE MODULE __________________________________
      public static final String INSER_NEW_LOCATION_TYPE =
          "INSERT INTO LOCATION_TYPE (CODE,DESCRIPTION,INSERTED_BY,UPDATED_BY,INSERTION_DATE,UPDATE_DATE)" +
          "VALUES (?,?,?,?,?,?)";

      public static final String DELETE_LOCATION_TYPE = "DELETE FROM LOCATION_TYPE WHERE CODE = ? ";

      public static final String IS_LOCATION_TYPE_EXIST = "SELECT T_ID FROM LOCATION_TYPE WHERE CODE = ?";
      
      public static final String UPDATE_LOCATION_TYPE =
          "UPDATE LOCATION_TYPE SET  DESCRIPTION = ?, UPDATED_BY = ? ,UPDATE_DATE = ? WHERE CODE = ?";

      public static final String LIST_ALL_LOCATION_TYPES = "SELECT * FROM LOCATION_TYPE ";
      
      public static final String LOCATION_TYPE_SEARCH = "SELECT * FROM LOCATION_TYPE WHERE LOWER(CODE) LIKE ?";
      //___________________________________________________________________________________
      


    //________________________________ LOCATION MODULE __________________________________
    public static final String INSER_NEW_LOCATION = "INSERT INTO LOCATION (L_ID ,CODE , DESCRIPTION,CAPACITY,STATUS,BUILDING_ID,FLOOR_ID, TYPE_ID ,EQUIPMENT_CODE,INSERTED_BY,INSERTION_DATE) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    
    public static final String INSER_NEW_OCCUPATION_PURPOSE = "INSERT INTO LOCATION (OCCUPATION_PURPOSE) VALUES(?)";

    public static final String LIST_ALL_LOCATION = "select location.l_id,location.code ,location.description ,location.capacity,location.status,building.code building_code , floor.code floor_code  ,location_type.\"code \" type_code ,location.inserted_by,location.insertion_date,location.updated_by,location.update_date " + 
    "from location , floor ,building ,location_type " + 
    "where location.floor_id = floor.id and location.building_id =building.b_id and location.type_id =location_type.t_id ";

    public static final String DELETE_LOCATION = "DELETE FROM LOCATION WHERE L_ID  = ? ";

    public static final String IS_LOCATION_EXIST = "SELECT L_ID FROM LOCATION WHERE CODE = ?";

    public static final String UPDATE_LOCATION =
        "UPDATE LOCATION SET   CODE =? , DESCRIPTION = ?, CAPACITY = ? ,STATUS = ?,   BUILDING_ID = ? ,FLOOR_ID = ? ,TYPE_ID = ?,UPDATED_BY = ? , UPDATE_DATE =?   WHERE L_ID =?";

    public static final String LOCATION_SEARCH = "select location.l_id,location.code ,location.description ,location.capacity,location.status,building.code building_code , floor.code floor_code  ,location_type.\"code \" type_code ,location.inserted_by,location.insertion_date,location.updated_by,location.update_date " + 
    "from location , floor ,building ,location_type " + 
    "where location.floor_id = floor.id and location.building_id =building.b_id and location.type_id =location_type.t_id  and LOWER(location.CODE) LIKE ?";
    
    public static final String LOCATION_FILTER = "select location.l_id,location.code ,location.description ,location.capacity,location.status,building.code building_code , floor.code floor_code  ,location_type.\"code \" type_code ,location.inserted_by,location.insertion_date,location.updated_by,location.update_date " + 
     "from location , floor ,building ,location_type " +  
     "where location.floor_id = floor.id and location.building_id =building.b_id and location.type_id =location_type.t_id  and LOWER(location_type.\"code \") LIKE ? and lower(building.code) like ? " ;
    //___________________________________________________________________________________

    //________________________________ EQUIPMENT MODULE __________________________________
    public static final String INSER_NEW_Equipment = "INSERT INTO Equipment (ID ,CODE , TYPE ,LIFE_SPAN ,USING_START_TIME ,inserted_by ,insertion_date,Location_id) VALUES(?,?,?,?,?,?,?,?)";
    
    public static final String LIST_ALL_EQUIPMENTS = "SELECT equipment.id , equipment.code ,equipment.type, equipment.life_span, equipment.using_start_time ,location.code Location, equipment.inserted_by ,equipment.updated_by ,equipment.insertion_date, equipment.update_date " + 
    "FROM Equipment , location  where equipment.location_id = location.l_id ";

    public static final String DELETE_Equipment = "DELETE FROM Equipment WHERE ID  = ? ";

    public static final String IS_Equipment_EXIST = "SELECT ID FROM Equipment WHERE CODE = ?";

    public static final String UPDATE_Equipment =
        "UPDATE Equipment SET   CODE =? , TYPE = ?, LIFE_SPAN = ? ,  updated_by = ? , update_date=? , location_id = ? WHERE ID =?";

    public static final String Equipment_SEARCH = "SELECT equipment.id , equipment.code ,equipment.type, location.code Location, equipment.life_span , equipment.using_start_time ,equipment.inserted_by ,equipment.updated_by ,equipment.insertion_date, equipment.update_date " + 
    "FROM Equipment , location where equipment.location_id = location.l_id and LOWER(equipment.code) LIKE ?";

    //___________________________________________________________________________________

}
