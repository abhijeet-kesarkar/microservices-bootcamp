package com.thoughtworks.bootcamp.microservices.appointment;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by abhijeek on 13/02/17.
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class AppointmentNotAvailableException extends RuntimeException {
}
