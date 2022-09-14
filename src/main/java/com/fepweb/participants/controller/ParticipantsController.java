package com.fepweb.participants.controller;

import com.fepweb.participants.entity.ParticipantEntity;
import com.fepweb.participants.services.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class ParticipantsController {

    private final ParticipantService service;

    @GetMapping("/participant")
    public List<ParticipantEntity> getParticipants() {
        return service.findAll();
    }

    @PostMapping("/participant")
    public ResponseEntity<ParticipantEntity> saveParticipants(
            @RequestBody ParticipantEntity participant) {

        ParticipantEntity response = service.save(participant);

        if (Objects.isNull(response)) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(response);

    }

    @DeleteMapping("/participant")
    public ResponseEntity<ParticipantEntity> deleteParticipant(
            @RequestBody ParticipantEntity participant) {

        ParticipantEntity response = service.delete(participant);

        if (Objects.isNull(response)) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(response);

    }

}
