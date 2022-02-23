package com.dardell.businesscard.service;

import com.dardell.businesscard.exception.UserNotFoundException;
import com.dardell.businesscard.model.Me;
import com.dardell.businesscard.repo.MeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MeService {
    private final MeRepo meRepo;

    @Autowired
    public MeService(MeRepo meRepo) {
        this.meRepo = meRepo;
    }

    public Me updateMe(Me me) {
        return meRepo.save(me);
    }

    public Me findMeById(Long id){
        return meRepo.findMeById(id).
                orElseThrow(() -> new UserNotFoundException("User by id " + id + "was not found"));
    }

    public Me addMe(Me me) {
        return meRepo.save(me);
    }
}
