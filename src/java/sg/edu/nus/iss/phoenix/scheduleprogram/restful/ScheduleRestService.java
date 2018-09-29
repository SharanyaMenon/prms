/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.scheduleprogram.restful;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;

import sg.edu.nus.iss.phoenix.scheduleprogam.service.ScheduleService;
import sg.edu.nus.iss.phoenix.scheduleprogram.entity.ProgramSlot;

/**
 *
 * @author sharanya
 */
@Path("scheduleprogram")
public class ScheduleRestService {

    private ScheduleService scheduleService;

    public ScheduleRestService() {
        scheduleService = new ScheduleService();
    }

    /**
     *
     * PUT method to createSchedule
     *
     * @param programSlot
     * @return
     */
    @PUT
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean createSchedule(ProgramSlot programSlot) {
        
        boolean isCreated = scheduleService.processCreate(programSlot);
        return isCreated;
    }

//    @PUT
//    @Path("/createAnnualSchedule/year/{year}/userName/{userName}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public boolean createAnnualSchedule(int year, String userName) {
////        scheduleService.
//        
//        boolean isCreated = scheduleService.processCreate(programSlot); 
//        return isCreated;
//    }
    /**
     * Delete method to delete Schedule Program
     *
     * @param dateOfPgm
     * @param startTime
     */
    @DELETE
    @Path("/delete/dateOfPgm/{dateOfPgm}/startTime/{startTime}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteScheduleProgram(@PathParam("dateOfPgm") Date dateOfPgm, @PathParam("startTime") Time startTime) {
        scheduleService.processDelete(dateOfPgm, startTime);
    }

    /**
     * POST method to update Program Slot
     *
     * @param programSlot
     */
    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateProgramSlot(ProgramSlot programSlot) {
        scheduleService.processModify(programSlot);
    }

    /**
     * GET method to get all Program Slot
     *
     * @return
     */
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public ProgramSlots getAllProgramSlot() {
        ArrayList<ProgramSlot> pgSlotList = scheduleService.findAllProgramSlot();
        ProgramSlots programSlots = new ProgramSlots();

        programSlots.setPgSlots(new ArrayList<ProgramSlot>());

        for (int i = 0; i < pgSlotList.size(); i++) {
            ProgramSlot pgSlot = pgSlotList.get(i);
            ProgramSlot programSlot = new ProgramSlot(pgSlot.getName(), pgSlot.getDuration(), pgSlot.getDate(), pgSlot.getStartTime(), pgSlot.getPresenter(), pgSlot.getProducer());
            programSlots.getPgSlots().add(programSlot);
        }
        return programSlots;
    }
}
