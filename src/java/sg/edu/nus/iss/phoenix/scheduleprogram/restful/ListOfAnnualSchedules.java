/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.scheduleprogram.restful;

import java.util.List;
import sg.edu.nus.iss.phoenix.scheduleprogram.entity.AnnualSchedule;

/**
 *
 * @author sharanya
 */
public class ListOfAnnualSchedules {
    
    private List<AnnualSchedule> annualSchedules;

    public List<AnnualSchedule> getAnnualSchedules() {
        return annualSchedules;
    }

    public ListOfAnnualSchedules(List<AnnualSchedule> annualSchedules) {
        this.annualSchedules = annualSchedules;
    }

    public void setAnnualSchedules(List<AnnualSchedule> annualSchedules) {
        this.annualSchedules = annualSchedules;
    }
    
}
