package com.fym.lta.dto;

import java.util.List;

public class EmployeeDto extends UserDto
{
    public void setLName(String lName) {
        this.lName = lName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getFullName() {
        return FullName;
    }

    public String getLName() {
        return lName;
    }
    private int emp_id ;
    private boolean empType ; // this true if the type is a staff member 
    private String fName, sName, lName, familyName, email,careerDgree,FullName;
    private List<CourseDto> teachingCoursese ;
    


    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmpType(boolean empType) {
        this.empType = empType;
    }

    public boolean isEmpType() {
        return empType;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getFName() {
        return fName;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }

    public String getSName() {
        return sName;
    }



    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setCareerDgree(String careerDgree) {
        this.careerDgree = careerDgree;
    }

    public String getCareerDgree() {
        return careerDgree;
    }

    public void setTeachingCoursese(List<CourseDto> teachingCoursese) {
        this.teachingCoursese = teachingCoursese;
    }

    public List<CourseDto> getTeachingCoursese() {
        return teachingCoursese;
    }
}