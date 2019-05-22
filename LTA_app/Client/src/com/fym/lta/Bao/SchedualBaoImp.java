
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


public class SchedualBaoImp implements SchedualBao 
{ 

    SchedualDao SchedualDao = new DaoFactory().createSchedualDao();
    SlotBao slotBaoObj = new BaoFactory().createSlotBao(); 
    
    public boolean saveSchedual(SchedualDto schedual) 
    {

    boolean  status = false ; 
    System.out.println("current code"+schedual.getSCHEDULECODE());
    if(SchedualDao.isExist(schedual.getSCHEDULECODE()))
    {
            try {
                status = SchedualDao.update_Schedual(schedual);
               
                System.out.println("called from update");
                
            } catch (SQLException e) { 
            }
        }
    else
            try {
                status = SchedualDao.insert_Schedual(schedual);
                System.out.println("called from insert");
            } catch (SQLException e) {
            }
    
   if(status)
   {for (int i = 0 ; i<schedual.getSchedual_Slots().size() ; i++)
     {slotBaoObj.saveSlot(schedual.getSchedual_Slots().get(i));}
     
       }
        return status;
}



    public List<SchedualDto>  SearchSchedual(String SCHEDULECODE)
    {
        
        if (SCHEDULECODE==null)
            return SchedualDao.getAll_Scheduals() ; 
        
        return SchedualDao.SearchSchedual(SCHEDULECODE);
                
    }

    public boolean deleteSchedual(String SCHEDULECODE)
    
    {
        return SchedualDao.delete_Schedual(SCHEDULECODE) ;
    }
    
    
    
    public List<SchedualDto> listAll()
    {
        
            return SchedualDao.getAll_Scheduals();

        }

    @Override
    public List<SchedualDto> listSchedual_inDeparts(String name) {
        List<SchedualDto> tables = new ArrayList() ;
        for (int k =1;k<5;k++)
        { 
            SchedualDto sch = new SchedualDto() ;
            sch= createSch(20*k ,10*k ,k) ; 
            tables.add(sch) ;
            }
        return tables;
    }
    
    public SchedualDto createSch(int statrt , int sNum ,int var)
    {   
        SchedualDto sch1 = new SchedualDto() ;
        sch1.setAcademicYear("2019");
        sch1.setCodeDeparment("cse");
        sch1.setSCHEDULECODE("sce3rd"+var);
        sch1.setStudent_number(sNum);
        
        List<SlotDto> slots = new ArrayList() ;
        for(int i=statrt; i<statrt+20 ; i++ )
        {  
            SlotDto slot = new SlotDto() ;
            slot.setCode("slot"+i);
            slot.setPrefSpace("lab");
            slot.setType("section");
            slot.setSlot_id(i);
            EmployeeDto emp1 = new EmployeeDto();
            emp1.setEmail(var+"h@fay.com");
            EmployeeDto emp2 = new EmployeeDto();
            emp2.setEmail(var+"h@fay.com");
            List<EmployeeDto> Instructors =new ArrayList();
            Instructors.add(emp1);
            Instructors.add(emp2);
            slot.setCrrentStaffMemb(emp1);
            CourseDto course =new CourseDto() ;
            course.setCode("phy"+var);
            course.setInstructors(Instructors);
            slot.setCurrentCourse(course);
            slots.add(slot) ;
            }
        sch1.setSchedual_Slots(slots);
        
        return sch1 ;
        }
}
