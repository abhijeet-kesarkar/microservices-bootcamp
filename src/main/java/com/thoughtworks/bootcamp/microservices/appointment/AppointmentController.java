package com.thoughtworks.bootcamp.microservices.appointment;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * Created by abhijeek on 12/02/17.
 */
@RestController
@RequestMapping(value = "/doctors/{doctorId}/slots/{slotId}/appointment")
@Api("Appointment api")
public class AppointmentController {

    @ApiOperation(httpMethod = "PUT", value = "Book Appointment")
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Appointment> bookAppointment(
            @PathVariable("doctorId") String doctorId,
            @PathVariable("slotId") String slotId,
            @RequestBody Patient patient,
            UriComponentsBuilder b){

        Appointment appointment = Appointment.builder()
                .patient(patient)
                .slot(getSlot(slotId, doctorId))
                .build()
                .book();

        return ResponseEntity.created(b.buildAndExpand("/doctors/{doctorId}/slots/{slotId}/appointment", doctorId, slotId).toUri()).body(appointment);

    }

    private Slot getSlot(String slotId, String doctorId) {
        return Slot.builder()
                .id(slotId)
                .doctor(doctorId)
                .start("1200")
                .end("1300")
                .build();
    }
}
