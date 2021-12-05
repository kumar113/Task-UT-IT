import com.Problemoneandtwo.emailvalidator.emailvalidator
import org.scalatest.funsuite.AnyFunSuite

class EmailvalidatorTest extends AnyFunSuite {
  var emailObject = new emailvalidator

  test(testName="Without name of recipient"){
    assert(!emailObject.emailIsValid(emailId="@gmail.com"))
  }

  test(testName="Without domain name"){
    assert(!emailObject.emailIsValid(emailId="Nishant.kumar@"))
  }

  test(testName="Without @ in the email"){
    assert(!emailObject.emailIsValid(emailId="Nishant.kumar.gmail.com"))
  }

  test(testName="Other domain name than .com| .net| .org "){
    assert(!emailObject.emailIsValid(emailId="Nishant.kumar@rediffmail.in"))
  }

  test(testName="correct one uppercase"){
    assert(emailObject.emailIsValid(emailId="NISHANT.KUMAR@REDIFFMAIL.COM"))
  }

  test(testName="Correct one lowercase"){
    assert(emailObject.emailIsValid(emailId="nishant.kumar@rediffmail.com"))
  }

}
