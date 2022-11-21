package com.me.project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter @Setter
public class Status {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    private String name;

    @OneToMany(mappedBy = "status", orphanRemoval = true)
    private Set<Request> requests = new LinkedHashSet<>();


}
