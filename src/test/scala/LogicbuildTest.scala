import com.Problemoneandtwo.cal.Logicbuild
import org.scalatest.funsuite.AnyFunSuite


class LogicbuildTest extends AnyFunSuite {
  var LogicFile_Object = new Logicbuild()


  //  **************************FIBONACCI TEST *************************

  test(testName="Test to check fibonacci of zero"){
    val num = 0
    val res = 0
    assert(LogicFile_Object.fibonacciOf(num)==res)
  }
  test(testName="To check fibonacci"){
    val num = 9
    val res = 34
    assert(LogicFile_Object.fibonacciOf(num)==res)
  }

  //  ******************************** DIVISION TEST *********************************

  test(testName="Test to check divison of zero"){
    val num1 = 0
    val num2 = 2
    val res = 0
    assert(LogicFile_Object.divisionOf(num1, num2)==res)
  }

  test(testName="Test to check division by zero"){
    assertThrows[ArithmeticException](LogicFile_Object.divisionOf(num1=163,num2=0))
  }


}
