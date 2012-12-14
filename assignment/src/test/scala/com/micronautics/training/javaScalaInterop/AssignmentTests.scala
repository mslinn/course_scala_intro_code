package com.micronautics.training.javaScalaInterop

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.{BeforeAndAfterAll, WordSpec}
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class AssignmentTests extends ShouldMatchers with WordSpec with BeforeAndAfterAll {
  
  "Minors" should {
    "be younger than 18" in {
      // your test code here
    }
  }

  "Adults" should {
    "be 18 or older" in {
      // your test code here
    }
  }
}