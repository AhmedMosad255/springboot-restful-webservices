package net.javaguide.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecourseNotFoundException extends RuntimeException{
    private String recourseName;
    private String fieldName;
    private Long fieldValue;
    public RecourseNotFoundException(String recourseName,String fieldName,Long fieldValue){
        super(String.format("%s not found with %s : '%s'",recourseName, fieldName, fieldValue));
        this.recourseName = recourseName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
