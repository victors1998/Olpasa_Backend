package com.olpasa.service.impl;

import com.olpasa.model.Attachment;
import com.olpasa.repo.IAttchmentRepo;
import com.olpasa.repo.IBancoRepo;
import com.olpasa.repo.IGenericoRepo;
import com.olpasa.service.IAttachmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AttachmentServiceImpl extends CRUDImpl<Attachment, Integer> implements IAttachmentService {

    private final IAttchmentRepo attchmentRepo  ;

    @Override
    protected IGenericoRepo<Attachment, Integer> getRepo() {
        return attchmentRepo;
    }

    @Override
    public Attachment saveFile(MultipartFile file, Long idEvaluacion, String userId) throws IOException {
        String uploadDir = "C:/attachmets/";
        File dir = new File(uploadDir);
        if (!dir.exists()) dir.mkdirs();

        // Nombre único
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();

        // Ruta física para guardar en disco (usa separador del SO)
        String filePath = uploadDir + fileName;
        file.transferTo(new File(filePath));

        // ✅ Guardar en BD solo carpeta + nombre, con slash invertidos
        String typePath = (uploadDir + fileName).replace("/", "\\");

        // Extraer extensión
        String extension = "";
        if (file.getOriginalFilename() != null && file.getOriginalFilename().contains(".")) {
            extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        }

        Attachment attachment = new Attachment();
        attachment.setIdEvaluacion(idEvaluacion);
        attachment.setUserId(userId);
        attachment.setFileName(file.getOriginalFilename());
        attachment.setFilePath(typePath);
        attachment.setFileType(extension);
        attachment.setThumbnailCreated(false);
        attachment.setArchived(false);
        attachment.setCreatedDate(LocalDateTime.now());

        return attchmentRepo.save(attachment);
    }
}
