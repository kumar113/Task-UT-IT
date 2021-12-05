package com.knoldus.request
import com.knoldus.models.Company
import com.knoldus.validator.Companyvalidator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.funsuite.AnyFunSuite

class CompanyimplTest extends AnyFunSuite{
    val companyValidator = mock[Companyvalidator]
    val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")

  test(testName="Company should be created"){
    val companyImpl = new Companyimpl(companyValidator)
    when(companyValidator.companyIsValid(knoldusCompany)) thenReturn(true)
    val result = companyImpl.createCompany(knoldusCompany)
    assert(result.isDefined)
  }

}
