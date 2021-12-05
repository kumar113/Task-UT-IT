package com.knoldus.validator

import com.knoldus.db.Companyreadto
import com.knoldus.models.Employee

class Employeevalidator(companyName: Companyreadto, validateEmail: Emailvalidator) {

  def employeeIsValid(employee: Employee): Boolean = {

    if(companyName.getCompanyByName(employee.companyName).isDefined && validateEmail.emailIdIsValid(employee.emailId))
      true
    else
      false
  }
}

