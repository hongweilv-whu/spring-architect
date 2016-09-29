package com.whu.hong.service;

import org.springframework.stereotype.Service;

/**
 * Description:
 * Created by lvhw on 2016/9/29 7:13.
 */
@Service
public class PersonService {

    public void addPerson(String personName) {
        System.out.println("add person " + personName);
        System.out.println("add person finished!");
    }

    public boolean deletePerson(String personName) {
        System.out.println("delete person " + personName) ;
        System.out.println("delete person finished!");
        return true;
    }

    public void editPerson(String personName) {
        System.out.println("edit person " + personName);
        throw new RuntimeException("edit person throw exception");
    }
}