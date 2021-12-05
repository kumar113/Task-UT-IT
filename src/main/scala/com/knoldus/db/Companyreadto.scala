package com.knoldus.db
import com.knoldus.models.Company
import scala.collection.immutable.HashMap

class Companyreadto {

  val knoldusCompany: Company = Company("Knoldus", "Knoldus@gmail.com", "Noida")
  val googleCompany: Company = Company("Google", "google1512@gmail.com", "Noida")
  val companies: HashMap[String, Company] = HashMap("Knoldus" -> knoldusCompany, "Google" -> googleCompany)
  def getCompanyByName(name: String): Option[Company] = companies.get(name)
}



