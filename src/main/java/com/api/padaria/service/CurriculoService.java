package com.api.padaria.service;

import com.api.padaria.model.Cargo;
import com.api.padaria.model.Curriculo;
import com.api.padaria.repository.CurriculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurriculoService {


    private CurriculoRepository service;
    private CargoService cargoService;


    @Autowired
    public CurriculoService(CurriculoRepository service, CargoService cargoService) {
        this.service = service;
        this.cargoService = cargoService;
    }

    public List<Curriculo> listar(){
        return service.findAll();
    }

    public Curriculo salvar(Curriculo c,Long id){
        c.setCargo(cargoService.buscarCargo(id));
        return service.save(c);
    }


}
