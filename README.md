Excelente 👌 — adicionar uma seção **“How it works”** vai deixar seu projeto mais completo e didático para quem visitar o GitHub.
Abaixo está a versão revisada do `README.md` com essa nova seção integrada — pronta para substituir o seu arquivo atual.

---

```markdown
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
```

Number: 8028
Date (dd/MM/yyyy): 25/06/2018
Contract value: 600.00
Number of installments: 3

```

**Expected Output:**
```

Installments:
25/07/2018 - 206.04
25/08/2018 - 208.08
25/09/2018 - 210.12

````

---

## 🧠 How It Works

The logic follows the **principles of OOP and interfaces**:

1. The main class (`Program.java`) receives user input (contract data).  
2. It creates a `Contract` object and sends it to `ContractService`.  
3. The `ContractService` uses an `OnlinePaymentService` (in this case, `PaypalService`) to calculate:
   - **Interest:** 1% * month  
   - **Payment Fee:** 2% of the updated amount  
4. Each calculated installment is stored in the contract list as an `Installment` object with:
   - Due date (`LocalDate.plusMonths(i)`)  
   - Final value with interest and fee  
5. The final list of installments is displayed on the screen.

### Sequence Overview

```text
Program → ContractService → OnlinePaymentService (PaypalService)
````

### Formula Used

```
basicQuota = totalValue / months
updatedQuota = basicQuota + basicQuota * 1% * month
finalQuota = updatedQuota + updatedQuota * 2%
```

---

## 🗂️ Project Structure

```
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
 └── README.md
```

---

## 🧩 Key Concepts

* **Interface** defines a *contract* (`OnlinePaymentService`)
* **Polymorphism** allows different implementations (e.g. `PaypalService`)
* **Dependency Injection** decouples the service from the logic
* **Encapsulation & Composition** used in `Contract` and `Installment`
* **`java.time` API** manages dates cleanly (`LocalDate`, `plusMonths`)

---

## 🧪 How to Run

1. Clone the repo:

   ```bash
   git clone git@github.com:josivantarcio/Contract-Installment-System.git
   cd Contract-Installment-System
   ```

2. Compile:

   ```bash
   javac -d bin src/**/*.java
   ```

3. Run:

   ```bash
   java -cp bin app.Program
   ```

4. Enter contract details when prompted.

---

## 📚 Technologies Used

* Java 21+
* Object-Oriented Programming (OOP)
* `java.time` API
* Interfaces & Polymorphism
* Command Line I/O

---

## 👤 Author

Developed by **Josevan Oliveira**
💼 Full Stack Developer Junior Java | Data Scientist
🔗 [GitHub Profile](https://github.com/josivantarcio)

---

## 📄 License

This project is licensed under the **MIT License** — see the `LICENSE` file for details.

```

---

### ✅ Próximo passo:

Salve esse conteúdo no seu arquivo:
```

~/ws/java/processamento-contrato/README.md

````

Depois, rode os comandos abaixo para atualizar no GitHub:

```bash
git add README.md
git commit -m "Add How It Works section to README"
git push origin main
````
