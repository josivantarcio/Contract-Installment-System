package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

	public void processContract(Contract contract, Integer months) {

		OnlinePaymentService onlinePay = new PaypalService();
		double basicQuota = contract.getTotalValue() / months;

		for (int i = 1; i <= months; i++) {

			double updateQuota = onlinePay.interest(basicQuota, i);
			double fullQuota = updateQuota + onlinePay.paymentFee(updateQuota);

			LocalDate dataMes = contract.getDate().plusMonths(i);
			contract.getInstallments().add(new Installment(dataMes, fullQuota));
		}

	}
}
