/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassTest;

import DTO.User;
import REST.UserResource;
import java.util.List;
import java.util.Scanner;
import javax.ws.rs.core.Response;
import org.json.simple.parser.ParseException;

/**
 *
 * @author micha
 */
public class test {
    public static void main(String[] args) throws ParseException{
          UserResource rs = new UserResource();
       Scanner sc = new Scanner(System.in) ;
       User us = new User();
        boolean s = sc.equals(us);
//       Response na =rs.Login(s);
//        System.out.println(na);
        //Response na =rs.getUserById(16);
       boolean na = rs.registerUser(s);
        System.out.println(na);
    } 
}
//{"user_name":"Anime","password":"password"}