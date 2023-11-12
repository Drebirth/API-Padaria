package com.api.padaria.service;

import com.api.padaria.model.Cargo;
import com.api.padaria.model.Curriculo;
import com.api.padaria.repository.CurriculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CurriculoService {


    private CurriculoRepository service;
    private CargoService cargoService;


    @Autowired
    public CurriculoService(CurriculoRepository service, CargoService cargoService) {
        this.service = service;
        this.cargoService = cargoService;
    }

    public List<Curriculo> listarCurriculos(){
        return service.findAll();
    }

    public Curriculo salvar(Curriculo c,Long id){
        var base = buscarPorCurriculo(c.getEmail());
        if(base.getEmail().isEmpty()){
            c.setEmail(c.getEmail());
        } else if ((base.getCargo() == cargoService.buscarCargo(id))) {
            throw new RuntimeException("Usuário já se encontra cadastro no sistema");
        }
        else{
            c.setCargo(cargoService.buscarCargo(id));

        }
        return service.save(c);
    }


    private Curriculo buscarPorCurriculo(String email){
        return service.findByEmail(email);
    }





}
