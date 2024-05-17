package com.beast.recommendation.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.beast.recommendation.models.VisitorTModel;
import com.beast.recommendation.repositories.VisitorRepository;

@Service
public class VisitorService {

    private VisitorRepository visitRepo;

    public VisitorService(VisitorRepository initVisitorRepo) {
        this.visitRepo = initVisitorRepo;
    }

    public List<VisitorTModel> showAllUsers() {
        return visitRepo.findAll();
    }

    public void createUser(VisitorTModel newVisitor) {
        visitRepo.save(newVisitor);
    }
}
