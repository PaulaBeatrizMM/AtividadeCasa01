package br.org.serratec.paracasa01;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/veiculos")
public class VeiculoController {
	
	List<Veiculo> veiculos = new ArrayList<>();
	int id = 0;
	
	@GetMapping
	public List<Veiculo> obterTodos() {
		return veiculos;
	}
	
	@GetMapping("/{id}")
	public Veiculo obterVeiculo(@PathVariable int id) {
		int indice = obterPosicaoLista(id);
		
		if (indice != -1) {
			return veiculos.get(indice);
		}
		return null;
	}
	

	@DeleteMapping("/{id}")
	public void excluirVeiculo(@PathVariable int id) {
		int indice = obterPosicaoLista(id);
		
		if (indice != -1) {
			veiculos.remove(indice);
		}
		
	}
	
	@PostMapping
	public Veiculo cadastrarVeiculo(@RequestBody Veiculo veiculo) {
		veiculo.setId(++id);
		veiculos.add(veiculo);
		return veiculo;	
	}
	
	
	@PutMapping("/{id}")
	public Veiculo alteraVeiculo(@PathVariable int id, @RequestBody Veiculo veiculosAlterado) {
		int indice = obterPosicaoLista(id);

		
			if (indice != 1) {
				veiculosAlterado.setId(id);
				veiculos.set(indice,  veiculosAlterado);
				return veiculosAlterado;
			}
		
		return null;
	}
		
		private int obterPosicaoLista(int id) {
			for (int i = 0; i < veiculos.size(); i++) {
				if (veiculos.get(i).getId() == id) {
					return i;
			}
    }
		return -1;
	}
}



	
