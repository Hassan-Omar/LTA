package com.fym.lta.dto;

import java.util.List;

public class SchedualDto
{
    private int student_number ,academicYear , id;
    private String SCHEDULECODE, Description, CodeDeparment;
    private List<SlotDto> Schedual_Slots;
    private DepartmentDto department ;


    public SchedualDto(int student_number, String SCHEDULECODE, String Description,
                       int academicYear, List<SlotDto> Schedual_Slots) {
        super();
        this.student_number = student_number;
        this.SCHEDULECODE = SCHEDULECODE;
        this.Description = Description;
        this.academicYear = academicYear;
        this.Schedual_Slots = Schedual_Slots;
    }

    public void setCodeDeparment(String CodeDeparment) {
        this.CodeDeparment = CodeDeparment;
    }

    public String getCodeDeparment() {
        return CodeDeparment;
    }

    public SchedualDto() {
    }

    public void setStudent_number(int student_number) {
        this.student_number = student_number;
    }

    public int getStudent_number() {
        return student_number;
    }

    public void setSCHEDULECODE(String SCHEDULECODE) {
        this.SCHEDULECODE = SCHEDULECODE;
    }

    public String getSCHEDULECODE() {
        return SCHEDULECODE;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(DepartmentDto department) {
        this.department = department;
    }

    public DepartmentDto getDepartment() {
        return department;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getDescription() {
        return Description;
    }


    public void setAcademicYear(int academicYear) {
        this.academicYear = academicYear;
    }

    public int getAcademicYear() {
        return academicYear;
    }

    public void setSchedual_Slots(List<SlotDto> Schedual_Slots) {
        this.Schedual_Slots = Schedual_Slots;
    }

    public List<SlotDto> getSchedual_Slots() {
        return Schedual_Slots;
    }
}
