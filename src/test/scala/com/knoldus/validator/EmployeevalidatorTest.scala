package com.knoldus.validator
import com.knoldus.db.Companyreadto
import com.knoldus.models.{Company, Employee}
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.funsuite.AnyFunSuite

class EmployeevalidatorTest extends AnyFunSuite {
  val employee = new Employee(firstName ="Aman" , lastName = "Kumar",age = 21,salary =15000, designation="Intern" ,companyName="knoldus",emailId="aman.kumar@knoldus.com")
  val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")
  val companyRead = mock[Companyreadto]
  val emailValidator = mock[Emailvalidator]
  val employeeValidator = new Employeevalidator(companyRead,emailValidator)

  test(testName="Employee should valid"){
    when(companyRead.getCompanyByName(employee.companyName)).thenReturn(Option(knoldusCompany))
    when(emailValidator.emailIdIsValid(employee.emailId)).thenReturn(true)
    val result = employeeValidator.employeeIsValid(employee)
    assert(result)
  }
  test(testName="Employee is not valid bcz of his email is invalid"){
    when(companyRead.getCompanyByName(employee.companyName)).thenReturn(Option(knoldusCompany))
    when(emailValidator.emailIdIsValid(employee.emailId)).thenReturn(false)
    val result = employeeValidator.employeeIsValid(employee)
    assert(!result)
  }
  test(testName="Employee is not valid bcz his company not exist in DB"){
    when(companyRead.getCompanyByName(employee.companyName)).thenReturn(None)
    when(emailValidator.emailIdIsValid(employee.emailId)).thenReturn(true)
    val result = employeeValidator.employeeIsValid(employee)
    assert(!result)
  }
  test(testName="Employee is not valid bcz his company not exist in DB and email is not valid"){
    when(companyRead.getCompanyByName(employee.companyName)).thenReturn(None)
    when(emailValidator.emailIdIsValid(employee.emailId)).thenReturn(false)
    val result = employeeValidator.employeeIsValid(employee)
    assert(!result)
  }
}
