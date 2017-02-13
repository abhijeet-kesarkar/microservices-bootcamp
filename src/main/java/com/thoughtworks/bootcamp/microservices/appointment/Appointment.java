package com.thoughtworks.bootcamp.microservices.appointment;

import lombok.Builder;
import lombok.Data;

/**
 * Created by abhijeek on 12/02/17.
 */

@Data
@Builder
public class Appointment {

    private Slot slot;
    private Patient patient;

    public Appointment book() {
        System.out.println("Appointment Booked");
        if( this.patient.getFirstname().startsWith("a")){
            throw new AppointmentNotAvailableException();
        }
        return this;
    }
}
