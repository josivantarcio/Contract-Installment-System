package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

	private OnlinePaymentService onlinePaymentService;

	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, Integer months) {

		//OnlinePaymentService onlinePay = new PaypalService();
		double basicQuota = contract.getTotalValue() / months;

		for (int i = 1; i <= months; i++) {

			double updateQuota = onlinePaymentService.interest(basicQuota, i);
			double fee = onlinePaymentService.paymentFee(basicQuota + updateQuota);
			double fullQuota = basicQuota + updateQuota + fee;
			
			LocalDate dataMes = contract.getDate().plusMonths(i);
			contract.getInstallments().add(new Installment(dataMes, fullQuota));
		}

	}
}
