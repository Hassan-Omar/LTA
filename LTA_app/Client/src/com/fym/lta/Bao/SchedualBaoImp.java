
package com.fym.lta.bao;

import com.fym.lta.dao.DaoFactory;
import com.fym.lta.dao.SchedualDao;
import com.fym.lta.dto.CourseDto;
import com.fym.lta.dto.EmployeeDto;
import com.fym.lta.dto.SchedualDto;
import com.fym.lta.dto.SlotDto;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;


public class SchedualBaoImp implements SchedualBao {

    SchedualDao schedualDao = new DaoFactory().createSchedualDao();


    public boolean saveSchedual(SchedualDto schedual) {

        boolean status = false;

        if (schedualDao.isExist(schedual.getSCHEDULECODE())) {
            try {
                status = schedualDao.update_Schedual(schedual);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else
            try {
                status = schedualDao.insert_Schedual(schedual);
            } catch (SQLException e) {
                e.printStackTrace();

            }


        return status;
    }


    public List<SchedualDto> SearchSchedual(String SCHEDULECODE) {

        if (SCHEDULECODE == null)
            return schedualDao.getAll_Scheduals();

        return schedualDao.SearchSchedual(SCHEDULECODE);

    }

    public boolean deleteSchedual(String SCHEDULECODE)

    {
        return schedualDao.delete_Schedual(SCHEDULECODE);
    }


    public List<SchedualDto> listAll() {

        return schedualDao.getAll_Scheduals();

    }

    @Override
    public List<SchedualDto> listSchedual_inDeparts(String code) {
        /*  List<SchedualDto> tables = new ArrayList();
        for (int k = 1; k < 5; k++) {
            SchedualDto sch = new SchedualDto();
            sch = createSch(20 * k, 10 * k, k);
            tables.add(sch);
        }
        return tables; */

        return schedualDao.listSchedual_inDeparts(code);
    }

    public SchedualDto createSch(int statrt, int sNum, int var) {
        SchedualDto sch1 = new SchedualDto();
        sch1.setAcademicYear(2019);
        sch1.setCodeDeparment("cse");
        sch1.setSCHEDULECODE("sce3rd" + var);
        sch1.setStudent_number(sNum);

        List<SlotDto> slots = new ArrayList();
        for (int i = statrt; i < statrt + 20; i++) {
            SlotDto slot = new SlotDto();
            slot.setCode(i);
            slot.setPrefSpace("lab");
            slot.setType("section");
            slot.setSlot_id(i);
            EmployeeDto emp1 = new EmployeeDto();
            emp1.setEmail(var + "h@fay.com");
            EmployeeDto emp2 = new EmployeeDto();
            emp2.setEmail(var + "h@fay.com");
            List<EmployeeDto> Instructors = new ArrayList();
            Instructors.add(emp1);
            Instructors.add(emp2);
            slot.setCrrentStaffMemb(emp1);
            CourseDto course = new CourseDto();
            course.setCode("phy" + var);
            course.setInstructors(Instructors);
            slot.setCurrentCourse(course);
            slots.add(slot);
        }
        sch1.setSchedual_Slots(slots);

        return sch1;
    }
}
