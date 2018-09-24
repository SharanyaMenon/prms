/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.scheduleprogram.restful;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import sg.edu.nus.iss.phoenix.scheduleprogam.service.ScheduleService;
import sg.edu.nus.iss.phoenix.scheduleprogram.entity.ProgramSlot;

/**
 *
 * @author shara
 */
@Path("scheduleprogram")
public class ScheduleRestService {

    @Context
    private UriInfo context;

    private ScheduleService scheduleService;

    public ScheduleRestService() {
        scheduleService = new ScheduleService();
    }

    @PUT
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createSchedule(ProgramSlot programSlot) {
        scheduleService.processCreate(programSlot);
    }

    @DELETE
    @Path("/delete/{scheduleProgramName}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteScheduleProgram(@PathParam("scheduleProgramName") String pgName) {
        String name;
        try {
            name = URLDecoder.decode(pgName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return;
        }

        scheduleService.processDelete(name);
    }

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateProgramSlot(ProgramSlot programSlot) {
        scheduleService.processModify(programSlot);
    }

    @PUT
    @Path("/copy")
    @Consumes(MediaType.APPLICATION_JSON)
    public void copyProgramSlot(ProgramSlot programSlot) {
//        scheduleService.processCreate(programSlot);
    }

//    @GET
//    @Path("/all")
//    @Produces(MediaType.APPLICATION_JSON)
//    public ProgramSlots getAllRadioPrograms() {
//        ArrayList<ProgramSlot> pgSlotList = scheduleService.findAllProgramSlot();
//        ProgramSlots programSlots = new ProgramSlots();
//
//        programSlots.setPgSlots(new ArrayList<ProgramSlot>());
//
//        for (int i = 0; i < pgSlotList.size(); i++) {
//            programSlots.getPgSlots().add(
//                    new ProgramSlot(pgSlotList.get(i).getName(),
//                            pgSlotList.get(i).getId(),
//                            pgSlotList.get(i).getTypicalDuration(),
//                            pgSlotList.get(i).getDate(),
//                            pgSlotList.get(i).getStartTime()));
//        }
//
//        return programSlots;
//    }

}
