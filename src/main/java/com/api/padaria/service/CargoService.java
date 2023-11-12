package com.api.padaria.service;

import com.api.padaria.model.Cargo;
import com.api.padaria.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoService {

    @Autowired
    private CargoRepository service;

    public CargoService(CargoRepository service) {
        this.service = service;
    }


    public List<Cargo> listar(){
        return service.findAll();
    }

    public Cargo salvar(Cargo c){
        return service.save(c);
    }

    public Cargo buscarCargo(Long id){
        return buscarPorID(id);
    }



    private Cargo buscarPorID(Long id){
        return service.findById(id)
                .orElseThrow(() -> new RuntimeException("Cargo não encontrado"));

    }












}
