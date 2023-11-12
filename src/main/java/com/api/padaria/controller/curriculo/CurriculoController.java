package com.api.padaria.controller.curriculo;

import com.api.padaria.model.Curriculo;
import com.api.padaria.service.CurriculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/curriculo")
public class CurriculoController {
    @Autowired
    private CurriculoService service;


    public CurriculoController(CurriculoService service) {
        this.service = service;
    }


    @RequestMapping("/")
    public List<Curriculo> todosCurriculos(){
        return service.listarCurriculos();
    }


    @RequestMapping("/{id}")
    public Curriculo salvar(@RequestBody Curriculo c,@PathVariable Long id){
        return service.salvar(c,id);
    }
}
