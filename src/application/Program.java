package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;


public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Entre com o nome do departamento: ");
		String departmentName = sc.nextLine();
		System.out.println("Entre com os dados do Trabalhador: ");
		System.out.print("Nome: ");
		String workerName = sc.nextLine();
		System.out.println("Level do trabalhador: ");
		String workerLevel = sc.nextLine();
		System.out.print("Salário Base: ");
		double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), 
				baseSalary, new Department(departmentName));
		
		
		
		System.out.println("Quantos contratos o trabalhador irá ter? ");
		int n = sc.nextInt();
		
		for (int i = 1; i<=n; i++) {
			System.out.println("Entre com o contrato #" + i);
			System.out.println("Data (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Valor por Hora: ");
			double valuePerHour = sc.nextDouble();
			System.out.println("Duração (horas): ");
			int hours = sc.nextInt();
			
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);//para associar o contrato no trabalhador //coloca na lista de contratos
		}
		
		System.out.println("");
		System.out.print("Entre com Mês e ano (MM/YYYY) para calcular o salário (Contratos + salário): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0,2));//sempre uma posicao a mais para parar
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.println("Nome: " + worker.getName());
		System.out.println("Departamento: " + worker.getDepartment().getName()); // acessa o worker pra depóis acessar o nome do department
		System.out.println("Salário de " + monthAndYear + ": " + 
		String.format("%.2f", worker.income(year, month)));

		sc.close();
	}
}
