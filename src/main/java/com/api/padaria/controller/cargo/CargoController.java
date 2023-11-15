package com.api.padaria.controller.cargo;

import com.api.padaria.model.Cargo;
import com.api.padaria.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cargos")
public class CargoController {

    @Autowired
    private CargoService service;

    @RequestMapping("/")
    public List<Cargo> listarCargos(){
        return service.listar();
    }

    @RequestMapping("/cadastrar")
    public Cargo salvar(@RequestBody Cargo c){
        return service.salvar(c);
    }

    @RequestMapping("/{id}")
    public Cargo buscarUm(@PathVariable Long id){
        return service.buscarCargo(id);
    }
}
