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
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    //private UserResource DataService =;

    @Context
    private UriInfo context;
//Declaring all global vars for the user res

    // private final Userinterface db = new UserDAO("repostit");
    private final Userinterface db = UserDAO.getInstance();
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
        jObj.put("user_type", u.getUserType());
        jObj.put("user_status", u.getStatus());
        jObj.put("date", u.getDate());
        return jObj;
    }

    private User convertJsonStringToLogin(String log) throws org.json.simple.parser.ParseException {
        User users = null;
        try {

            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject) parser.parse(log);
            //creating a new user object and passing data into them.
            users = new User();
            users.setUsername((String) obj.get("user_name"));
            users.setPassword((String) obj.get("password")); //password must not be return

            return u;
        } catch (ParseException ex) {
            Logger.getLogger(UserResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private User convertJsonStringToUser(String jsonString) {
        User users = null;
        try {
            users = new User();
            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject) parser.parse(jsonString);
            //creating a new user object and passing data into them.
            //int userId = ((int) obj.get("user_id"));
            //users.setId(userId);
            users.setFullName((String) obj.get("fullName"));
            users.setUsername((String) obj.get("user_name"));
            users.setPassword((String) obj.get("password")); //password must not be return
            users.setEmail((String) obj.get("email"));
            // String usertype = (String) (obj.get("user_type"));
            //users.setUserType(UserType.valueOf(usertype));

            //int status = ((Long) obj.get("user_status")).intValue();
            // u.setStatus(status);
            return u;
        } catch (ParseException ex) {
            Logger.getLogger(UserResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Retrieves representation of an instance of REST.UserResource
     *
     * @return an instance of java.lang.String
     */
    @RolesAllowed("ADMIN")
    @GET
    @Path("/AllUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers() {
        ArrayList<User> users = db.getAllUsers();
        //if (users == null || users.isEmpty()) {
        //return "No results found";
        return db.getAllUsers();
        // } else {
        //JSONArray array = new JSONArray();
        //users.stream().filter((use) -> (use.getStatus() == 1)).forEachOrdered((use) -> {
        //array.add(convertUserToJson(use));
        // }); //confirms if the user is activated.
        // return array.toString();
        //return db.getAllUsers();
        // }

    }

    //get a details with username
    @GET
    @Path("{Id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("Id") int id) {
        List<User> users = db.getUsers(id);
        if (users == null || users.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .build();
        } else {
            return Response.ok()
                    .entity(users)
                    .build();
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
        u = convertJsonStringToUser(content);
        int isUpdated = db.updateCustomer(u);
        if (isUpdated == 1) {
            flag = true;
            return flag;
        } else {
            flag = false;
            return flag;
        }

    }

    //Login Method
    @POST
    @Path("/Login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    // @Produces(MediaType.TEXT_PLAIN)
    public Response Login(User us) throws org.json.simple.parser.ParseException {
        //u = convertJsonStringToLogin(content);
        try{
        boolean login = db.login(us.getUsername(), us.getPassword());
        if (us.getUsername() == null && us.getPassword() == null) {
            return Response.status(400).entity("Please enter username and password !!").build();

        }
        if(!login){
            return Response.status(401).entity("wrong username or password !!").build();
        }
            boolean login1 = login;
        return Response.status(200).entity("Logged In!").build();
        }
        catch(Exception e){
               System.out.println(e);
        }
        return null;
     
    }

//    @POST
//    @Path("/Register")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    //@Produces(MediaType.TEXT_PLAIN)
//    public String registerUser(String a) throws ParseException {
//        u = convertJsonStringToUser(a);
//        boolean exist;
//        exist = db.checkIfExist(u.getUsername(), u.getPassword());
//        if (exist) {
//            if (u.getFullName() != null && u.getUsername() != null && u.getEmail() != null && u.getPassword() != null) {
//                return db.register(u);
//            }
//        }
//        return null;
//
//    }
    @POST
    @Path("/Register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.TEXT_PLAIN)
    public Response registerUser(User us) throws ParseException, URISyntaxException {
        boolean exist = db.checkIfExist(us.getUsername(), us.getEmail());
        if (us.getFullName() == null && us.getUsername() == null && us.getEmail() == null && us.getPassword() == null) {
            return Response.status(400).entity("Please provide all your details !!").build();
        }
        if (exist) {
            return Response.status(400).entity("account already !").build();
        }
        db.register(us);
        return Response.status(200).entity("account created").build();

    }
}
