/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.scheduleprogram.restful;

import java.util.ArrayList;
import java.util.Objects;
import sg.edu.nus.iss.phoenix.scheduleprogram.entity.ProgramSlot;

/**
 *
 * @author shara
 */
public class ProgramSlots {

    private ArrayList<ProgramSlot> pgSlots;

    public ArrayList<ProgramSlot> getPgSlots() {
        return pgSlots;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.pgSlots);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProgramSlots other = (ProgramSlots) obj;
        return true;
    }

    public void setPgSlots(ArrayList<ProgramSlot> pgSlots) {
        this.pgSlots = pgSlots;
    }

}
