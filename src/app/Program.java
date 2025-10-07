package app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		try {

			System.out.println("Entre os dados do contrato:");
			System.out.print("Numero: ");
			int numero = sc.nextInt();

			sc.nextLine();
			System.out.print("Data (dd/mm/yyyy): ");
			LocalDate data = LocalDate.parse(sc.next(), dtf);

			System.out.print("Valor do Contrato: ");
			Double valorContrato = sc.nextDouble();

			System.out.print("Entre com o numero de parcelas: ");
			int parcelas = sc.nextInt();

			Contract contract = new Contract(numero, data, valorContrato);

			ContractService contraService = new ContractService();
			contraService.processContract(contract, parcelas);

			for (Installment inst : contract.getInstallments()) {
				System.out.println(dtf.format(inst.getDueDate()) + " - " + String.format("%.2f", inst.getAmount()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sc != null) {
				sc.close();
			}
		}

	}
}
