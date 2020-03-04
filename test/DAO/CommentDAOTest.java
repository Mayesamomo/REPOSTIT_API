/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Comment;
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
public class CommentDAOTest {
    
    public CommentDAOTest() {
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
     * Test of getUserComments method, of class CommentDAO.
     */
    @Test
    public void testGetUserComments() {
        System.out.println("getUserComments");
        int user_id = 0;
        CommentDAO instance = null;
        List<Comment> expResult = null;
        List<Comment> result = instance.getUserComments(user_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPostComments method, of class CommentDAO.
     */
    @Test
    public void testGetPostComments() {
        System.out.println("getPostComments");
        int post_id = 0;
        CommentDAO instance = null;
        List<Comment> expResult = null;
        List<Comment> result = instance.getPostComments(post_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllComments method, of class CommentDAO.
     */
    @Test
    public void testGetAllComments() {
        System.out.println("getAllComments");
        CommentDAO instance = null;
        List<Comment> expResult = null;
        List<Comment> result = instance.getAllComments();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of MakeComment method, of class CommentDAO.
     */
    @Test
    public void testMakeComment() {
        System.out.println("MakeComment");
        Comment comments = null;
        CommentDAO instance = null;
        boolean expResult = false;
        boolean result = instance.MakeComment(comments);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of countComments method, of class CommentDAO.
     */
    @Test
    public void testCountComments() {
        System.out.println("countComments");
        CommentDAO instance = null;
        int expResult = 0;
        int result = instance.countComments();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class CommentDAO.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        CommentDAO.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
