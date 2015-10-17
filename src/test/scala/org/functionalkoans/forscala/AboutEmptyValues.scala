package org.functionalkoans.forscala

import support.KoanSuite

// ================================================================================================
// My notes:
// == : same as equals in java but handle null properly.
//      => when overloading equality, overload equals() not ==.
// eq : test for reference equality
// 
// === : From ScalaTest, TripleEquals, which gives you a === operator that allows you to customize 
//       Equality and perform equality checks with a numeric Tolerance. You can also use === to 
//       enforce type constraints at compile time with sibling traits TypeCheckedTripleEquals 
//       and ConversionCheckedTripleEquals.
//       http://doc.scalatest.org/2.2.4/#org.scalactic.TripleEquals
// The method assert() is not the default one from Scala but the one from ScalaTest.
// 
// Any, AnyRef, AnyVal:
// - http://docs.scala-lang.org/tutorials/tour/unified-types.html
// ================================================================================================
class AboutEmptyValues extends KoanSuite {

  koan("None equals None") {
    assert(None === None)
  }

  koan("None should be identical to None") {
    val a = None
    val b = None
    assert(a eq b)
  }

  koan("None can be converted to a String") {
    assert(None.toString === "None")
  }

  koan("An empty list can be represented by another nothing value: Nil") {
    assert(List() === Nil)
  }

  koan("None can be converted to an empty list") {
    val a = None
    assert(a.toList === Nil)
  }

  koan("None is considered empty") {
    assert(None.isEmpty === true)
  }

  koan("None can be cast Any, AnyRef or AnyVal") {
    assert(None.asInstanceOf[Any] === None)
    assert(None.asInstanceOf[AnyRef] === None)
    assert(None.asInstanceOf[AnyVal] === None)
  }

  koan("None cannot be cast to all types of objects") {
    intercept[ClassCastException] {
      // put the exception you expect to see in place of the blank
      assert(None.asInstanceOf[String] === new ClassCastException)
    }
  }

  koan("None can be used with Option instead of null references") {
    val optional: Option[String] = None
    assert(optional.isEmpty === true)
    assert(optional === None)
  }

  koan("Some is the opposite of None for Option types") {
    val optional: Option[String] = Some("Some Value")
    assert((optional == None) === false, "Some(value) should not equal None")
    assert(optional.isEmpty === false, "Some(value) should not be empty")
  }

  koan("Option.getOrElse can be used to provide a default in the case of None") {
    val optional: Option[String] = Some("Some Value")
    val optional2: Option[String] = None
    assert(optional.getOrElse("No Value") === "Some Value", "Should return the value in the option")
    assert(optional2.getOrElse("No Value") === "No Value", "Should return the specified default value")
  }
}
