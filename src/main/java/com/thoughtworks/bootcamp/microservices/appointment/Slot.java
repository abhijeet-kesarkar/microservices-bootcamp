package com.thoughtworks.bootcamp.microservices.appointment;

import lombok.Builder;
import lombok.Data;

/**
 * Created by abhijeek on 12/02/17.
 */
@Data
@Builder
public class Slot {
    String id;
    String doctor;
    String start;
    String end;
}
