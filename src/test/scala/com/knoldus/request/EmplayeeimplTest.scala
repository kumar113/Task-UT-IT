package com.knoldus.request
import com.knoldus.models.Employee
import com.knoldus.validator.Employeevalidator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.funsuite.AnyFunSuite
class EmplayeeimplTest extends AnyFunSuite {
  val employeeValidator = mock[Employeevalidator]
  val Aman:Employee = new Employee(firstName="Aman",lastName="Kumar",age=21,salary=15000,designation="Intern",companyName="Knoldus",emailId="aman.kumar@gmail.com")
  val userImpl = new EmployeeImpl(employeeValidator)

    test(testName="User can be ceated"){
      when(employeeValidator.employeeIsValid(Aman)) thenReturn(true)
      val result = userImpl.createEmployee(Aman)
      assert(result.isDefined)
    }
    test(testName="User can not be created"){
      when(employeeValidator.employeeIsValid(Aman)) thenReturn(false)
      val result = userImpl.createEmployee(Aman)
      assert(result.isEmpty)
    }

}
