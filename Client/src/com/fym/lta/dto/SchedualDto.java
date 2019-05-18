package com.fym.lta.dto;

import java.util.List;

public class SchedualDto
{
    private int student_number;
    private String SCHEDULECODE, Description, CodeDeparment,academicYear;
    private List<SlotDto> Schedual_Slots;
    public SchedualDto(int student_number, String SCHEDULECODE, String Description,
                       String academicYear, List<SlotDto> Schedual_Slots) {
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

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getDescription() {
        return Description;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setSchedual_Slots(List<SlotDto> Schedual_Slots) {
        this.Schedual_Slots = Schedual_Slots;
    }

    public List<SlotDto> getSchedual_Slots() {
        return Schedual_Slots;
    }
}
