package entities;

import java.util.Date;

public class ContratoPorHora {
	private Date data;
	private Double valorPorHora;
	private Integer horas;
	
	public ContratoPorHora(Date data, Double valorPorHora, Integer horas) {
		this.data = data;
		this.valorPorHora = valorPorHora;
		this.horas = horas;
	}
	
	public Date getData() {
		return data;
	}
	
	public Double valorTotal() {
		return horas * valorPorHora;
	}
}
