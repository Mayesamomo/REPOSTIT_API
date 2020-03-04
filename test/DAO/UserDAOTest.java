/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.User;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author micha
 */
public class UserDAOTest {

    public UserDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getUsers method, of class UserDAO. retun an 1 if the user exist .
     * testing get user by user Id.
     */
    @Test

    public void testGetUsers() {
        System.out.println("getUsers");
        int id = 0;
        UserDAO instance = null;
        List<User> expResult = null;
        List<User> result = instance.getUsers(id);
        assertEquals(expResult, result);

    }

    /**
     * Test of getAllUsers method, of class UserDAO. returns an arrayList of all
     * users existed in the database
     */
    @Test
    public void testGetAllUsers() {
        System.out.println("getAllUsers");
        UserDAO instance = null;
        ArrayList<User> expResult = null;
        ArrayList<User> result = instance.getAllUsers();
        assertEquals(expResult, result);

    }

    /**
     * Test of checkIfExist method, of class UserDAO. Test to see if the user is
     * in the Dataase , should it exist, true is retrun , and if it doesn't
     * exist false is return.
     */
    @Test
    public void testCheckIfExist() {
        System.out.println("checkIfExist");
        String username = "";
        String email = "";
        UserDAO instance = null;
        boolean expResult = false;
        boolean result = instance.checkIfExist(username, email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of register method, of class UserDAO.
     */
    @Test
    public void testRegister() {
        System.out.println("register");
        User user = null;
        UserDAO instance = null;
        boolean expResult = false;
        boolean result = instance.register(user);
        assertEquals(expResult, result);

    }

    /**
     * Test of login method, of class UserDAO.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String username = "";
        String password = "";
        UserDAO instance = null;
        boolean expResult = false;
        boolean result = instance.login(username, password);
        assertEquals(expResult, result);

    }

    /**
     * Test of updateCustomer method, of class UserDAO.
     */
    @Test
    public void testUpdateCustomer() {
        System.out.println("updateCustomer");
        User user = null;
        UserDAO instance = null;
        int expResult = 0;
        int result = instance.updateCustomer(user);
        assertEquals(expResult, result);

    }

}
