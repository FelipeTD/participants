package com.fepweb.participants.services;

import com.fepweb.participants.model.Participant;

import java.util.List;

public interface ParticipantService {

    List<Participant> findAll();
    Participant save(Participant participant);
    Participant delete(Participant participant);

}
