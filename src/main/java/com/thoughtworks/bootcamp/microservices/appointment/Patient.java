package com.thoughtworks.bootcamp.microservices.appointment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by abhijeek on 12/02/17.
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    private String firstname;
    private String lastname;

}
