package br.org.serratec.paracasa01;

public class Veiculo {
	private int id;
	public String marca;
	public String modelo;
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getMarca() {
		return marca;
	}



	public void setMarca(String marca) {
		this.marca = marca;
	}



	public String getModelo() {
		return modelo;
	}



	public void setModelo(String modelo) {
		this.modelo = modelo;
	}



	public String exibeDados() {
		return String.format("Marca: %s - Modelo: %s ",
				marca, modelo);
		
	}





}
