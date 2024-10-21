package com.olpasa.service.impl;

import com.olpasa.model.Proveedor;
import com.olpasa.repo.IGenericoRepo;
import com.olpasa.repo.IProveedorRepo;
import com.olpasa.service.IProveedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProveedorServiceImpl extends CRUDImpl<Proveedor, Integer> implements IProveedorService {

    private final IProveedorRepo proveedorRepo;

    @Override
    protected IGenericoRepo<Proveedor, Integer> getRepo() {
        return proveedorRepo;
    }
}
