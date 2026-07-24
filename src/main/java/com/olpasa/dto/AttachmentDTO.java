package com.olpasa.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttachmentDTO {

    private Integer id;
    private Long idEvaluacion;
    private String userId;
    private String fileName;
    private String filePath;
    private String fileType;
    private Boolean thumbnailCreated;
    private Boolean archived;
    private LocalDateTime createdDate;
}
