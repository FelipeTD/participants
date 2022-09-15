package com.fepweb.participants.services;

import com.fepweb.participants.model.Participant;
import com.fepweb.participants.repository.ParticipantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ParticipantServiceImpl implements ParticipantService {

    private final ParticipantRepository repository;

    @Override
    public List<Participant> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Participant> findById(Long id) {
        return repository.findById(id);
    }

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
    public void deleteById(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception error) {
            System.err.println("Error to delete participant");
        }
    }

}
