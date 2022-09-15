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
                .map(recordFound -> ResponseEntity.ok().body(recordFound))
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

    @PutMapping("/{id}")
    public ResponseEntity<Participant> update(
            @PathVariable("id") Long id, @RequestBody Participant participant) {

        Optional<Participant> response = service.findById(id);

        return response
                .map(recordFound -> {
                    recordFound.setExternalCode(participant.getExternalCode());
                    recordFound.setName(participant.getName());
                    recordFound.setCpf(participant.getCpf());
                    recordFound.setPhone(participant.getPhone());
                    recordFound.setAssign(participant.getAssign());
                    recordFound.setStatus(participant.getStatus());
                    Participant updated = service.save(recordFound);
                    return ResponseEntity.ok().body(recordFound);
                })
                .orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        return service.findById(id)
                .map(recordFound -> {
                    service.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());

    }

}
