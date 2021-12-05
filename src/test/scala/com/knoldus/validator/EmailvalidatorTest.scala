package com.knoldus.validator
import org.scalatest.funsuite.AnyFunSuite
class EmailvalidatorTest extends AnyFunSuite{
  val emailValidator = new Emailvalidator
  test(testName="Email is invalid without recipient name"){
    assert(!emailValidator.emailIdIsValid(emailId="@gmail.com"))
  }

  test(testName="Email is not valid if it not contains @ character"){
    assert(!emailValidator.emailIdIsValid(emailId="@amankumar.rsd.gmail.com"))
  }

  test(testName="Email should be invalid if it doesn't contain domain name"){
    assert(!emailValidator.emailIdIsValid(emailId="amankumar@"))
  }
  test(testName="Email should not valid if it doesn't contain .com,.org, or .net"){
    assert(!emailValidator.emailIdIsValid(emailId="aman@gmail"))
  }
  test(testName="Email should valid if it contani all required parameters"){
    assert(emailValidator.emailIdIsValid(emailId="aman.kumar@gmail.com"))
  }
}
