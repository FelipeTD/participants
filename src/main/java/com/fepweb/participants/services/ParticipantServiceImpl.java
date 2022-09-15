package com.fepweb.participants.services;

import com.fepweb.participants.model.Participant;
import com.fepweb.participants.repository.ParticipantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ParticipantServiceImpl implements ParticipantService {

    private final ParticipantRepository repository;

    @Override
    public Participant save(Participant participant) {
        try {
            Participant response = repository.save(participant);
            return response;
        } catch (IllegalArgumentException error) {
            return null;
        }
    }
    @Override
    public List<Participant> findAll() {
        return repository.findAll();
    }

    @Override
    public Participant delete(Participant participant) {
        try {
            repository.delete(participant);
            return participant;
        } catch (Exception error) {
            return null;
        }
    }

}
