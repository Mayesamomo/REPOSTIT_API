/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import DAO.UserDAO;
import DAO.Userinterface;
import DTO.User;
import DTO.UserType;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * REST Web Service
 *
 * @author micha
 */
@Path("User")
public class UserResource {

    @Context
    private UriInfo context;
//Declaring all global vars for the user res

    private final Userinterface db = new UserDAO("repostit");
    private User u = new User();
    //private final String USERNAME_FORMAT = "[A-Z]+[a-zA-Z]";
    private final String EMAIL_FORMAT = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private final String PASSWORD_FORMAT = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})";
    //private final String PASSWORD_FORMAT = "";
    public final int SUCCESS = 1;
    public final int FAILURE = 0;
    public final int INVALID_INPUT = 0;

    /**
     * Creates a new instance of UserResource
     */
    public UserResource() {
    }

    private JSONObject convertUserToJson(User u) {
        JSONObject jObj = new JSONObject();
        jObj.put("user_id", u.getId());
        jObj.put("fullName", u.getFullName());
        jObj.put("user_name", u.getUsername());
        jObj.put("email", u.getEmail());
        jObj.put("password", u.getPassword());
        // jObj.put("user_type", u.getUsertype());
        //jObj.put("user_status", u.getStatus());
        //jObj.put("date", u.getDate());
        return jObj;
    }

    private User convertJsonStringToUser(String jsonString) throws org.json.simple.parser.ParseException {
        //User u = null ;
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(jsonString);
        //int user_id = ((Long) obj.get("user_id")).intValue();
        //u.setId(user_id);
        u.setFullName((String) obj.get("fullName"));
        u.setUsername((String) obj.get("user_name"));
        u.setPassword((String) obj.get("password")); //password must not be return 
        u.setEmail((String) obj.get("email"));
        String usertype = ((Long) obj.get("user_type")).toString();
        u.setUserType(UserType.valueOf(usertype));
       // int status = ((Long) obj.get("user_status")).intValue();
        //u.setStatus(status);
        return u;
    }

    /**
     * Retrieves representation of an instance of REST.UserResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/AllUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        ArrayList<User> users = db.getAllUsers();
        if (users == null || users.isEmpty()) {
            return "No results found";
        } else {
            JSONArray array = new JSONArray();
            users.stream().filter((use) -> (use.getStatus() == 1)).forEachOrdered((use) -> {
                array.add(convertUserToJson(use));
            }); //confirms if the user is activated.
            return array.toString();
        }

    }

    /**
     * PUT method for updating or creating an instance of UserResource
     *
     * @param content representation for the resource
     * @return
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean putJson(String content) {
        boolean flag;
        try {
            u = convertJsonStringToUser(content);
            int isUpdated = db.updateCustomer(u);
            if (isUpdated == 1) {
                flag = true;
                return flag;
            } else {
                flag = false;
                return flag;
            }
        } catch (ParseException ex) {
            Logger.getLogger(UserResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    //Login Method
    @POST
    @Path("/Login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean Login(String content) throws org.json.simple.parser.ParseException {
        u = convertJsonStringToUser(content);
        boolean exist;
        exist = db.checkIfExist(u.getUsername(), u.getPassword());
        if (exist == true) {
            if (u.getUsername() != null && u.getPassword() != null) {
                boolean res = db.login(u.getUsername(), u.getPassword());
                if (res) {
                    return res;
                }

            }
            return false;
        }
        return false;
    }
    //

    @POST
    @Path("/Register")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean registerUser(String a) throws ParseException {
        u = convertJsonStringToUser(a);
        boolean exist;
        exist = db.checkIfExist(u.getUsername(), u.getPassword());
        if (exist != true) {
            if (u.getFullName() != null && u.getUsername() != null && u.getPassword() != null && u.getPassword().matches(PASSWORD_FORMAT) && u.getEmail() != null && u.getEmail().matches(EMAIL_FORMAT)) {
                boolean res = db.register(u);
                return res;
            } else {
                return false;
            }
        }
        return false;
    }

}
