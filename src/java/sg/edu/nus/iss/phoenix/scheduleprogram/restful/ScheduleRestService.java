/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.scheduleprogram.restful;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Timestamp;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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

    private String datePattern = "yyyy-MM-dd HH:mm:ss";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

    private String timePattern = "HH:mm:ss";
    private SimpleDateFormat timeFormatter = new SimpleDateFormat(timePattern);

    public ScheduleRestService() {
        scheduleService = new ScheduleService();
    }

    @PUT
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean createSchedule(ProgramSlot programSlot) {

        long sum = programSlot.getStartTime().getTime() + programSlot.getDuration().getTime();
        programSlot.setEndTime(new Timestamp(sum));
        boolean isCreated = scheduleService.processCreate(programSlot);
        return isCreated;
    }

    @DELETE
    @Path("/delete/{dateOfPgm}/startTime/{startTime}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteScheduleProgram(@PathParam("dateOfPgm") String dateOfPgm, @PathParam("startTime") String startTime) {
        java.sql.Timestamp pgDate = null;
        java.sql.Timestamp pgStartTime = null;
        try {

            String dateInString = URLDecoder.decode(dateOfPgm, "UTF-8");
            Date date = dateFormatter.parse(dateInString);
            pgDate = new Timestamp(date.getTime());

            String timeInString = URLDecoder.decode(startTime, "UTF-8");
            Date time = dateFormatter.parse(timeInString);
            pgStartTime = new Timestamp(time.getTime());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return;
        } catch (ParseException ex) {
            Logger.getLogger(ScheduleRestService.class.getName()).log(Level.SEVERE, null, ex);
        }

        scheduleService.processDelete(pgDate, pgStartTime);
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
