package com.example.HWork158.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;


public class NoteNotFoundException extends Exception {

    public NoteNotFoundException(UUID id){
        super("Note not found with id: " + id);
    }

}
