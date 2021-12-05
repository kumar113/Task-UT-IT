package com.knoldus.validator

class Emailvalidator {

  def emailIdIsValid(emailId: String): Boolean = {
    if("""^([a-zA-Z\d\.-]+)@([a-zA-Z\d-]+)\.(com|net|org)$""".r.findFirstIn(emailId).isEmpty)
      false
    else
      true
  }

}

