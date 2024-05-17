package com.beast.recommendation.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.beast.recommendation.models.VisitorTModel;

@Repository
public interface VisitorRepository extends CrudRepository<VisitorTModel, Long> {
    List<VisitorTModel> findAll();
    Optional<VisitorTModel> findById(Long id);
}
