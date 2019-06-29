package com.fym.lta.dao;

import com.fym.lta.common.ConnectionFactory;
import com.fym.lta.common.LTAException;
import com.fym.lta.common.Queries;
import com.fym.lta.dao.SchedualDao;
import com.fym.lta.dto.CourseDto;
import com.fym.lta.dto.DepartmentDto;
import com.fym.lta.dto.EmployeeDto;
import com.fym.lta.dto.LocationDto;
import com.fym.lta.dto.SchedualDto;
import com.fym.lta.dto.SlotDto;

import com.sun.org.apache.bcel.internal.generic.Select;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class SchedualDaoImp implements SchedualDao {
    public List<SchedualDto> getAll_Scheduals() {

        List<SchedualDto> scheduals = null;

        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.LIST_ALL_SCHEDULE);
            jdbcRs.execute();

            while (jdbcRs.next()) {
                if (scheduals == null)

                    scheduals = new ArrayList<>();
                SchedualDto table = new SchedualDto();
                table.setSCHEDULECODE(jdbcRs.getString(1));
                table.setAcademicYear(jdbcRs.getInt(2));
                table.setStudent_number(jdbcRs.getInt(3));
                // table.setId(jdbcRs.getInt(4)); // no id i don't need it
                table.setCodeDeparment(jdbcRs.getString(5));

                // also you need to add the data inserted by , ...... etc
                table.setSchedual_Slots(list_Slots(table.getSCHEDULECODE()));

                scheduals.add(table);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scheduals;
    }

    public boolean delete_Schedual(String SCHEDULECODE) {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setAutoCommit(false);
            jdbcRs.setCommand(Queries.DELETE_SCHEDULE);
            jdbcRs.setString(1, SCHEDULECODE);
            jdbcRs.execute();

            jdbcRs.setCommand(Queries.DELETE_SLOT);
            jdbcRs.setString(1, SCHEDULECODE);
            jdbcRs.execute();
            jdbcRs.commit();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }


    public List<SchedualDto> SearchSchedual(String code) {
        List<SchedualDto> Scheduals = null;

        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.SCHEDULE_SEARCH);
            jdbcRs.setString(1, '%' + code.toLowerCase().trim() + '%');
            jdbcRs.execute();


            while (jdbcRs.next()) {
                if (Scheduals == null)

                    Scheduals = new ArrayList<>();
                SchedualDto table = new SchedualDto();
                table.setSCHEDULECODE(jdbcRs.getString(1));
                table.setAcademicYear(jdbcRs.getInt(2));
                table.setStudent_number(jdbcRs.getInt(3));
                // table.setId(jdbcRs.getInt(4)); // no id i don't need it
                table.setCodeDeparment(jdbcRs.getString(5));

                // also you need to add the data inserted by , ...... etc
                Scheduals.add(table);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Scheduals;


    }

    public boolean isExist(String code) {
        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            jdbcRs.setCommand(Queries.IS_EXIST_SCHEDULE);
            jdbcRs.setString(1, code);
            jdbcRs.execute();

            if (jdbcRs.next()) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean insert_Schedual(SchedualDto schedual) throws LTAException {
        try (JdbcRowSet jdbcR = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcR.setUrl(ConnectionFactory.getUrl());
            jdbcR.setUsername(ConnectionFactory.getUsername());
            jdbcR.setPassword(ConnectionFactory.getPassword());
            jdbcR.setAutoCommit(false);

            List<SlotDto> slots = schedual.getSchedual_Slots();

            for (int i = 0; i < slots.size(); i++) {
                SlotDto slot = slots.get(i);
                jdbcR.setCommand(Queries.INSER_NEW_SLOT);


                jdbcR.setString(1, slot.getCurrentCourse().getCode());

                if (slot.getCurrentCourse().getInstructors() != null)
                    jdbcR.setString(2, slot.getCurrentCourse().getInstructors().get(0).getEmail());
                else
                    jdbcR.setNull(2, Types.VARCHAR);


                if (slot.getCurrentCourse().getInstructors().size() > 1)
                    jdbcR.setString(3, slot.getCurrentCourse().getInstructors().get(1).getEmail());
                else
                    jdbcR.setNull(3, Types.VARCHAR);

                jdbcR.setInt(4, slot.getCode());

                jdbcR.setString(5, slot.getType());

                jdbcR.setString(6, slot.getPrefSpace());

                jdbcR.setString(7, schedual.getSCHEDULECODE());


                jdbcR.execute();
               // System.out.println("reci" + slot.getCode());
                
            }


            jdbcR.setCommand(Queries.INSER_NEW_SCHEDULE);

            jdbcR.setString(1, schedual.getSCHEDULECODE()); // SetSCHEDULECODE
            jdbcR.setInt(2, schedual.getAcademicYear()); // Set AcademicYear
            jdbcR.setString(3, schedual.getCodeDeparment()); // Set AcademicYear
            jdbcR.setInt(4, schedual.getStudent_number());
            jdbcR.execute();

            jdbcR.commit();
                return true;
                } catch (java.sql.SQLIntegrityConstraintViolationException e) {
                LTAException ex = new LTAException();
                ex.setExactMessage("Role Name Already Exists!!!");
                throw ex;
                } catch (Exception e) {
                e.printStackTrace();
                }

                return false;
    }


    @Override
    public boolean update_Schedual(SchedualDto schedual) throws LTAException {

        try (JdbcRowSet jdbcR = RowSetProvider.newFactory().createJdbcRowSet()) {
                    jdbcR.setUrl(ConnectionFactory.getUrl());
                    jdbcR.setUsername(ConnectionFactory.getUsername());
                    jdbcR.setPassword(ConnectionFactory.getPassword());
                    jdbcR.setAutoCommit(false);

                    List<SlotDto> slots = schedual.getSchedual_Slots();

            for (int i = 0; i < slots.size(); i++) {
                SlotDto slot = slots.get(i);
                jdbcR.setCommand(Queries.UPDATE_SLOT);

               jdbcR.setString(1, slot.getCurrentCourse().getCode());

                if (slot.getCurrentCourse().getInstructors() != null)
                    jdbcR.setString(2, slot.getCurrentCourse().getInstructors().get(0).getEmail());
                else
                    jdbcR.setNull(2, Types.VARCHAR);


                if (slot.getCurrentCourse().getInstructors().size() > 1)
                    jdbcR.setString(3, slot.getCurrentCourse().getInstructors().get(1).getEmail());
                else
                    jdbcR.setNull(3, Types.VARCHAR);

                jdbcR.setString(4, slot.getType());

                jdbcR.setString(5, slot.getPrefSpace());

                jdbcR.setString(6, schedual.getSCHEDULECODE());
                
                jdbcR.setInt(7, slot.getCode());


                jdbcR.execute();
                
            }

            jdbcR.setCommand(Queries.UPDATE_SCHEDULE);

            jdbcR.setInt(1, schedual.getAcademicYear()); // Set AcademicYear
            jdbcR.setString(2, schedual.getCodeDeparment()); // Set AcademicYear
            jdbcR.setInt(3, schedual.getStudent_number());
            jdbcR.setString(4, schedual.getSCHEDULECODE()); // SetSCHEDULECODE

            jdbcR.execute();
            jdbcR.commit();
                return true;
                } catch (java.sql.SQLIntegrityConstraintViolationException e) {
                LTAException ex = new LTAException();
                ex.setExactMessage("Role Name Already Exists!!!");
                throw ex;
                } catch (Exception e) {
                e.printStackTrace();
                }

                return false;
    }

    @Override
    public List<SchedualDto> listSchedual_inDeparts(String code) {
        List<SchedualDto> scheduals = null;

        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRs.setUrl(ConnectionFactory.getUrl());
            jdbcRs.setUsername(ConnectionFactory.getUsername());
            jdbcRs.setPassword(ConnectionFactory.getPassword());
            
            jdbcRs.setAutoCommit(false);
            jdbcRs.setCommand(Queries.LIST_SCHEDULE_INDEPART);
            jdbcRs.setString(1, code);
            jdbcRs.execute();
           // System.out.println("     code aho"+code); 


            while (jdbcRs.next()) {
                if (scheduals == null)

                scheduals = new ArrayList<>();
                SchedualDto table = new SchedualDto();
                table.setSCHEDULECODE(jdbcRs.getString(1));
                table.setAcademicYear(jdbcRs.getInt(2));
                table.setStudent_number(jdbcRs.getInt(3));
                // table.setId(jdbcRs.getInt(4)); // no id i don't need it
                table.setCodeDeparment(jdbcRs.getString(5));

                // also you need to add the data inserted by , ...... etc

                scheduals.add(table);

            }
            
            if(scheduals == null)
                return Collections.emptyList();
            for(int i=0 ;i<scheduals.size() ; i++)
            {
            
            jdbcRs.setCommand(Queries.LIST_SLOTS);
            jdbcRs.setString(1, scheduals.get(i).getSCHEDULECODE());
            jdbcRs.execute();

            List<SlotDto> slots = new ArrayList<>(); 
            while (jdbcRs.next()) 
            { 
                SlotDto slot = new SlotDto() ;
                
                slot.setSlot_id(jdbcRs.getInt(1));
               
                
                slot.setCode(jdbcRs.getInt(5));
                slot.setType(jdbcRs.getString(6));
                slot.setPrefSpace(jdbcRs.getString(7));
                
                
                slots.add(slot);
            }
                scheduals.get(i).setSchedual_Slots(slots);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return scheduals;

    }

    @Override
    public SchedualDto getSlectedTable(String tableCode) 
    {      List<SlotDto> slots = null , slots2 = null ;
           
        SchedualDto    result  = new SchedualDto() ;

        try (JdbcRowSet jdbcR = RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcR.setUrl(ConnectionFactory.getUrl());
            jdbcR.setUsername(ConnectionFactory.getUsername());
            jdbcR.setPassword(ConnectionFactory.getPassword());
    
            jdbcR.setCommand(Queries.SHOW_SCHEDULE_SLOTS);
            jdbcR.setString(1, tableCode);
            jdbcR.execute();
            
            while(jdbcR.next())
            { 
                if(slots==null)
                    slots = new ArrayList<>() ;

                SlotDto slot = new SlotDto();

                //Set staff name and dgree 
                EmployeeDto staff = new EmployeeDto();
                staff.setCareerDgree(jdbcR.getString(1));
                staff.setFName(jdbcR.getString(2));
                staff.setSName(jdbcR.getString(3));
                slot.setCrrentStaffMemb(staff);
                //set Course name and code
                CourseDto Course = new CourseDto();
                Course.setName(jdbcR.getString(4));
                Course.setCode(jdbcR.getString(5));
                slot.setCurrentCourse(Course);
                //set Location
                LocationDto loc = new LocationDto();
                loc.setCode(jdbcR.getString(6));
                slot.setCurrentLocation(loc);
                //set Slot ID 
                slot.setSlot_id(jdbcR.getInt(7));
                slot.setCode(jdbcR.getInt(8));       
                slots.add(slot);
          }
           
            
            /* slots2 = list_Slots(tableCode);

           System.out.println(slots2.size());
            for(int s=0; s<slots2.size(); s++)
            {
                
                      for(int h=0; h<slots.size(); h++)
                      {   //System.out.println(slots.get(h).getCode()+"\n"); 
                      int s1  = slots.get(h).getCode() ;
                      int s2  =  slots2.get(s).getCode();
                          System.out.println(s1 +"   "+s2);
                          if(s2==s1)
                           {     slots.add( slots2.get(s));
                           System.out.println("in") ; 
                       }
                  }
                
             } */
             
            
            result.setSchedual_Slots(slots);   
            
            
            
            jdbcR.setCommand(Queries.SHOW_SCHEDULE);
            jdbcR.setString(1, tableCode);
            jdbcR.execute();
            while(jdbcR.next())
            {   
                result.setSCHEDULECODE(jdbcR.getString(1));
                result.setAcademicYear(jdbcR.getInt(2));
                result.setStudent_number(jdbcR.getInt(3));
                result.setId(jdbcR.getInt(4));
                
                DepartmentDto dep = new DepartmentDto();
                dep.setCode(jdbcR.getString(5));
                dep.setName(jdbcR.getString(6));
                
                result.setDepartment(dep);
                
            }
            
        
            
        } 
        catch(Exception e)
        {  }
    return result ;}
    
    
    
    List<SlotDto> list_Slots(String code)
    {
        List<SlotDto> nonAsignedresult = null ; 
        try (JdbcRowSet jdbcR = RowSetProvider.newFactory().createJdbcRowSet()) {
                    jdbcR.setUrl(ConnectionFactory.getUrl());
                    jdbcR.setUsername(ConnectionFactory.getUsername());
                    jdbcR.setPassword(ConnectionFactory.getPassword());
                  
        
                    jdbcR.setCommand(Queries.LIST_ALLSLOTS);
                    jdbcR.setString(1, code);
                    jdbcR.execute();

                    while(jdbcR.next())
                    { 
                        if(nonAsignedresult==null)
                            nonAsignedresult = new ArrayList<>() ;

                        SlotDto slot = new SlotDto() ; 
                        //Set staff name and dgree 
                        EmployeeDto staff = new EmployeeDto();
                        staff.setCareerDgree(jdbcR.getString(1));
                        staff.setFName(jdbcR.getString(2));
                        staff.setSName(jdbcR.getString(3));
                        slot.setCrrentStaffMemb(staff);
                        //set Course name and code
                        CourseDto Course = new CourseDto();
                        Course.setName(jdbcR.getString(4));
                        Course.setCode(jdbcR.getString(5));
                        slot.setCurrentCourse(Course);
                        //set Location
                        LocationDto loc = new LocationDto();
                        loc.setCode("not Assigned yet");
                        slot.setCurrentLocation(loc);
                        //set Slot ID 
                        slot.setSlot_id(jdbcR.getInt(6));
                        slot.setCode(jdbcR.getInt(7));       
                        nonAsignedresult.add(slot);
                    
                    

                    }
            
                } catch (java.sql.SQLIntegrityConstraintViolationException e) {
                
                } catch (Exception e) {
                e.printStackTrace();
                }
 
              
     return nonAsignedresult ;    
    }
    
    
    
    
    
    
    }

