/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Community;
import java.util.ArrayList;
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
public class CommunityDAOTest {
    
    public CommunityDAOTest() {
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
     * Test of getAllCommunitys method, of class CommunityDAO.
     */
    @Test
    public void testGetAllCommunitys() {
        System.out.println("getAllCommunitys");
        CommunityDAO instance = null;
        ArrayList<Community> expResult = null;
        ArrayList<Community> result = instance.getAllCommunitys();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCommunityByUser method, of class CommunityDAO.
     */
    @Test
    public void testGetCommunityByUser() {
        System.out.println("getCommunityByUser");
        int user_id = 0;
        CommunityDAO instance = null;
        ArrayList<Community> expResult = null;
        ArrayList<Community> result = instance.getCommunityByUser(user_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCommunityByTitle method, of class CommunityDAO.
     */
    @Test
    public void testGetCommunityByTitle() {
        System.out.println("getCommunityByTitle");
        String title = "";
        CommunityDAO instance = null;
        ArrayList<Community> expResult = null;
        ArrayList<Community> result = instance.getCommunityByTitle(title);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createCommunity method, of class CommunityDAO.
     */
    @Test
    public void testCreateCommunity() {
        System.out.println("createCommunity");
        Community comm = null;
        CommunityDAO instance = null;
        String expResult = "";
        String result = instance.createCommunity(comm);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateCommunity method, of class CommunityDAO.
     */
    @Test
    public void testUpdateCommunity() {
        System.out.println("updateCommunity");
        Community comm = null;
        CommunityDAO instance = null;
        String expResult = "";
        String result = instance.updateCommunity(comm);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
