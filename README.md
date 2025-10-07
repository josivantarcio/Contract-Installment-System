# Contract Installment System (Java)

This project implements a **contract installment system** as a practice exercise from the *“Interfaces”* chapter of the **Java Complete / Object-Oriented Programming** course by Nélio Alves (DevSuperior).

It demonstrates:
- Use of **interfaces** and **polymorphism**
- **Dependency injection** (decoupling between service and logic)
- Calculation of contract installments with **interest** and **payment fee**
- Date manipulations via `java.time`

---

## 📦 Project Description

The system reads a contract with:
- Number
- Date
- Total value

Then it reads the number of months for installments and computes each installment applying:

1. **1% simple interest per month**  
2. **2% payment fee** on the amount updated with interest  

It then prints out each installment’s due date and amount.

### Example

**Input:**


Number: 8028
Date (dd/MM/yyyy): 25/06/2018
Contract value: 600.00
Number of installments: 3


**Expected Output:**


Installments:
25/07/2018 - 206.04
25/08/2018 - 208.08
25/09/2018 - 210.12


---

## 🗂️ Project Structure



src/
├── app/
│ └── Program.java
│
├── model/
│ ├── entities/
│ │ ├── Contract.java
│ │ └── Installment.java
│ │
│ └── services/
│ ├── OnlinePaymentService.java
│ ├── PaypalService.java
│ └── ContractService.java
└── README.md


- `entities/` — classes de domínio: `Contract`, `Installment`  
- `services/` — lógica de cálculo e interface de pagamento  
- `app/Program.java` — classe que roda o programa e faz I/O  

---

## 🔍 Key Concepts & Logic

- **Interface** `OnlinePaymentService` define os métodos `interest(...)` e `paymentFee(...)`  
- `PaypalService` implementa essa interface  
- `ContractService` injeta (usa) um `OnlinePaymentService` para aplicar as regras  
- Em `ContractService.processContract(...)`:
  ```java
  double basicQuota = contract.getTotalValue() / months;
  for (int i = 1; i <= months; i++) {
      double updated = onlineService.interest(basicQuota, i);
      double full = updated + onlineService.paymentFee(updated);
      LocalDate dueDate = contract.getDate().plusMonths(i);
      contract.getInstallments().add(new Installment(dueDate, full));
  }

🛠 How to Run

Clone the repo:

git clone https://github.com/josivantarcio/Contract-Installment-System.git
cd Contract-Installment-System


Compile:

javac -d bin src/**/*.java


Execute:

java -cp bin app.Program


When prompted, enter data (number, date, total, months). The program will print each installment.

👤 Author

Developed by Josevan Oliveira
🔗 GitHub Profile

📄 License

This project uses the MIT License — see the LICENSE file for details.
