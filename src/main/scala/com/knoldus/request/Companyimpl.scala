package com.knoldus.request
import com.knoldus.models.Company


import com.knoldus.validator.Companyvalidator

class Companyimpl(companyvalidator: Companyvalidator) {


  def createCompany(company: Company): Option[String] = {
    if (companyvalidator.companyIsValid(company)) {
      println("=>Company ='"+company.name+"' is created successfully!")
      Option(company.name)
    }

    else {
      println("=>Company ='"+company.name+"' can not be not created")
      None
    }
  }

}

