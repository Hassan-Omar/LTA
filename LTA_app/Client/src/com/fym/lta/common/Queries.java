package com.fym.lta.common;


public class Queries {
    public Queries() {
        super();
    }


    //______________ USER MODULE_______________________________________
    public static final String INSER_NEW_USER =
        "INSERT INTO USERS (USERNAME,PASSWORD,ROLE_ID,INSERTION_DATE,UPDATE_DATE" +
        ",INSERTED_BY,UPDATED_BY,EMAIL,FNAME,SNAME,LNAME,FAMILYNAME) " + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

    public static final String LIST_ALL_USER = "SELECT * FROM USERS ";

    public static final String DELETE_USER = "DELETE FROM USERS WHERE ID = ? ";

    public static final String UPDATE_USER =
        "UPDATE USERS SET USERNAME = ?, PASSWORD = ?, EMAIL = ? , ROLE_ID = ? " +
        ",FNAME = ?, SNAME = ?, LNAME = ?,FAMILYNAME = ?,UPDATED_BY = ? ,UPDATE_DATE = ? WHERE ID = ?";

    public static final String IS_USER_EXISTE = "SELECT ID FROM USERS WHERE EMAIL = ?";
    

    public static final String USER_SEARCH = "SELECT * FROM USERS WHERE LOWER(FNAME) LIKE ?";

    //___________________________________________________________________


    //____________________ STAFF MEMBERS MODULE_____________________________
    public static final String INSER_NEW_EMPLOYEE =
        "INSERT INTO EMPLOYEE (FNAME,SNAME,TNAME,FAMILY_NAME) VALUES (?,?,?,?)";

    public static final String LIST_ALL_EMPLOYEE = "SELECT * FROM EMPLOYEE";
    //____________________________________________________________________


    //____________________ BUILDING MODULE_____________________________
    public static final String INSER_NEW_BUILDING =
        "INSERT INTO BUILDING (CODE,DESCRIPTION,INSERTION_DATE,UPDATE_DATE,INSERTED_BY,UPDATED_BY)" +
        "VALUES (?,?,?,?,?,?)";

    public static final String DELETE_BUILDING = "DELETE FROM BUILDING WHERE B_ID = ? ";

    public static final String LIST_ALL_BUILDINGS = "SELECT * FROM BUILDING ";
    //____________________________________________________________________


}
