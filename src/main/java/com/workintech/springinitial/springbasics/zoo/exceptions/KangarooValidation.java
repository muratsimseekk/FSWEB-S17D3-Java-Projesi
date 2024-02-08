package com.workintech.springinitial.springbasics.zoo.exceptions;

import com.workintech.springinitial.springbasics.zoo.entity.Kangaroo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Map;

public class KangarooValidation {

    public static void isIdNotValid(Integer id){
        if (id<0){
            throw  new KangarooException("ID is not valid" , HttpStatus.BAD_REQUEST);
        }
    }
    public static void isKangarooNotExist(Map<Integer , Kangaroo> kangarooMap,Integer id){
        if (!kangarooMap.containsKey(id)){
            throw new KangarooException("Kangaroo with id : " + id + " , is not exist ." ,HttpStatus.NOT_FOUND);
        }
    }
    public  static void isKangarooCredentialValid(Kangaroo kangaroo){
        if (kangaroo == null || kangaroo.getName()== null || kangaroo.getName().isEmpty() ||
        kangaroo.getGender()==null || kangaroo.getGender()==null || kangaroo.getWeight()<20 || kangaroo.getWeight()>150||
                kangaroo.getHeight()<50 || kangaroo.getHeight()>200
        ){
            throw new KangarooException("Kangaroo Credential is not valid" , HttpStatus.BAD_REQUEST);
        }
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<KangarooErrorResponse> handleExceptionKangaroo(Exception exception){

        KangarooErrorResponse kangarooErrorResponse = new KangarooErrorResponse(HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(), LocalDateTime.now()
        );
        return new ResponseEntity<>(kangarooErrorResponse,HttpStatus.BAD_REQUEST);
    }

}
