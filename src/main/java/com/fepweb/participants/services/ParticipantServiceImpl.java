package com.fepweb.participants.services;

import com.fepweb.participants.entity.ParticipantEntity;
import com.fepweb.participants.repository.ParticipantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ParticipantServiceImpl implements ParticipantService {

    private final ParticipantRepository repository;

    @Override
    public ParticipantEntity save(ParticipantEntity participant) {
        try {
            ParticipantEntity response = repository.save(participant);
            return response;
        } catch (IllegalArgumentException error) {
            return null;
        }
    }
    @Override
    public List<ParticipantEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public ParticipantEntity delete(ParticipantEntity participant) {
        try {
            repository.delete(participant);
            return participant;
        } catch (Exception error) {
            return null;
        }
    }

}
