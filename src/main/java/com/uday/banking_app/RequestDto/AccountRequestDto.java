package com.uday.banking_app.RequestDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public record AccountRequestDto (int id,String name,double balance){

}
