package com.knoldus.validator
import com.knoldus.db.Companyreadto
import com.knoldus.models.Company
import org.scalatest.funsuite.AnyFunSuite
import org.mockito.MockitoSugar.{mock, when}

class CompanyvalidatorTest extends AnyFunSuite {
  val knoldusCompany:Company = Company("Knoldus","knoldus@gmail.com","Noida")
  val companyRead = mock[Companyreadto]
  val emailValidator = mock[Emailvalidator]
  val companyValidator = new Companyvalidator(companyRead,emailValidator)

  test(testName=" company should valid"){
    when(companyRead.getCompanyByName(knoldusCompany.name)).thenReturn(None)
    when(emailValidator.emailIdIsValid(knoldusCompany.emailId)).thenReturn(true)
    val result = companyValidator.companyIsValid(knoldusCompany)
    assert(result)
  }
  test(testName="check if company already exists in DB"){
    when(companyRead.getCompanyByName(knoldusCompany.name)).thenReturn(Option(knoldusCompany))
    when(emailValidator.emailIdIsValid(knoldusCompany.emailId)).thenReturn(true)
    val result = companyValidator.companyIsValid(knoldusCompany)
    assert(!result)
  }
  test(testName="company is invalid as email is not valid"){

    when(companyRead.getCompanyByName(knoldusCompany.name)).thenReturn(None)
    when(emailValidator.emailIdIsValid(knoldusCompany.emailId)).thenReturn(false)
    val result = companyValidator.companyIsValid(knoldusCompany)
    assert(!result)
  }
  test(testName="Company is invalid as the email id is not valid and it already exists in the DB"){
    when(companyRead.getCompanyByName(knoldusCompany.name)) thenReturn(Option(knoldusCompany))
    when(emailValidator.emailIdIsValid(knoldusCompany.emailId)) thenReturn(false)
    val result = companyValidator.companyIsValid(knoldusCompany)
    assert(!result)
  }
}
