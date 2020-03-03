/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassTesting;

import REST.UserResource;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;

/**
 *
 * @author micha
 */
public class Main {
    public static void main(String[] args){
         UserResource rs = new UserResource();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Boolean na = null;
        try {
            na = rs.Login(s);
        } catch (ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(na);
    }
}
