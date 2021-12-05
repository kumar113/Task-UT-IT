package com.knoldus.request

import com.knoldus.models.Employee

import com.knoldus.validator.Employeevalidator


class EmployeeImpl(employeevalidator: Employeevalidator) {

  def createEmployee(employee: Employee): Option[String] = {
    if (employeevalidator.employeeIsValid(employee)) Option(employee.emailId)
    else None
  }

}



