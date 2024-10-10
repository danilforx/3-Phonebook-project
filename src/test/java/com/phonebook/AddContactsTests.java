package com.phonebook;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AddContactsTests extends TestBase {
    private final String CONTACT_NAME = "TestName";


    @BeforeClass
    public void preCondition() {
        app.getUserHelper().login("forex1@gmail.com", "Password1$");
    }



    @Test(invocationCount = 1, priority = 1)
    public void addContactPositiveTest() {
        app.getContactHelper().addNewContactPositiveData(CONTACT_NAME);
        Assert.assertTrue(app.getContactHelper().isContactAdded(CONTACT_NAME));
    }


    @Test(priority = 5)
    public void addContactPositiveWODescriptionTest() {
        app.getContactHelper().addNewContactPositiveDataWODescription(CONTACT_NAME);
        Assert.assertTrue(app.getContactHelper().isContactAdded(CONTACT_NAME));
    }

    @AfterMethod(enabled = true)
    public void postCondition(){
        app.getContactHelper().deleteOneContact();
    }
}



