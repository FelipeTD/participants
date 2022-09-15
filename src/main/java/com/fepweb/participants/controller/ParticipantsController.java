package com.fepweb.participants.controller;

import com.fepweb.participants.model.Participant;
import com.fepweb.participants.services.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequiredArgsConstructor
@RequestMapping("/api/participant")
public class ParticipantsController {

    private final ParticipantService service;

    @GetMapping
    public List<Participant> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Participant> findById(@PathVariable("id") Long id) {
        Optional<Participant> response = service.findById(id);

        return response
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    // @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Participant> create(@RequestBody Participant participant) {

        Participant response = service.save(participant);

        if (Objects.isNull(response)) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

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
