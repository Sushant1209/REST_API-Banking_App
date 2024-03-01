# Banking REST API

**Project Description**

This REST API provides basic banking operations for managing accounts, deposits, and withdrawals.

**Features**

* **Account Creation:** Create new bank accounts.
* **Account Deletion:** Close existing bank accounts.
* **Deposits:** Add funds to an account.
* **Withdrawals:** Remove funds from an account. 

**Technologies Used**

* **Spring Boot** 
* **Spring Data JPA (Hibernate)**
* **MySQL** 

**API Endpoints**

| Endpoint          | Method | Description                                       |
| ----------------- | ------ | ------------------------------------------------- |
| `/api/accounts`   | POST   | Creates a new bank account                        |
| `/api/accounts/{id}` | DELETE | Deletes a bank account by its ID                      |
| `/api/accounts/{id}/deposit`  | POST   | Adds funds to a specified account                 |
| `/api/accounts/{id}/withdrawal` | POST   | Removes funds from a specified account            |

**Request/Response Formats**

* Requests and responses use JSON format.
* **Example Request/Response (Account Creation):** 

```json
// Request Body
{
  "accountHolderName": "Jane Doe",
  "initialBalance": 500.00
}

// Response Body
{
  "accountId": 1,
  "accountHolderName": "Jane Doe",
  "balance": 500.00
}
