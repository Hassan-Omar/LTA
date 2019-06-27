package com.fym.lta.dto;


public class SearchDto {
        public SearchDto() {
            }
        
       private String type ; 
       private String search_value;

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }


    public void setSearch_value(String search_value) {
        this.search_value = search_value;
    }

    public String getSearch_value() {
        return search_value;
    }


}


