package com.fepweb.participants.controller;

import com.fepweb.participants.model.Participant;
import com.fepweb.participants.services.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequiredArgsConstructor
@RequestMapping("/api/participant")
public class ParticipantsController {

    private final ParticipantService service;

    @GetMapping
    public List<Participant> getParticipants() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Participant> saveParticipants(
            @RequestBody Participant participant) {

        Participant response = service.save(participant);

        if (Objects.isNull(response)) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(response);

    }

    @DeleteMapping
    public ResponseEntity<Participant> deleteParticipant(
            @RequestBody Participant participant) {

        Participant response = service.delete(participant);

        if (Objects.isNull(response)) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(response);

    }

}
