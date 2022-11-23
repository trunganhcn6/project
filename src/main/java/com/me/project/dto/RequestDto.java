package com.me.project.dto;

import com.me.project.entity.RequestDetails;
import com.me.project.entity.Status;
import com.me.project.entity.Store;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * A DTO for the {@link com.me.project.entity.Request} entity
 */
@Data
public class RequestDto implements Serializable {
    @NotBlank
    private final Date requestDate;
    @NotBlank
    private final Date expectedDelivery;
    @NotBlank
    private final Date realDelivery;
    private final Status status;
    private final Store store;
    private final Set<RequestDetails> requestDetails;
}