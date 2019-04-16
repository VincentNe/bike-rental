package com.csharp.bikerental.model;

import com.csharp.bikerental.persistence.model.UserEdit;
import com.csharp.bikerental.persistence.model.UserEditCaretaker;
import com.csharp.bikerental.persistence.model.UserEditSaver;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserFormSaverTest {

    @Test
    public  void testSaver()throws Exception{
        UserEdit userForm = new UserEdit(666,"Jim Leahy", "085235122","675444");

        UserEditSaver saver = userForm.Saveto();
        UserEditCaretaker userFormCaretaker = new UserEditCaretaker();
        userFormCaretaker.addSaver(saver);
        userFormCaretaker.toString();
        System.out.println("orginal");
        userForm.printInfo();


        userForm.setUserPhoneNo("1234556");
        saver = userForm.Saveto();
        userFormCaretaker.addSaver(saver);
        userForm.toString();
        System.out.println("\nphone update");
        userForm.printInfo();
        assertEquals("1234556",userForm.getUserPhoneNo());
        assertTrue(userForm.toString(),true);

        userForm.setNFCID("6666666");
        saver =userForm.Saveto();
        userFormCaretaker.addSaver(saver);
        userForm.toString();
        System.out.println("\nNFCID update");
        userForm.printInfo();
        assertEquals("6666666",userForm.getNFCID());
        assertTrue(userForm.toString(),true);


        saver=userFormCaretaker.getSaver();
        userForm.undoSave(saver);
        saver=userFormCaretaker.getSaver();
        userForm.undoSave(saver);
        userForm.toString();
        System.out.println("\nundo NFCID");
        userForm.printInfo();
        assertTrue(userForm.toString(),true);

        saver=userFormCaretaker.getSaver();
        userForm.undoSave(saver);
        userForm.toString();
        System.out.println("\noriginal again");
        userForm.printInfo();
        assertTrue(userForm.toString(),true);

    }
}
