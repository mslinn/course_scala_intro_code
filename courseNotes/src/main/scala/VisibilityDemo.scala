package com.micronautics.scalaJava

class Public {
  val aPublicProperty = 0;
  protected val aProtectedProperty = 0;
  protected[scalaJava] val aProtectedPackageProperty = 0;
  protected[Public] val aProtectedClassProperty = 0;
  protected[this] val aProtectedThisProperty = 0;
  private val aPrivateProperty = 0; // not visible from Java
  private[scalaJava] val aPrivateClassProperty = 0;
  private[this] val aPrivateThisProperty = 0; // not visible from Java

  class PublicInPublicClass
  protected[scalaJava] class ProtectedPackageInPublicClass
  protected[Public] class ProtectedClassInPublicClass
  protected[this] class ProtectedThisInPublicClass
  private[scalaJava] class PrivatePackageInPublicClass
  private[this] class PrivateThisInPublicClass
}

protected class Protected {
  val aPublicProperty = 0;
  protected val aProtectedProperty = 0;
  protected[scalaJava] val aProtectedPackageProperty = 0;
  //protected[ClassName] val aProtectedClassProperty = 0; // can only be used in an inner class; see below for example
  protected[this] val aProtectedThisProperty = 0;
  private val aPrivateProperty = 0; // not visible from Java
  private[scalaJava] val aPrivateClassProperty = 0;
  private[this] val aPrivateThisProperty = 0; // not visible from Java

  class PublicInProtectedClass
  protected[scalaJava] class ProtectedPackageInProtectedClass
  protected[Protected] class ProtectedClassInProtectedClass
  protected[this] class ProtectedThisInProtectedClass
  private[scalaJava] class PrivatePackageInProtectedClass
  private[this] class PrivateThisInProtectedClass
}

protected[scalaJava] class ProtectedPackage {
  val aPublicProperty = 0;
  protected val aProtectedProperty = 0;
  protected[scalaJava] val aProtectedPackageProperty = 0;
  //protected[ClassName] val aProtectedClassProperty = 0; // can only be used in an inner class; see below for example
  protected[this] val aProtectedThisProperty = 0;
  private val aPrivateProperty = 0;
  private[scalaJava] val aPrivateClassProperty = 0;
  private[this] val aPrivateThisProperty = 0; // not visible from Java

  class PublicInProtectedPackageClass
  protected[scalaJava] class ProtectedPackageInProtectedPackageClass
  protected[ProtectedPackage] class ProtectedClassInProtectedPackageClass
  protected[this] class ProtectedThisInProtectedPackageClass
  private[scalaJava] class PrivatePackageInProtectedPackageClass
  private[this] class PrivateThisInProtectedPackageClass
}

class EnclosingClass {
  protected[EnclosingClass] class ProtectedInnerClass {
    protected[ProtectedInnerClass] class ProtectedClassInProtectedClass

    val aPublicProperty = 0;
    protected val aProtectedProperty = 0;
    protected[scalaJava] val aProtectedPackageProperty = 0;
    //protected[ClassName] val aProtectedClassProperty = 0; // can only be used in an inner class; see below for example
    protected[this] val aProtectedThisProperty = 0;
    private val aPrivateProperty = 0;
    private[scalaJava] val aPrivateClassProperty = 0;
    private[this] val aPrivateThisProperty = 0; // not visible from Java

    class PublicInProtectedInnerClass
    protected[scalaJava] class ProtectedPackageInProtectedInnerClass
    protected[ProtectedInnerClass] class ProtectedClassInProtectedInnerClass
    protected[this] class ProtectedThisInProtectedInnerClass
    private[scalaJava] class PrivatePackageInProtectedInnerClass
    private[this] class PrivateThisInProtectedInnerClass
  }
}

protected[this] class ProtectedThis {
  val aPublicProperty = 0;
  protected val aProtectedProperty = 0;
  protected[scalaJava] val aProtectedPackageProperty = 0;
  protected[ProtectedThis] val aProtectedClassProperty = 0;
  protected[this] val aProtectedThisProperty = 0;
  private val aPrivateProperty = 0; // not visible from Java
  private[scalaJava] val aPrivateClassProperty = 0;
  private[this] val aPrivateThisProperty = 0; // not visible from Java

  class PublicInProtectedThisClass
  protected[scalaJava] class ProtectedPackageInProtectedThisClass
  protected[ProtectedThis] class ProtectedClassInProtectedThisClass
  protected[this] class ProtectedThisInProtectedThisClass
  private[scalaJava] class PrivatePackageInProtectedThisClass
  private[this] class PrivateThisInProtectedThisClass
}

private class Private

private[scalaJava] class PrivatePackage {
  val aPublicProperty = 0;
  protected val aProtectedProperty = 0;
  protected[scalaJava] val aProtectedPackageProperty = 0;
  protected[PrivatePackage] val aProtectedClassProperty = 0;
  protected[this] val aProtectedThisProperty = 0;
  private val aPrivateProperty = 0; // not visible from Java
  private[scalaJava] val aPrivateClassProperty = 0;
  private[this] val aPrivateThisProperty = 0; // not visible from Java

  class PublicInPrivatePackageClass
  protected[PrivatePackage] class ProtectedClassInPrivatePackageClass
  protected[scalaJava] class ProtectedPackageInPrivatePackageClass
  protected[this] class ProtectedThisInPrivatePackageClass
  private[scalaJava] class PrivatePackageInPrivatePackageClass
  private[this] class PrivateThisInPrivatePackageClass
}

private[this] class PrivateThis {
  val aPublicProperty = 0;
  protected val aProtectedProperty = 0;
  protected[scalaJava] val aProtectedPackageProperty = 0;
  protected[PrivateThis] val aProtectedClassProperty = 0;
  protected[this] val aProtectedThisProperty = 0;
  private val aPrivateProperty = 0; // not visible from Java
  private[scalaJava] val aPrivateClassProperty = 0;
  private[this] val aPrivateThisProperty = 0; // not visible from Java

  class PublicInPrivateThisClass
  protected[scalaJava] class ProtectedPackageInPrivateThisClass
  protected[PrivateThis] class ProtectedClassInPrivateThisClass
  protected[this] class ProtectedThisInPrivateThisClass
  private[scalaJava] class PrivatePackageInPrivateThisClass
  private[this] class PrivateThisInPrivateThisClass
}

sealed class Sealed

object x extends App {
  val publicInstance = new Public
  val publicInPublicInstance = new publicInstance.PublicInPublicClass
  println(publicInPublicInstance)
}