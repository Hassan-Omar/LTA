package com.fym.lta.common;


public class Queries {

    //_____________________________ USER MODULE _______________________________________
    public static final String INSER_NEW_USER =
        "INSERT INTO USERS (USERNAME,PASSWORD,ROLE_ID,INSERTION_DATE" + ",INSERTED_BY,EMP_ID) " +
        "VALUES (?,?,?,?,?,?)";

    public static final String LIST_ALL_USER =
        "SELECT EMPLOYEE.FNAME , EMPLOYEE.SNAME , EMPLOYEE.TNAME , EMPLOYEE.FAMILY_NAME " +
        ",USERS.USERNAME ,USERS.INSERTION_DATE ,USERS.UPDATE_DATE ,USERS.INSERTED_BY ,USERS.UPDATED_BY ,USERS.EMAIL,ROLE.CODE " +
        "FROM EMPLOYEE , USERS , ROLE " + "WHERE EMPLOYEE.ID = USERS.EMP_ID AND ROLE.ROLEID = USERS.ROLE_ID  ";

    public static final String DELETE_USER = "DELETE FROM USERS WHERE USERNAME = ? ";

    public static final String UPDATE_USER =
        "UPDATE USERS SET PASSWORD = ?, ROLE_ID = ? " +
        ",UPDATED_BY = ? ,UPDATE_DATE = ? WHERE USERNAME = ? ";


    public static final String USER_SEARCH =
        "SELECT EMPLOYEE.FNAME , EMPLOYEE.SNAME , EMPLOYEE.TNAME , EMPLOYEE.FAMILY_NAME " +
        ",USERS.USERNAME ,USERS.INSERTION_DATE ,USERS.UPDATE_DATE ,USERS.INSERTED_BY ,USERS.UPDATED_BY ,EMPLOYEE.EMAIL,ROLE.CODE " +
        "FROM EMPLOYEE , USERS , ROLE " +
        "WHERE EMPLOYEE.ID = USERS.EMP_ID AND ROLE.ROLEID = USERS.ROLE_ID AND LOWER(USERS.USERNAME) LIKE ? ";

    public static final String LOGIN_CHECK = "SELECT USERNAME,PASSWORD FROM USERS WHERE USERNAME = ? AND PASSWORD = ?";

    public static final String IS_USER_EXIST = "SELECT USERNAME FROM USERS WHERE  USERNAME = ?";
    // need for edited
    public static final String GET_USER_EMAIL = "SELECT EMPLOYEE.EMAIL  " + 
    "FROM EMPLOYEE JOIN USERS " + 
    "ON EMPLOYEE.ID = USERS.EMP_ID  WHERE  USERNAME = ? ";
    //___________________________________________________________________________________


    //____________________________ ROLES MODULE _________________________________
    public static final String INSER_NEW_ROLE =
        "INSERT INTO ROLE (CODE ,DESCRIPTION ,INSERTED_BY  ,INSERTION_DATE  ) VALUES(?,?,?,?)";

    public static final String LIST_ALL_ROLES = "SELECT *  FROM ROLE";

    public static final String DELETE_ROLE = " DELETE FROM ROLE WHERE CODE = ?";

    public static final String IS_ROLE_EXIST = "SELECT CODE FROM ROLE WHERE CODE = ?";

    public static final String UPDATE_ROLE =
        "UPDATE ROLE SET DESCRIPTION = ? ,UPDATED_BY = ? ,UPDATE_DATE = ?  WHERE CODE = ?";

    public static final String ROLE_SEARCH = "SELECT CODE , DESCRIPTION ,ROLEID FROM ROLE WHERE LOWER(CODE) LIKE ?";

    public static final String CURRENT_ROLE =
        "SELECT ROLE.ROLEID FROM ROLE ,USERS WHERE  USERS.ROLE_ID = ROLE.ROLEID AND USERS.USERNAME  = ?";

    //___________________________________________________________________________________


    //____________________________ AUTHNTICATION SCREEN MODULE _________________________________

    public static final String ROLE_SCREEN_INSERT =
        "INSERT INTO ROLE_SCREEN (ROLEID ,SCREENID ,PERMISSIONTYPE ) VALUES (?,?,?)";

    public static final String GET_CURRENT_PERMISSION =
        "SELECT PERMISSIONTYPE FROM ROLE_SCREEN WHERE ROLEID = ? AND SCREENID = ? ";

    public static final String GET_AVAILABLE_SCREENS =
        "SELECT SCREENID,PERMISSIONTYPE FROM ROLE_SCREEN WHERE ROLEID = ? ";

    public static final String SCREEN_ROLE_ISEXIST =
        "SELECT SCREENID FROM ROLE_SCREEN WHERE ROLEID = ? AND SCREENID = ?";

    public static final String UPDATESCREEN_ROLE =
        "UPDATE ROLE_SCREEN SET PERMISSIONTYPE = ? WHERE ROLEID =? AND  SCREENID =? ";

    public static final String DELETE_SCREEN_ROLE = "DELETE FROM ROLE_SCREEN WHERE  SCREENID =? AND ROLEID =?";
    
    public static final String LIST_SCREEN ="SELECT X.SCREENID , X.DESCRIPTION  FROM SCREEN X " ;
        
    //___________________________________________________________________________________


    //____________________________ EMPLOYEE MODULE _________________________________


    public static final String INSER_NEW_EMPLOYEE =
        "INSERT INTO EMPLOYEE (FNAME , SNAME , TNAME ," +
        "FAMILY_NAME ,INSERTED_BY  ,ISERTED_DATE  ,EMAIL ,POSITION ,DEP_CODE) VALUES (?,?,?,?,?,?,?,?,?)";


    public static final String LIST_ALL_EMPLOYEE =
        "SELECT X.FNAME , X.SNAME , X.TNAME , X.FAMILY_NAME " +
        ",X.INSERTED_BY ,X.UPDATED_BY ,X.ISERTED_DATE ,X.UPDATED_DATE ,X.EMAIL ,X.POSITION ,X.ID ,Y.NAME " +
        "FROM EMPLOYEE X , DEPARTMENT Y " + "WHERE X.DEP_CODE = Y.CODE ";

    public static final String DELETE_EMPLOYEE = "DELETE FROM EMPLOYEE WHERE EMAIL = ? ";

    public static final String IS_EMPLOYEE_EXIST = "SELECT ID FROM EMPLOYEE WHERE EMAIL = ?";

    public static final String UPDATE_EMPLOYEE =
        "UPDATE EMPLOYEE SET FNAME =? , SNAME =? , TNAME =?  , FAMILY_NAME =? " +
        ",UPDATED_BY=?  ,UPDATED_DATE=?  ,POSITION=? ,DEP_CODE=?  WHERE EMAIL =?";

    public static final String EMPLOYEE_SEARCH =
        "SELECT X.FNAME , X.SNAME , X.TNAME" +
        ", X.FAMILY_NAME,X.INSERTED_BY ,X.UPDATED_BY ,X.ISERTED_DATE ,X.UPDATED_DATE ,X.EMAIL ,X.POSITION ,X.ID ,Y.NAME " +
        "FROM EMPLOYEE X , DEPARTMENT Y " +
        "WHERE X.DEP_CODE = Y.CODE AND ( LOWER(FNAME) LIKE ? OR  LOWER(SNAME) LIKE ? OR  LOWER(TNAME) LIKE ? ) ";
    //___________________________________________________________________________________


    //________________________________ BUILDING MODULE __________________________________
    public static final String INSER_NEW_BUILDING =
        "INSERT INTO BUILDING (CODE,DESCRIPTION,INSERTION_DATE,INSERTED_BY )" + "VALUES (?,?,?,?)";

    public static final String DELETE_BUILDING = "DELETE FROM BUILDING WHERE CODE = ? ";

    public static final String UPDATE_BUILDING =
        "UPDATE BUILDING SET DESCRIPTION=? , UPDATED_BY = ? , UPDATE_DATE = ?  WHERE CODE=? ";

    public static final String IS_BUILDING_EXIST = "SELECT B_ID FROM BUILDING WHERE CODE = ?";

    public static final String LIST_ALL_BUILDINGS = "SELECT * FROM BUILDING ";

    public static final String BUILDINGS_SEARCH = "SELECT * FROM BUILDING WHERE LOWER(CODE) LIKE ?";
    //___________________________________________________________________________________

    //________________________________ FLOOR MODULE __________________________________
    public static final String INSER_NEW_FLOOR =
        "INSERT INTO FLOOR (CODE,DESCRIPTON,INSERTION_DATE,INSERTED_BY,ID_BUILDING)" + "VALUES (?,?,?,?,?)";

    public static final String DELETE_FLOOR = "DELETE FROM FLOOR WHERE CODE = ? ";

    public static final String IS_FLOOR_EXIST = "SELECT ID FROM FLOOR WHERE CODE = ?";

    public static final String UPDATE_FLOOR =
        "UPDATE FLOOR SET  DESCRIPTON = ? , UPDATED_BY = ? ,UPDATE_DATE = ? ,ID_BUILDING = ? WHERE CODE = ?";

    public static final String LIST_ALL_FLOORS =
        "SELECT X.ID, X.CODE ,X.DESCRIPTON , Y.CODE " + "FROM FLOOR X , BUILDING Y " + "WHERE X.ID_BUILDING =Y.B_ID ";

    public static final String FLOORS_SEARCH =
        "SELECT X.ID, X.CODE ,X.DESCRIPTON , Y.CODE " + "FROM FLOOR X , BUILDING Y " +
        "WHERE X.ID_BUILDING =Y.B_ID AND LOWER(X.CODE) LIKE ?";

    public static final String FLOOR_FILTER = "Select Floor.Id ,Floor.Code  From Floor Join Building On Floor.Id_Building = Building.B_Id " + 
    "where Building.B_Id = ? ";
    
    //___________________________________________________________________________________


    //________________________________ LOCATION_TYPE MODULE __________________________________
    public static final String INSER_NEW_LOCATION_TYPE =
        "INSERT INTO LOCATION_TYPE (CODE,DESCRIPTION,INSERTED_BY,INSERTION_DATE)" + "VALUES (?,?,?,?)";

    public static final String DELETE_LOCATION_TYPE = "DELETE FROM LOCATION_TYPE WHERE CODE = ? ";

    public static final String IS_LOCATION_TYPE_EXIST = "SELECT T_ID FROM LOCATION_TYPE WHERE CODE = ?";

    public static final String UPDATE_LOCATION_TYPE =
        "UPDATE LOCATION_TYPE SET  DESCRIPTION = ?, UPDATED_BY = ? ,UPDATE_DATE = ? WHERE CODE = ?";

    public static final String LIST_ALL_LOCATION_TYPES = "SELECT * FROM LOCATION_TYPE ";

    public static final String LOCATION_TYPE_SEARCH = "SELECT * FROM LOCATION_TYPE WHERE LOWER(CODE) LIKE ?";
    //___________________________________________________________________________________


    //________________________________ LOCATION MODULE __________________________________

    public static final String INSER_NEW_LOCATION =
        "INSERT INTO LOCATION (CODE , DESCRIPTION,CAPACITY,FLOOR_ID, TYPE_ID ,INSERTED_BY,INSERTION_DATE) VALUES(?,?,?,?,?,?,?)";

    public static final String INSER_NEW_OCCUPATION_PURPOSE = "INSERT INTO LOCATION (OCCUPATION_PURPOSE) VALUES(?)";

    public static final String LIST_ALL_LOCATION =
        "select location.l_id,location.code ,location.description ,location.capacity , location_type.DESCRIPTION,building.code building_code , floor.code floor_code  ,location_type.code type_code ,location.inserted_by,location.insertion_date,location.updated_by,location.update_date \n" +
        "from location , floor ,building ,location_type " +
        "where location.floor_id = floor.id and floor.id_building = building.b_id and location.type_id =location_type.t_id ";

    public static final String DELETE_LOCATION = "DELETE FROM LOCATION WHERE CODE  = ? ";

    public static final String IS_LOCATION_EXIST = "SELECT L_ID FROM LOCATION WHERE CODE = ?";

    public static final String UPDATE_LOCATION =
        "UPDATE LOCATION SET  DESCRIPTION = ?, CAPACITY = ? ,FLOOR_ID = ? ,TYPE_ID = ?,UPDATED_BY = ? , UPDATE_DATE =?   WHERE CODE =? ";

    public static final String LOCATION_SEARCH =
        "select location.l_id,location.code ,location.description ,location.capacity,building.code building_code , floor.code floor_code  ,location_type.code  type_code ,location.inserted_by,location.insertion_date,location.updated_by,location.update_date " +
        "from location , floor ,building ,location_type " +
        "where location.floor_id = floor.id and floor.id_building = building.b_id and location.type_id =location_type.t_id  and LOWER(location.CODE) LIKE ?";

     public static final String LOCATION_FILTER =
        "select location.L_ID, location.code ,location.description ,location.capacity,building.code building_code, floor.code floor_code  ,location_type.code type_code " +
        "from location , floor ,building ,location_type " +
        "where location.floor_id = floor.id and floor.id_building = building.b_id and location.type_id =location_type.t_id  and location_type.code LIKE ? and building.code like ? ";

    public static final String AVAILABLE_ROOM =
        "SELECT X.L_ID ,X.CAPACITY , O.DESCRIPTION " +
        "FROM LOCATION X ,FLOOR Y , BUILDING Z , DEPARTMENT W , DEPARTMENT_BUILDING S , LOCATION_TYPE O " +
        "WHERE X.FLOOR_ID = Y.ID AND  Y.ID_BUILDING = Z.B_ID AND  W.CODE = S.CODE_DEPARTMENT " +
        "AND Z.B_ID = S.ID_BUILDING AND O.T_ID = X.TYPE_ID  AND W.CODE = ? ";

    public static final String AVAILABLE_ROOM_SLOT =
        "SELECT SLOT_CODE , SLOT_ID FROM LOCATION_SLOT WHERE LOCATION_ID = ? ";

    public static final String INSERT_LOCATION_SLOT =
        "INSERT INTO LOCATION_SLOT (LOCATION_ID , SLOT_CODE , SLOT_ID  ) VALUES(?,?,?)";

    public static final String UPDATE_LOCATION_SLOT =
        "UPDATE LOCATION_SLOT SET SLOT_CODE = ? WHERE LOCATION_ID = ? AND SLOT_ID =? ";

    //___________________________________________________________________________________


    //________________________________ EQUIPMENT MODULE __________________________________
    public static final String INSER_NEW_Equipment =
        "INSERT INTO Equipment (CODE , TYPE ,LIFE_SPAN  ,INERTED_BY ,INSERTION_DATE ,Location_id) VALUES(?,?,?,?,?,?)";


    public static final String LIST_ALL_EQUIPMENTS =
        "SELECT equipment.id , equipment.code ,equipment.type, equipment.life_span, equipment.using_start_time ,location.code Location, equipment.INERTED_BY ,equipment.updated_by ,equipment.insertion_date, equipment.update_date " +
        "FROM Equipment , location  where equipment.location_id = location.l_id ";


    public static final String DELETE_Equipment = "DELETE FROM Equipment WHERE CODE  = ? ";

    public static final String IS_Equipment_EXIST = "SELECT ID FROM Equipment WHERE CODE = ?";

    public static final String UPDATE_Equipment =
        "UPDATE Equipment SET   TYPE = ?, LIFE_SPAN = ? ,  updated_by = ? , update_date=? , location_id = ? WHERE CODE =?";

    public static final String Equipment_SEARCH =
        "SELECT equipment.id , equipment.code ,equipment.type, location.code Location, equipment.life_span , equipment.using_start_time ,equipment.INERTED_BY ,equipment.updated_by ,equipment.INSERTION_DATE, equipment.update_date " +
        "FROM Equipment , location where equipment.location_id = location.l_id and LOWER(equipment.code) LIKE ?";

    //___________________________________________________________________________________


    //________________________________ Schedule MODULE __________________________________

    public static final String INSER_NEW_SCHEDULE =
        "INSERT INTO grade_schedule (SCHEDULECODE , ACADEMIC_YEAR,DEPARTMENT_CODE ,STUDENTS_NUMBER) VALUES(?,?,?,?)";

    public static final String DELETE_SCHEDULE = "DELETE FROM GRADE_SCHEDULE WHERE SCHEDULECODE =? ";

    public static final String LIST_ALL_SCHEDULE = "SELECT * FROM GRADE_SCHEDULE";

    public static final String SCHEDULE_SEARCH = "SELECT *  FROM GRADE_SCHEDULE WHERE LOWER(SCHEDULECODE) LIKE ?  ";

    public static final String IS_EXIST_SCHEDULE = "SELECT SCHEDULECODE FROM GRADE_SCHEDULE WHERE SCHEDULECODE = ? ";

    public static final String UPDATE_SCHEDULE =
        "UPDATE GRADE_SCHEDULE SET  ACADEMIC_YEAR =? , DEPARTMENT_CODE =? ,STUDENTS_NUMBER = ?  WHERE  SCHEDULECODE =? ";

    public static final String LIST_SCHEDULE_INDEPART =
        "SELECT * FROM GRADE_SCHEDULE " + "WHERE GRADE_SCHEDULE.DEPARTMENT_CODE = ? ";
   
    public static final String SHOW_SCHEDULE_SLOTS  ="SELECT w.position, w.FNAME,w.sname, y.name,y.code ,z.code ,x.id " +
        "from employee w ,slot x, course y,location z,location_slot s where w.email=x.staff_email and x.course_code=y.code and z.l_id=s.location_id and x.id=s.slot_id  and x.s_code= ?";
   
    public static final String SHOW_SCHEDULE = "SELECT X.SCHEDULECODE  , X.ACADEMIC_YEAR , X.STUDENTS_NUMBER , X.ID , Y.CODE , Y.NAME " +
        "FROM GRADE_SCHEDULE X , DEPARTMENT Y  WHERE Y.CODE = X.DEPARTMENT_CODE AND  SCHEDULECODE = ? ";


    //________________________________________________________________________________


    //________________________________ SLOT  MODULE __________________________________

    public static final String INSER_NEW_SLOT =
        "INSERT INTO SLOT ( COURSE_CODE , STAFF_EMAIL ,STAFF_EMAIL2 , CODE ,TYPE ,PREFSPACE ,S_CODE) VALUES(?,?,?,?,?,?,?) ";

    public static final String UPDATE_SLOT =
        "UPDATE SLOT SET COURSE_CODE = ? , STAFF_EMAIL =? , STAFF_EMAIL2 =? , TYPE = ? ,CODE = ? , PREFSPACE=? WHERE S_CODE = ? ";

    public static final String IS_SLOT_EXIST =
        "SELECT ID FROM SLOT WHERE CODE =? AND COURSE_CODE = ? AND STAFF_EMAIL =? AND STAFF_EMAIL2 = ? AND S_CODE = ? ";


    public static final String DELETE_SLOT = "DELETE FROM SLOT WHERE S_CODE = ?";

    public static final String LIST_SLOTS = "SELECT * FROM SLOT WHERE SLOT.S_CODE = ?";

    public static final String IS_SLOT_ASSIGNED =
        "SELECT LOCATION_ID FROM LOCATION_SLOT WHERE SLOT_ID = ? ";
    //_________________________________________________________________________________


    //__________________________________Course Model___________________________________

    public static final String LIST_ALL_COURSES = "SELECT * FROM COURSE";

    public static final String DELETE_COURSE = "DELETE FROM COURSE WHERE CODE = ? ";
    public static final String DELETE_DEPARTMENT_COURSE = "DELETE FROM COURSE_DEPARTMENT WHERE COURSE_CODE = ? ";

    public static final String UPDATE_COURSE =
        "UPDATE COURSE SET  CODE = ?, NAME = ? ,UPDATED_BY = ?" +
        ",UPDATE_DATE = ? ,HOURS_PER_WEEK =? ,LT_CODE =? ,DESCRIPTION = ? WHERE CODE = ?";
    public static final String UPDATE_DEPARTMENT_COURSE =
        "UPDATE  COURSE_DEPARTMENT SET D_CODE = ? WHERE COURSE_CODE = ?";

    public static final String IS_COURSE_EXIST = "SELECT ID FROM COURSE WHERE CODE = ?";

    public static final String INSERT_NEW_COURSE =
        "INSERT INTO COURSE (CODE,NAME,INSERTED_BY  ,INSERTION_DATE" +
        " , HOURS_PER_WEEK ,LT_CODE ,DESCRIPTION) VALUES (?,?,?,?,?,?,?)";
    public static final String INSERT_DEPARTMENT_COURSE =
        "INSERT INTO COURSE_DEPARTMENT (COURSE_CODE ,D_CODE) VALUES(?,?)";


    public static final String SEARCH_COURSES = "SELECT * FROM COURSE WHERE LOWER(CODE) LIKE ? OR LOWER(NAME) LIKE ?";

    //_________________________________________________________________________________


    //________________________________ Department Module _______________________________

    public static final String LIST_ALL_DEPARTMENT =
        "SELECT X.D_ID, X.NAME , x.code , Y.B_ID  ,y.code ," +
        "X.INSERTED_BY , X.UPDATED_BY , X.INSERTION_DATE , X.UPDATE_DATE " +
        "FROM DEPARTMENT X , BUILDING Y , DEPARTMENT_BUILDING " +
        "WHERE DEPARTMENT_BUILDING.ID_BUILDING =Y.B_ID AND DEPARTMENT_BUILDING.CODE_DEPARTMENT = X.CODE ";

    public static final String DELETE_DEPARTMENT = "DELETE FROM DEPARTMENT WHERE CODE = ? ";
    public static final String DELETE_BUILDING_TO_DEPARTMENT =
        "DELETE FROM DEPARTMENT_BUILDING WHERE CODE_DEPARTMENT = ? ";

    public static final String INSERT_NEW_DEPARTMENT =
        "INSERT INTO DEPARTMENT (CODE,NAME,INSERTION_DATE ,INSERTED_BY) VALUES (?,?,?,?) ";
    public static final String INSERT_BUILDING_TO_DEPARTMENT =
        "INSERT INTO DEPARTMENT_BUILDING (ID_BUILDING , CODE_DEPARTMENT) VALUES(?,?) ";
    public static final String UPDATE_DEPARTMENT =
        "UPDATE DEPARTMENT SET  NAME = ? , UPDATE_DATE=? ,UPDATED_BY = ? WHERE CODE = ?";
    public static final String UPDATE_BUILDING_TO_DEPARTMENT =
        "UPDATE DEPARTMENT_BUILDING SET ID_BUILDING = ?  WHERE CODE_DEPARTMENT = ? ";
    public static final String IS_DEPARTMENT_EXIST = "SELECT * FROM DEPARTMENT WHERE CODE = ?";

    public static final String DEPARTMENT_SEARCH =
        "SELECT X.D_ID, X.NAME , x.code , Y.B_ID  ,y.code , " +
        "        X.INSERTED_BY , X.UPDATED_BY , X.INSERTION_DATE , X.UPDATE_DATE " +
        "    FROM DEPARTMENT X , BUILDING Y , DEPARTMENT_BUILDING " +
        "    WHERE DEPARTMENT_BUILDING.ID_BUILDING =Y.B_ID AND DEPARTMENT_BUILDING.CODE_DEPARTMENT = X.CODE " +
        "        AND LOWER(X.CODE) LIKE ? OR  LOWER(X.NAME) LIKE ? ";

    //_________________________________________________________________________________________


    //________________________________ Search Module __________________________________
    //search in location , building , floor , location type , equipment
    public static final String SEARCH_1 =
        "select building.code \"Building Code\" ,floor.code \"Floor Code\" ,location.code \"Location Code\",location_type.code \"Location Type Code\",equipment.code \"Equipment Code\" " +
        "from location join building on building.b_id = location.building_id join floor on floor.id = location.floor_id join location_type on location.type_id = location_type.t_id join equipment on equipment.location_id = location.l_id " +
        "where LOWER(location.code) like ? OR LOWER(floor.code) like ? OR LOWER(building.code) like ? OR LOWER(equipment.code) like ? OR LOWER(location_type.code) like ? ";

}
