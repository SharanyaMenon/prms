/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.scheduleprogram.restful;

/**
 *
 * @author Meow
 */

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.scheduleprogam.service.ReviewSelectPresenterProducerService;

@Path("retrieveProducer")
public class ReviewSelectProducerRestService {
    //one function to get all the details from the user tabale based on their roles i.e presenter
    //it will reuse the User Entity object

    private ReviewSelectPresenterProducerService service;

    public ReviewSelectProducerRestService() {
        service = new ReviewSelectPresenterProducerService();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Users getProducer() {
        ArrayList<User> userList = service.loadUserBasedOnRole("producer");
        Users users = new Users();
        users.setuserList(new ArrayList<User>());

        for (int i = 0; i < users.getuserList().size(); i++) {
            users.getuserList().add(
                    new User(userList.get(i).getName()));
        }
        return users;
    }
}
