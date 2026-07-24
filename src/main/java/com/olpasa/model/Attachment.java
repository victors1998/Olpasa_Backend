package com.olpasa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "attachment")
public class Attachment {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_evaluacion")
    private Integer id_evalucion;

    @Column(name = "user_id", length = 20)
    private String user_id;

    @Column(name = "file_name", length = 250)
    private String file_name;

    @Column(name = "file_path", length = 250)
    private String file_path;

    @Column(name = "file_type", length = 50)
    private String file_type;

    @Column(name = "thumbnail_created")
    private Boolean thumbnailCreated;

    @Column(name = "archived")
    private Boolean archived;

    // DATETIME2 → LocalDateTime
    @Column(name = "created_date")
    private LocalDateTime createdDate;

}
