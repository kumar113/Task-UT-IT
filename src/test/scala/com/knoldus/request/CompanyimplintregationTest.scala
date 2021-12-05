package com.knoldus.request
import com.knoldus.models.Company
import com.knoldus.db.Companyreadto
import com.knoldus.validator.{Companyvalidator, Emailvalidator}
import org.scalatest.funsuite.AnyFunSuite


class CompanyimplintregationTest extends AnyFunSuite {
      val companyName = new Companyreadto
      val validateEmail = new Emailvalidator
      val companyValidator = new Companyvalidator(companyName,validateEmail)


  test("Company should not be created as already exist in DB"){
    val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")
    val companyImpl = new Companyimpl(companyValidator)
    val result = companyImpl.createCompany(knoldusCompany)
    assert(result.isEmpty)
  }
  test("Company should not be created as email ID is invalid"){
    val TcsCompany: Company = Company("TCS", "tcs@tcscm", "Noida")
    val companyImpl = new Companyimpl(companyValidator)
    val result = companyImpl.createCompany(TcsCompany)
    assert(result.isEmpty)
  }

  test(testName="Cannot be created as email is invalid and already exist in DB"){
    val knoldusCompany: Company = Company("Knoldus", "knoldus@gmailcom", "Noida")
    val companyImpl = new Companyimpl(companyValidator)
    val result = companyImpl.createCompany(knoldusCompany)
    assert(result.isEmpty)
  }

  test(testName="Company can be created"){
    val tcsCompany: Company = Company("TCS", "tcs@gmail.com", "Mumbai")
    val companyImpl = new Companyimpl(companyValidator)
    val result = companyImpl.createCompany(tcsCompany)
    assert(result.isDefined)
  }

}
