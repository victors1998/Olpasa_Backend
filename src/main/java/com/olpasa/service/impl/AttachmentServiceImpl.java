package com.olpasa.service.impl;

import com.olpasa.model.Attachment;
import com.olpasa.repo.IAttchmentRepo;
import com.olpasa.repo.IBancoRepo;
import com.olpasa.repo.IGenericoRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AttachmentServiceImpl extends CRUDImpl<Attachment, Integer>{

    private final IAttchmentRepo attchmentRepo  ;

    @Override
    protected IGenericoRepo<Attachment, Integer> getRepo() {
        return attchmentRepo;
    }
}
