/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
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
public class DAOTest {
    
    public DAOTest() {
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
     * Test of getConnection method, of class DAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetConnection() throws Exception {
        System.out.println("getConnection");
        DAO instance = null;
        Connection expResult = null;
        Connection result = instance.getConnection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of freeConnection method, of class DAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testFreeConnection() throws Exception {
        System.out.println("freeConnection");
        Connection con = null;
        DAO instance = null;
        instance.freeConnection(con);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
