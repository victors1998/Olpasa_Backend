package com.olpasa.service;

import com.olpasa.model.Attachment;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IAttachmentService extends ICRUD<Attachment, Integer>{

    Attachment saveFile(MultipartFile file, Long idEvaluacion, String userId) throws IOException;
}
