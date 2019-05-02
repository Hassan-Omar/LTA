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

    public static final String USER_SEARCH ="SELECT EMPLOYEE.FNAME , EMPLOYEE.SNAME , EMPLOYEE.TNAME , EMPLOYEE.FAMILY_NAME " +
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

    public static final String ROLE_SCREEN_INSERT =
        "INSERT INTO ROLE_SCREEN (ROLEID ,SCREENID ,PERMISSIONTYPE ) VALUES (?,?,?)";

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


    //________________________________ LOCATION MODULE __________________________________
    public static final String INSER_NEW_LOCATION = "INSERT INTO LOCATION (L_ID ,CODE , DESCRIPTION,CAPACITY ,TYPE_CODE,FLOOR_CODE) VALUES(?,?,?,?,?,?)";
    
    public static final String INSER_NEW_OCCUPATION_PURPOSE = "INSERT INTO LOCATION (OCCUPATION_PURPOSE) VALUES(?)";

    public static final String LIST_ALL_LOCATION = "SELECT * FROM LOCATION ";

    public static final String DELETE_LOCATION = "DELETE FROM LOCATION WHERE L_ID  = ? ";

    public static final String IS_LOCATION_EXIST = "SELECT L_ID FROM LOCATION WHERE CODE = ?";

    public static final String UPDATE_LOCATION =
        "UPDATE LOCATION SET   CODE =? , DESCRIPTION = ?, CAPACITY = ? , TYPE_CODE = ? , FLOOR_CODE = ? WHERE L_ID =?";

    public static final String LOCATION_SEARCH = "SELECT * FROM LOCATION WHERE LOWER(CODE) LIKE ?";

    //___________________________________________________________________________________


}
