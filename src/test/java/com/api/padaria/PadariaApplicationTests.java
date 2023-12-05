package com.api.padaria;

import com.api.padaria.model.Cargo;
import com.api.padaria.model.Curriculo;
import com.api.padaria.service.CargoService;
import com.api.padaria.service.CurriculoService;
import com.api.padaria.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.PathVariable;

import static java.sql.DriverManager.println;

@SpringBootTest
class PadariaApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private CurriculoService curriculoS;
	@Autowired
	private CargoService cargoS;

	@Test
	public void testSalvarCurriculoOK(){
		Cargo cargo1 = new Cargo();
		cargo1.setId(1L);
		cargo1.setCargo("Atendente");

		cargoS.salvar(cargo1);

		Cargo cargo2 = new Cargo();
		cargo2.setId(2L);
		cargo2.setCargo("Padeiro");

		cargoS.salvar(cargo2);

		Curriculo curriculo = new Curriculo();
		curriculo.setId(1L);
		curriculo.setBairro("São Paulo");
		curriculo.setEmail("daniel@hotmail.com.br");
		curriculo.setTelefone("(83)99999-8888");
		curriculo.setNomeCompleto("Daniel da Silva");

		curriculoS.salvar(curriculo, 1L);

		curriculoS.salvar(curriculo, 2L);

	}

	@Test
	public void testeCargoOK(){
		Cargo cargo1 = new Cargo();
		cargo1.setId(1L);
		cargo1.setCargo("Atendente");

		Cargo cargo2 = new Cargo();
		cargo2.setId(2L);
		cargo2.setCargo("Padeiro");


		cargoS.salvar(cargo1);
		cargoS.salvar(cargo2);
	}

}
