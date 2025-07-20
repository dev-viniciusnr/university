#include <iostream>
#include <iomanip>
#include "account.h"
using namespace std;

// O construtor já está construído.
Account::Account(int no, double b) : accountNumber(no), balance(b) { }


/*
  A função print também já está implementada.
 */
void Account::print() const {
  cout << fixed << setprecision(2);
  cout << "A/C no: " << accountNumber << " Balance=R$" << balance << endl;
}


int Account::getAccountNumber() const {
  // ToDo: implemente o método
}


double Account::getBalance() const {
  // ToDo: implemente o método
}


void Account::setBalance(double b) {
  // ToDo: implemente o método
}

/*
  Não esqueça que amount deve ser positivo.
 */

void Account::credit(double amount) {
  // ToDo: implemente o método
}

/*
  Não esqueça que a nossa conta corrente não pode ficar negativa.
 */
void Account::debit(double amount) {
  // ToDo: implemente o método
}


