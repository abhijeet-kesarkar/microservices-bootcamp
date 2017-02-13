package com.thoughtworks.bootcamp.microservices.appointment;

import com.thoughtworks.bootcamp.microservices.appointment.Slot;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhijeek on 12/02/17.
 */
@RestController
@RequestMapping(value = "/doctors/{doctorId}/slots")
public class SlotController {


    @RequestMapping(method = RequestMethod.GET)
    public List<Slot> findSlot(@PathVariable("doctorId") String doctor, @RequestParam( value = "date", required = false) String date){

        System.out.println("doctor = [" + doctor + "], date = [" + date + "]");
        return getSlots(doctor);

    }



    private List<Slot> getSlots(String doctor) {

        List<Slot> slots = new ArrayList<>();
        slots.add(Slot.builder()
                .id("1234")
                .doctor(doctor)
                .start("1200")
                .end("1300")
                .build());
        slots.add(Slot.builder()
                .id("2324")
                .doctor(doctor)
                .start("1500")
                .end("1600")
                .build());
        return slots;
    }
}
