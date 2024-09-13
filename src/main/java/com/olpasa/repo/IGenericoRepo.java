package com.olpasa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenericoRepo<T, ID> extends JpaRepository<T, ID> {
}
