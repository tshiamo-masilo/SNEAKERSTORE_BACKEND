package com.sneaker.store.repository;

import com.sneaker.store.model.Sneaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Sneaker, Long> {
}
