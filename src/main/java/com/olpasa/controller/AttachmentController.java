package com.olpasa.controller;

import com.olpasa.dto.AttachmentDTO;
import com.olpasa.model.Attachment;
import com.olpasa.service.IAttachmentService;
import com.olpasa.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;

@RestController
@RequestMapping("/attachment")
@RequiredArgsConstructor
public class AttachmentController {

    private final IAttachmentService attachmentService;
    private final MapperUtil mapperUtil;

    @PostMapping("/upload")
    public ResponseEntity<AttachmentDTO> uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("idEvaluacion") Long idEvaluacion,
            @RequestParam("userId") String userId) {
        try {
            Attachment saved = attachmentService.saveFile(file, idEvaluacion, userId);
            AttachmentDTO dto = mapperUtil.map(saved, AttachmentDTO.class);

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(saved.getId())
                    .toUri();

            return ResponseEntity.created(location).body(dto);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
