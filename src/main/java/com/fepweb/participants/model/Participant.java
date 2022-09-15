package com.fepweb.participants.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="TBL_PARTICIPANTS")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long code;

    @Column(name="external_code", nullable = false, length = 100)
    @JsonProperty("externalCode")
    //@JsonIgnore
    private Long externalCode;

    @Column(name="name", nullable = false, length = 100)
    private String name;

    @Column(name="cpf", nullable = false, length = 20)
    private String cpf;

    @Column(name="phone", length=15)
    private String phone;

    @Column(name="assign", nullable = false)
    private Boolean assign;

    @Column(name="status", nullable = false)
    private Boolean status;

}
