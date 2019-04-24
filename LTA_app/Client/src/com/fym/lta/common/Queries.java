package com.fym.lta.common;


public class Queries {
   
   
    //_____________________________ USER MODULE _______________________________________
    public static final String INSER_NEW_USER =
        "INSERT INTO USERS (USERNAME,PASSWORD,ROLE_ID,INSERTION_DATE,UPDATE_DATE" +
        ",INSERTED_BY,UPDATED_BY,EMAIL,FNAME,SNAME,LNAME,FAMILYNAME) " + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

    public static final String LIST_ALL_USER = "SELECT * FROM USERS ";

    public static final String DELETE_USER = "DELETE FROM USERS WHERE ID = ? ";

    public static final String UPDATE_USER =
        "UPDATE USERS SET USERNAME = ?, PASSWORD = ?, EMAIL = ? , ROLE_ID = ? " +
        ",FNAME = ?, SNAME = ?, LNAME = ?,FAMILYNAME = ?,UPDATED_BY = ? ,UPDATE_DATE = ? WHERE ID = ?";

    public static final String IS_USER_EXIST = "SELECT ID FROM USERS WHERE EMAIL = ?";


    public static final String USER_SEARCH = "SELECT * FROM USERS WHERE LOWER(EMAIL) LIKE ?";

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
    public static final String INSER_NEW_LOCATION = "INSERT INTO LOCATION (CODE , DESCRIPTION,CAPACITY) VALUES(?,?,?)";

    public static final String LIST_ALL_LOCATION = "SELECT * FROM LOCATION ";

    public static final String DELETE_LOCATION = "DELETE FROM LOCATION WHERE L_ID  = ? ";

    public static final String IS_LOCATION_EXIST = "SELECT L_ID FROM LOCATION WHERE CODE = ?";

    public static final String UPDATE_LOCATION =
        "UPDATE LOCATION SET L_ID = ? ,CODE =? , DESCRIPTION = ?, CAPACITY = ?";
    
    public static final String LOCATION_SEARCH = "SELECT * FROM LOCATION WHERE LOWER(CODE) LIKE ?";

    //___________________________________________________________________________________
}
