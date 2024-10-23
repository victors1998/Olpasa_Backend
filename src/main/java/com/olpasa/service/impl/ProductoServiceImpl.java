package com.olpasa.service.impl;

import com.olpasa.model.Producto;
import com.olpasa.repo.IGenericoRepo;
import com.olpasa.repo.IProductoRepo;
import com.olpasa.service.IProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl extends CRUDImpl<Producto, Integer> implements IProductoService {

    private final IProductoRepo productoRepo;

    @Override
    protected IGenericoRepo<Producto, Integer> getRepo() {
        return productoRepo;
    }
}
