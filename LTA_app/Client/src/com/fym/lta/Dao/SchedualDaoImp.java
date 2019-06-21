package com.fym.lta.dao;

import com.fym.lta.common.ConnectionFactory;
import com.fym.lta.common.LTAException;
import com.fym.lta.common.Queries;
import com.fym.lta.dto.SchedualDto;
import com.fym.lta.dto.SlotDto;

import java.sql.Types;

import java.util.ArrayList;
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
                jdbcR.setInt(5, slot.getCode());


                jdbcR.setString(6, slot.getPrefSpace());

                jdbcR.setString(7, schedual.getSCHEDULECODE());


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
    public SchedualDto getSlectedTable(String tableCode) {
        
        // ABDO YOU SHOULD WRITE THIS 
        
        return null;
    }
}
