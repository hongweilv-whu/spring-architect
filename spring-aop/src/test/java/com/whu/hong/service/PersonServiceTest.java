package com.whu.hong.service;

import com.whu.hong.BaseJunit;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Description:
 * Created by lvhw on 2016/9/29 7:26.
 */
public class PersonServiceTest extends BaseJunit {
    @Autowired
    private PersonService personService;

    @Test
    public void testAddPerson() throws Exception {
        personService.addPerson("lisi");
        System.out.println("test addPerson");
    }

    @Test
    public void testDeletePerson() throws Exception {
        personService.deletePerson("lisi");
        System.out.println("test deletePerson");
    }

    @Test
    public void testEditPerson() throws Exception {

    }
}