package com.example.HWork158.controller;

import com.example.HWork158.data.entity.NoteEntity;
import com.example.HWork158.data.repository.NoteRepository;
import com.example.HWork158.service.exception.NoteNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    @PostMapping
    public ResponseEntity<NoteEntity> createNote(@Valid @RequestBody NoteEntity noteEntity) {
        NoteEntity savedNote = noteRepository.save(noteEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedNote);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoteEntity> getNoteById(@PathVariable UUID id) throws NoteNotFoundException {
        NoteEntity noteEntity = noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));
        return ResponseEntity.ok().body(noteEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NoteEntity> updateNote(@PathVariable UUID id, @Valid @RequestBody NoteEntity noteDetails) throws NoteNotFoundException {
        NoteEntity noteEntity = noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));

        noteEntity.setTitle(noteDetails.getTitle());
        noteEntity.setContent(noteDetails.getContent());

        NoteEntity updatedNote = noteRepository.save(noteEntity);
        return ResponseEntity.ok(updatedNote);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable UUID id) throws NoteNotFoundException {
        NoteEntity noteEntity = noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));

        noteRepository.delete(noteEntity);
        return ResponseEntity.noContent().build();
    }
}