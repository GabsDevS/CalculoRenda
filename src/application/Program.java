package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.ContratoPorHora;
import entities.Departamento;
import entities.Trabalhador;
import entities.enums.NivelTrabalhador;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		
		
		
		System.out.print("Informe o Departamento: ");
		Departamento departamento = new Departamento(sc.nextLine());
		System.out.println("Entre com as informações do Trabalhador...");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Nível: ");
		NivelTrabalhador nivel = NivelTrabalhador.valueOf(sc.nextLine());
		System.out.print("Salário: ");
		Double salario = sc.nextDouble();
		
		Trabalhador trabalhador = new Trabalhador(nome, nivel, salario, departamento);

		System.out.print("Quantos contratos para este trabalhador? ");
		Integer numeros_contratos = sc.nextInt();
		sc.nextLine();
		
		
		
		for (int i = 0; i < numeros_contratos; i++) {
			System.out.printf("Entre com a data do %d contrato: ", i + 1);
			System.out.print("Data (DD/MM/YYYY): ");
			Date data = sdf1.parse(sc.nextLine());
			System.out.print("Valor por Hora: ");
			Double valorHora = sc.nextDouble();
			System.out.print("Duração (Horas): ");
			Integer horas = sc.nextInt();
			sc.nextLine();
			
			ContratoPorHora contrato = new ContratoPorHora(data, valorHora, horas);
			trabalhador.adicionarContrato(contrato);
		}
		
		System.out.println();
		System.out.print("Informe o mês e o ano para Calcular a Renda: (MM/YYYY): ");
		String periodo = sc.nextLine();
		String[] vect = periodo.split("/");
		
		int mes = Integer.parseInt(vect[0]);
		int ano = Integer.parseInt(vect[1]);
	
		
		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
		System.out.printf("Renda de %d/%d: R$ %.2f", mes, ano, trabalhador.renda(ano, mes));
		
		
		sc.close();
	}

}
