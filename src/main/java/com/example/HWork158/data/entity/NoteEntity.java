package com.example.HWork158.data.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "note")
public class NoteEntity {
    @Id

        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private UUID id;
        private String title;
        private String content;


    }


