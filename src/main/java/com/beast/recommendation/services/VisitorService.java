package com.beast.recommendation.services;

import java.util.List;
import java.util.Optional;

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

    public VisitorTModel getVisitbyId(Long id) {
        Optional<VisitorTModel> aVisitor = visitRepo.findById(id);
        if (aVisitor.isPresent()) {
            return aVisitor.get();
        }
        return null;
    }

    public void updateVisitor(VisitorTModel newVisistor) {
        visitRepo.save(newVisistor);
    }
}
