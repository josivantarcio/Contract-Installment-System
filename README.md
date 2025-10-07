🧾 Java - Interfaces Project (Contract Installment System)

This project was developed as a practical exercise from the “Interfaces” chapter of the Java Complete Course – Object-Oriented Programming by Prof. Nélio Alves (DevSuperior).

The goal is to automate the processing of contracts and the generation of installments using interfaces, dependency injection, and low coupling between classes.

🚀 Project Description

A company wants to automate the processing of its contracts.
The system must generate monthly installments for a given contract based on the number of months specified.

The online payment service used is PayPal, which applies:

1% simple interest per month

2% payment fee on the updated installment amount

📘 Example

Input:

Number: 8028
Date (dd/MM/yyyy): 25/06/2018
Contract value: 600.00
Number of installments: 3


Expected output:

Installments:
25/07/2018 - 206.04
25/08/2018 - 208.08
25/09/2018 - 210.12

Calculation:
Installment	Formula	Final Value
#1	200 + 1% * 1 = 202 → 202 + 2% = 206.04	✅
#2	200 + 1% * 2 = 204 → 204 + 2% = 208.08	✅
#3	200 + 1% * 3 = 206 → 206 + 2% = 210.12	✅
🧩 Project Structure
src/
 ├── app/
 │   └── Program.java
 │
 ├── model/
 │   ├── entities/
 │   │   ├── Contract.java
 │   │   └── Installment.java
 │   │
 │   └── services/
 │       ├── OnlinePaymentService.java
 │       ├── PaypalService.java
 │       └── ContractService.java
 │
 └── README.md

⚙️ Key Concepts

Interfaces – define contracts for services (e.g., OnlinePaymentService)

Dependency Injection – ContractService depends on an abstraction, not a concrete class

Low Coupling – allows easily swapping the payment service implementation

Object-Oriented Programming (OOP) – encapsulation, composition, and polymorphism

java.time API – for date manipulation (LocalDate, plusMonths())

🧠 Core Logic (ContractService)
double basicQuota = totalValue / months;
for (int i = 1; i <= months; i++) {
    double updatedQuota = onlineService.interest(basicQuota, i);
    double fullQuota = updatedQuota + onlineService.paymentFee(updatedQuota);
    LocalDate dueDate = contract.getDate().plusMonths(i);
    contract.getInstallments().add(new Installment(dueDate, fullQuota));
}

🧪 How to Run

Clone the repository:

git clone https://github.com/yourusername/interfaces-contract-java.git
cd interfaces-contract-java


Compile the project:

javac -d bin src/**/*.java


Run the program:

java -cp bin app.Program


Enter the contract data as shown in the example above.

📚 Technologies Used

Java 17+

Object-Oriented Programming (OOP)

java.time API

Interfaces and Polymorphism

Console Application (CLI)

👨‍💻 Author

Developed by [Your Name]
💼 Full Stack Developer | Data Scientist
📧 [your-email@example.com
]
🔗 LinkedIn
 | GitHub

🏁 License

This project is for educational purposes and follows the standards of the Java Complete Course – Nélio Alves / DevSuperior.
