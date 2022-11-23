package com.me.project.dto;

import com.me.project.entity.StoreAcc;
import lombok.Data;

import javax.validation.constraints.Email;
import java.io.Serializable;

/**
 * A DTO for the {@link StoreAcc} entity
 */
@Data
public class StoreAccDTO implements Serializable {
    private final String username;
    @Email
    private final String email;
    private final String password;
}