package com.olpasa.service;

import com.olpasa.model.Privilegio;

import java.util.List;

public interface IPrivilegioService{

    List<Privilegio> getPrivilegioByUsername(String nombre_cuenta);
}
