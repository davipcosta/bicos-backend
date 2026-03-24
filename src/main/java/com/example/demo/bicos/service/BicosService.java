package com.example.demo.bicos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.bicos.models.Bicos;
import com.example.demo.bicos.repo.BicosRepository;

@Service
public class BicosService {
    private final BicosRepository bicosRepo;

    public BicosService(BicosRepository bicosRepo) {

        this.bicosRepo = bicosRepo;
    }

    public List<Bicos> listBicos(){
        return bicosRepo.findAll();
    }
}
