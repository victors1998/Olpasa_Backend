package com.olpasa.service.impl;

import com.olpasa.model.EmpresaTransporte;
import com.olpasa.repo.IEmpresaTransporteRepo;
import com.olpasa.repo.IGenericoRepo;
import com.olpasa.service.IEmpresaTransporteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmpresaTransporteImpl  extends CRUDImpl<EmpresaTransporte, Integer> implements IEmpresaTransporteService {

    private final IEmpresaTransporteRepo empresaTransporteRepo;

    @Override
    protected IGenericoRepo<EmpresaTransporte, Integer> getRepo() {
        return empresaTransporteRepo;
    }
}
