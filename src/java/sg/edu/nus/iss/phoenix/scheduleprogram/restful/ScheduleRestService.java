/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.scheduleprogram.restful;

import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import sg.edu.nus.iss.phoenix.scheduleprogam.service.ScheduleService;

/**
 *
 * @author shara
 */
@Path("scheduleprogram")
public class ScheduleRestService {
    
    @Context
    private UriInfo context;
    
    private ScheduleService scheduleService;
    
    public ScheduleRestService(){
        scheduleService = new ScheduleService();
    }
    
    
    
    
    
    
}
