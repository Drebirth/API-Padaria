package com.api.padaria.service;


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
            validaCurriculo(c);

            if (testeEmail.equals(buscar(c.getEmail())) && testeCargo.equals(c.getCargo())) {
                throw new RuntimeException("Email cadastrado");
            }
            return service.save(c);

    }

    public Curriculo buscar(String email){
        return buscarPorCurriculo(email);
    }

    private Curriculo buscarPorCurriculo(String email){
         return service.findByEmail(email);
    }

    private Curriculo validaCurriculo(Curriculo curriculo){

            if(curriculo.getNomeCompleto().isBlank()){
                throw new RuntimeException("Nome não pode ser vazio!");
            }   else if (curriculo.getBairro().isEmpty()) {
                throw new RuntimeException("Verifique o Bairro pois ele não pode ser vazio!");
            } else if (curriculo.getTelefone().isEmpty()) {
                throw new RuntimeException("Verifique o telefone ele não pode ser vazio!");
            } else if (!curriculo.getEmail().contains("@")) {
                throw new RuntimeException("Verifique o e-mail");
            }
            return curriculo;

    }





}
