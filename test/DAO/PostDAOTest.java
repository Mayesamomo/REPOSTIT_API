/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Post;
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
public class PostDAOTest {
    
    public PostDAOTest() {
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
     * Test of getAllPosts method, of class PostDAO.
     */
    @Test
    public void testGetAllPosts() {
        System.out.println("getAllPosts");
        PostDAO instance = null;
        ArrayList<Post> expResult = null;
        ArrayList<Post> result = instance.getAllPosts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllActivePosts method, of class PostDAO.
     */
    @Test
    public void testGetAllActivePosts() {
        System.out.println("getAllActivePosts");
        PostDAO instance = null;
        ArrayList<Post> expResult = null;
        ArrayList<Post> result = instance.getAllActivePosts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPostByUser method, of class PostDAO.
     */
    @Test
    public void testGetPostByUser() {
        System.out.println("getPostByUser");
        int user = 0;
        PostDAO instance = null;
        ArrayList<Post> expResult = null;
        ArrayList<Post> result = instance.getPostByUser(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPostsByCommunity method, of class PostDAO.
     */
    @Test
    public void testGetPostsByCommunity() {
        System.out.println("getPostsByCommunity");
        int community = 0;
        PostDAO instance = null;
        ArrayList<Post> expResult = null;
        ArrayList<Post> result = instance.getPostsByCommunity(community);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPostByTitle method, of class PostDAO.
     */
    @Test
    public void testGetPostByTitle() {
        System.out.println("getPostByTitle");
        String title = "";
        PostDAO instance = null;
        ArrayList<Post> expResult = null;
        ArrayList<Post> result = instance.getPostByTitle(title);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPostById method, of class PostDAO.
     */
    @Test
    public void testGetPostById() {
        System.out.println("getPostById");
        int id = 0;
        PostDAO instance = null;
        ArrayList<Post> expResult = null;
        ArrayList<Post> result = instance.getPostById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPostText method, of class PostDAO.
     */
    @Test
    public void testAddPostText() {
        System.out.println("addPostText");
        Post p = null;
        PostDAO instance = null;
        String expResult = "";
        String result = instance.addPostText(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPostFile method, of class PostDAO.
     */
    @Test
    public void testAddPostFile() {
        System.out.println("addPostFile");
        Post p = null;
        PostDAO instance = null;
        String expResult = "";
        String result = instance.addPostFile(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
