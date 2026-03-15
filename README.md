# Banking System API

A RESTful Banking System built using Spring Boot that allows users to create accounts, deposit money, withdraw funds, check balances, and view transaction history.

## Tech Stack
- Java
- Spring Boot
- MySQL
- Maven
- Postman (for API testing)

## Features
- Create a bank account
- Deposit money
- Withdraw money
- Check account balance
- View transaction history

## API Endpoints

Create Account
POST /bank/create

Deposit Money
POST /bank/deposit/{id}?amount=500

Withdraw Money
POST /bank/withdraw/{id}?amount=200

Check Balance
GET /bank/balance/{id}

View Transactions
GET /bank/transactions/{id}

## How to Run

1. Clone the repository
2. Open the project in IntelliJ
3. Configure MySQL in application.properties
4. Run the Spring Boot application
5. Test APIs using Postman

## Author
Trisha Sadhukhan
