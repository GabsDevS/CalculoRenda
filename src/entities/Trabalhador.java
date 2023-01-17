package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.NivelTrabalhador;

public class Trabalhador {
	private String nome;
	private NivelTrabalhador nivel;
	private Double salario;
	
	private Departamento departamento;
	private List<ContratoPorHora> contratos = new ArrayList<>();
	
	public Trabalhador() {
		
	}
	
	public Trabalhador(String nome, NivelTrabalhador nivel, Double salario, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salario = salario;
		this.departamento = departamento;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public NivelTrabalhador getNivel() {
		return nivel;
	}
	
	public void setNivel(NivelTrabalhador nivel) {
		this.nivel = nivel;
	}
	
	public Double getSalario() {
		return salario;
	}
	
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	public Departamento getDepartamento() {
		return departamento;
	}
	
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	public void adicionarContrato(ContratoPorHora contrato) {
		contratos.add(contrato);
	}
	
	public void removerContrato(ContratoPorHora contrato) {
		contratos.remove(contrato);
	}
	
	public Double renda(int ano, int mes) {
		double soma = salario;
		Calendar cal = Calendar.getInstance();
		
		for(ContratoPorHora c : contratos) {
			cal.setTime(c.getData());
			
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = 1 + cal.get(Calendar.MONTH);
		
			if (c_ano == ano && c_mes == mes) {
				soma += c.valorTotal();
			}
		}
		
		return soma;
	}
	
	public String toString() {
		return "Trabalhador: " + getNome() + ", Nível: " + getNivel() + ", Salário: R$ " + getSalario();
	}
}
