package com.fym.lta.bao;

import com.fym.lta.dto.DepartmentDto;
import com.fym.lta.dto.EmployeeDto;
import com.fym.lta.dto.LocationDto;
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
      
      
        //In case of employee 
        EmployeeDto employee = new EmployeeDto();
        employee.setFName(value);
        List <EmployeeDto> EmployeeList = new BaoFactory().createemployeeBao().SearchEmployee(employee);
        if(EmployeeList != null){
            
           for(int i = 0; i<EmployeeList.size();i++){ 
             SearchDto searchObject = new SearchDto();
             searchObject.setSearch_value(EmployeeList.get(i).getFName()+ "  " + EmployeeList.get(i).getSName()+ "  " + EmployeeList.get(i).getLName()+"  "+EmployeeList.get(i).getFamilyName());  
             searchObject.setType("Employee");        
             SearchResult.add(searchObject);
                }}
    
      //In case of schedule  
        List <SchedualDto> ScheduleList = new BaoFactory().createSchedualBao().SearchSchedual(value);
        if (ScheduleList != null){
          for(int i = 0; i<ScheduleList.size();i++){  
                        SearchDto searchObject = new SearchDto();
             searchObject.setSearch_value(ScheduleList.get(i).getSCHEDULECODE());  
             searchObject.setType("Schedule");        
             SearchResult.add(searchObject);
                    }}
   
        //In case of department 
        DepartmentDto department = new DepartmentDto();
        department.setCode(value);
        List <DepartmentDto> DepartmentList = new BaoFactory().createDepartmentBao().SearchDepartment(department);          
        if(DepartmentList != null){
          for(int i = 0; i<DepartmentList.size();i++){
                                SearchDto searchObject = new SearchDto();
             searchObject.setSearch_value(DepartmentList.get(i).getName());  
             searchObject.setType("Department");        
             SearchResult.add(searchObject);
                            }} 
        
               //In case of department 
                  
               department.setCode(value);
               List <LocationDto> locList = new BaoFactory().createLocationBao().searchLocation(value);          
               if(locList != null){
                 for(int i = 0; i<locList.size();i++){
                    SearchDto searchObject = new SearchDto();
                    searchObject.setSearch_value(locList.get(i).getCode());  
                    searchObject.setType("Location");        
                    SearchResult.add(searchObject);
                                   }} 
               
               
           return SearchResult;
          
           }
            
        }
        
    

    

