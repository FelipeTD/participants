package com.fepweb.participants.services;

import com.fepweb.participants.entity.ParticipantEntity;

import java.util.List;

public interface ParticipantService {

    List<ParticipantEntity> findAll();
    ParticipantEntity save(ParticipantEntity participant);
    ParticipantEntity delete(ParticipantEntity participant);

}
