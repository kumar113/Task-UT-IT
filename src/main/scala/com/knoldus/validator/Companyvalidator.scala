package com.knoldus.validator

import com.knoldus.db.Companyreadto
import com.knoldus.models.Company



class Companyvalidator(companyName:Companyreadto, validateEmail: Emailvalidator) {

  def companyIsValid(company: Company): Boolean = {
    if(companyName.getCompanyByName(company.name).isEmpty  && validateEmail.emailIdIsValid(company.emailId)){
      true
    }
    else
      false
  }
}

