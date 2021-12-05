package com.knoldus.db

import org.scalatest.funsuite.AnyFunSuite

class CompanyreadtoTest extends AnyFunSuite {
  val companyReadTo = new Companyreadto()

  test(testName="Check if company exists in DB"){
    val companyName = "Knoldus"
    val result = companyReadTo.getCompanyByName(companyName)
    assert(result.isDefined)
  }


  test(testName="Company should not exist in DB"){
    val companyName = "TCS"
    val result = companyReadTo.getCompanyByName(companyName)
    assert(result.isEmpty)
  }

}
