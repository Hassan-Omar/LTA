package com.fym.lta.bao;

import com.fym.lta.dto.DepartmentDto;
import com.fym.lta.dto.EmployeeDto;
import com.fym.lta.dto.SchedualDto;
import com.fym.lta.dto.SearchDto;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    public SearchEngine() {
        super();
    }
    
  
    public static  List<SearchDto> SearchList(String value){
        List<SearchDto> SearchResult = new ArrayList<>();
        SearchDto searchObject = new SearchDto();
      
        //In case of employee 
        EmployeeDto employee = new EmployeeDto();
        employee.setFName(value);
        List <EmployeeDto> EmployeeList = new BaoFactory().createemployeeBao().SearchEmployee(employee);
        if(EmployeeList != null){
           for(int i = 0; i<EmployeeList.size();i++){     
             searchObject.setSearch_value(EmployeeList.get(i).getFName()+ "\t" + EmployeeList.get(i).getSName()+ "\t" + EmployeeList.get(i).getLName()+"\t"+EmployeeList.get(i).getFamilyName());  
             searchObject.setType("Employee");        
             SearchResult.add(searchObject);
                }}
        else{
     
      //In case of schedule  
        List <SchedualDto> ScheduleList = new BaoFactory().createSchedualBao().SearchSchedual(value);
        if (ScheduleList != null){
          for(int i = 0; i<ScheduleList.size();i++){     
             searchObject.setSearch_value(ScheduleList.get(i).getSCHEDULECODE());  
             searchObject.setType("Schedule");        
             SearchResult.add(searchObject);
                    }}
        else{ 
        
       //In case of department 
        DepartmentDto department = new DepartmentDto();
        department.setCode(value);
        List <DepartmentDto> DepartmentList = new BaoFactory().createDepartmentBao().SearchDepartment(department);          
        if(DepartmentList != null){
          for(int i = 0; i<DepartmentList.size();i++){     
             searchObject.setSearch_value(DepartmentList.get(i).getName());  
             searchObject.setType("Department");        
             SearchResult.add(searchObject);
                            }} } }
           return SearchResult;
          
           }
            
        }
        
    

    

