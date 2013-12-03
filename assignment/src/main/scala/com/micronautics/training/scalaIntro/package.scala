package com.micronautics.training.scalaIntro

package object assignment {

  case class Person(val name: String, val age: Int) {
    override def toString = "%s is %d years old".format(name, age)
  }

}
