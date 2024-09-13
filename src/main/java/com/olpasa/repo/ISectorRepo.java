package com.olpasa.repo;

import com.olpasa.model.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ISectorRepo extends IGenericoRepo<Sector, Integer> {

}
