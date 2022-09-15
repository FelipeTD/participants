package com.fepweb.participants.services;

import com.fepweb.participants.model.Participant;

import java.util.List;
import java.util.Optional;

public interface ParticipantService {

    List<Participant> findAll();
    Optional<Participant> findById(Long id);
    Participant save(Participant participant);
    void deleteById(Long id);


}
