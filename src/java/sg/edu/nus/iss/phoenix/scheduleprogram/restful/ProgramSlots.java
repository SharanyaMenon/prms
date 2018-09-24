/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.scheduleprogram.restful;

import java.util.List;
import sg.edu.nus.iss.phoenix.scheduleprogram.entity.ProgramSlot;

/**
 *
 * @author shara
 */
public class ProgramSlots {

    private List<ProgramSlot> pgSlots;

    public List<ProgramSlot> getPgSlots() {
        return pgSlots;
    }

    public void setPgSlots(List<ProgramSlot> pgSlots) {
        this.pgSlots = pgSlots;
    }

}
