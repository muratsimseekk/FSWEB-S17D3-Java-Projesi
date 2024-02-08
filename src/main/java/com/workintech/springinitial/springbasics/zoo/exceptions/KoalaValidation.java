package com.workintech.springinitial.springbasics.zoo.exceptions;

import com.workintech.springinitial.springbasics.zoo.entity.Koala;
import org.springframework.http.HttpStatus;

import java.util.Map;


public class KoalaValidation {


    public static void isKoalaIdNotValid(Integer id){
        if (id<0){
            throw new KoalaException("Id is not valid" , HttpStatus.BAD_REQUEST);
        }
    }
    public static void isKoalaNotExist(Map<Integer, Koala>koalaMap , Integer id){
        if (!koalaMap.containsKey(id)){
            throw new KoalaException("Koala with id : " + id + " , is not exist ." ,HttpStatus.NOT_FOUND);
        }
    }

    public static void isKoalaCredentialValid(Koala koala){
        if(koala==null || koala.getName()==null || koala.getName().isEmpty() || koala.getGender()==null ||
                koala.getSleepHour()<0 || koala.getWeight()<0
        ){
            throw new KoalaException("Koala credintials is not valid" , HttpStatus.BAD_REQUEST);
        }
    }
}
