package com.knoldus.request

import com.knoldus.db.Companyreadto
import com.knoldus.models.Employee
import com.knoldus.validator.{Emailvalidator, Employeevalidator}
import org.scalatest.funsuite.AnyFunSuite

class EmployeeimplintegrationTest extends AnyFunSuite {

  val companyName = new Companyreadto
  val validateEmail = new Emailvalidator
  val employeeValidator = new Employeevalidator(companyName, validateEmail)
  val employeeImpl = new EmployeeImpl(employeeValidator)



  test(testName="User cannot be created because company does not exist"){
    val nishant: Employee = new Employee(firstName="Nishant", lastName= "Kumar", age=23, salary=10000,designation= "Intern",companyName="TCS", emailId="nishant.kumar@gmail.com")
    val result = employeeImpl.createEmployee(nishant)
    assert(result.isEmpty)
  }

  test(testName="User not created because email is invalid"){
    val Aman: Employee = new Employee(firstName="Aman",lastName= "Kumar",age= 21,salary= 15000,designation= "Intern", companyName="Knoldus",emailId= "aman.kumar@gmailcom")
    val result = employeeImpl.createEmployee(Aman)
    assert(result.isEmpty)
  }

  test(testName="User cannot be created because email is invalid and company does not exist in DB"){
    val nishant: Employee = new Employee(firstName="Nishant", lastName="Kumar", age=23,salary= 10000,designation= "Intern",companyName= "TCS",emailId="Nishant.kumar@gmalcom")
    val result = employeeImpl.createEmployee(nishant)
    assert(result.isEmpty)
  }

  test(testName="User can be created"){
    val Aman: Employee = new Employee(firstName="Aman",lastName= "Kumar",age= 21,salary= 15000,designation= "Intern",companyName= "Knoldus",emailId= "aman.kumar@gmail.com")
    val result = employeeImpl.createEmployee(Aman)
    assert(result.isDefined)
  }

}

