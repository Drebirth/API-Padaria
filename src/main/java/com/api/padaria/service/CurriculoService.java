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
        var testeEmail = c.getEmail();
        var testeCargo = cargoService.buscarCargo(id);
        c.setCargo(cargoService.buscarCargo(id));
        if(testeEmail.equals(busca(c.getEmail())) && testeCargo.equals(c.getCargo()) ){
            throw new RuntimeException("Email cadastrado");
        }

        return service.save(c);



    }

    public Curriculo busca(String email){
        return buscarPorCurriculo(email);
    }

    private Curriculo buscarPorCurriculo(String email){
         return service.findByEmail(email);


    }





}
