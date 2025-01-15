package com.olpasa.service.impl;

import com.olpasa.model.Menu;
import com.olpasa.repo.IGenericoRepo;
import com.olpasa.repo.IMenuRepo;
import com.olpasa.service.IMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MesnuServiceImpl extends CRUDImpl<Menu, Integer> implements IMenuService {

    private final IMenuRepo repo;

    @Override
    protected IGenericoRepo<Menu, Integer> getRepo() {
        return repo;
    }


    @Override
    public List<Menu> getMenusByUsername(String username) {
        //String contextUser = SecurityContextHolder.getContext().getAuthentication().getName();
        return repo.getMenusByUsername(username);
    }
}
