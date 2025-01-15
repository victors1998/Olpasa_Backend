package com.olpasa.service;

import com.olpasa.model.Menu;

import java.util.List;

public interface IMenuService {

    List<Menu> getMenusByUsername(String username);
}
