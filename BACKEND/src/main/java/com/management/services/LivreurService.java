package com.management.services;

import com.management.entities.Livreur;
import com.management.repositories.LivreurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivreurService {
    @Autowired
    private LivreurRepository livreurRepository;

    public Livreur findById(Long id) {
        return livreurRepository.findById(id).orElse(null);
    }

    public List<Livreur> findAll() {
        return livreurRepository.findAll();
    }

    public Livreur save(Livreur livreur) {
        return livreurRepository.save(livreur);
    }

    public void delete(Livreur livreur) {
        livreurRepository.delete(livreur);
    }

    public void deleteById(Long id) {
        livreurRepository.deleteById(id);
    }

    public void update(Livreur livreur) {
        livreurRepository.save(livreur);
    }


}
