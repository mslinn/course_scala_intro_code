// Notice that the package name does not correspond to the directory structure. This is allowed in Scala.

package com.micronautics.scalaIntro

class Public {
  val aPublicProperty = 0
  protected val aProtectedProperty = 0
  protected[scalaIntro] val aProtectedPackageProperty = 0
  protected[Public] val aProtectedClassProperty = 0
  protected[this] val aProtectedThisProperty = 0
  private val aPrivateProperty = 0
  private[scalaIntro] val aPrivateClassProperty = 0
  private[this] val aPrivateThisProperty = 0

  class PublicInPublicClass
  protected[scalaIntro] class ProtectedPackageInPublicClass
  protected[Public] class ProtectedClassInPublicClass
  protected[this] class ProtectedThisInPublicClass
  private[scalaIntro] class PrivatePackageInPublicClass
  private[this] class PrivateThisInPublicClass
}

protected class Protected {
  val aPublicProperty = 0
  protected val aProtectedProperty = 0
  protected[scalaIntro] val aProtectedPackageProperty = 0
  //protected[ClassName] val aProtectedClassProperty = 0 // can only be used in an inner class; see below for example
  protected[this] val aProtectedThisProperty = 0
  private val aPrivateProperty = 0
  private[scalaIntro] val aPrivateClassProperty = 0
  private[this] val aPrivateThisProperty = 0

  class PublicInProtectedClass
  protected[scalaIntro] class ProtectedPackageInProtectedClass
  protected[Protected] class ProtectedClassInProtectedClass
  protected[this] class ProtectedThisInProtectedClass
  private[scalaIntro] class PrivatePackageInProtectedClass
  private[this] class PrivateThisInProtectedClass
}

protected[scalaIntro] class ProtectedPackage {
  val aPublicProperty = 0
  protected val aProtectedProperty = 0
  protected[scalaIntro] val aProtectedPackageProperty = 0
  //protected[ClassName] val aProtectedClassProperty = 0 // can only be used in an inner class; see below for example
  protected[this] val aProtectedThisProperty = 0
  private val aPrivateProperty = 0
  private[scalaIntro] val aPrivateClassProperty = 0
  private[this] val aPrivateThisProperty = 0

  class PublicInProtectedPackageClass
  protected[scalaIntro] class ProtectedPackageInProtectedPackageClass
  protected[ProtectedPackage] class ProtectedClassInProtectedPackageClass
  protected[this] class ProtectedThisInProtectedPackageClass
  private[scalaIntro] class PrivatePackageInProtectedPackageClass
  private[this] class PrivateThisInProtectedPackageClass
}

class EnclosingClass {
  protected[EnclosingClass] class ProtectedInnerClass {
    protected[ProtectedInnerClass] class ProtectedClassInProtectedClass

    val aPublicProperty = 0
    protected val aProtectedProperty = 0
    protected[scalaIntro] val aProtectedPackageProperty = 0
    //protected[ClassName] val aProtectedClassProperty = 0 // can only be used in an inner class; see below for example
    protected[this] val aProtectedThisProperty = 0
    private val aPrivateProperty = 0
    private[scalaIntro] val aPrivateClassProperty = 0
    private[this] val aPrivateThisProperty = 0

    class PublicInProtectedInnerClass
    protected[scalaIntro] class ProtectedPackageInProtectedInnerClass
    protected[ProtectedInnerClass] class ProtectedClassInProtectedInnerClass
    protected[this] class ProtectedThisInProtectedInnerClass
    private[scalaIntro] class PrivatePackageInProtectedInnerClass
    private[this] class PrivateThisInProtectedInnerClass
  }
}

protected[this] class ProtectedThis {
  val aPublicProperty = 0
  protected val aProtectedProperty = 0
  protected[scalaIntro] val aProtectedPackageProperty = 0
  protected[ProtectedThis] val aProtectedClassProperty = 0
  protected[this] val aProtectedThisProperty = 0
  private val aPrivateProperty = 0
  private[scalaIntro] val aPrivateClassProperty = 0
  private[this] val aPrivateThisProperty = 0

  class PublicInProtectedThisClass
  protected[scalaIntro] class ProtectedPackageInProtectedThisClass
  protected[ProtectedThis] class ProtectedClassInProtectedThisClass
  protected[this] class ProtectedThisInProtectedThisClass
  private[scalaIntro] class PrivatePackageInProtectedThisClass
  private[this] class PrivateThisInProtectedThisClass
}

private class Private

private[scalaIntro] class PrivatePackage {
  val aPublicProperty = 0
  protected val aProtectedProperty = 0
  protected[scalaIntro] val aProtectedPackageProperty = 0
  protected[PrivatePackage] val aProtectedClassProperty = 0
  protected[this] val aProtectedThisProperty = 0
  private val aPrivateProperty = 0
  private[scalaIntro] val aPrivateClassProperty = 0
  private[this] val aPrivateThisProperty = 0

  class PublicInPrivatePackageClass
  protected[PrivatePackage] class ProtectedClassInPrivatePackageClass
  protected[scalaIntro] class ProtectedPackageInPrivatePackageClass
  protected[this] class ProtectedThisInPrivatePackageClass
  private[scalaIntro] class PrivatePackageInPrivatePackageClass
  private[this] class PrivateThisInPrivatePackageClass
}

private[this] class PrivateThis {
  val aPublicProperty = 0
  protected val aProtectedProperty = 0
  protected[scalaIntro] val aProtectedPackageProperty = 0
  protected[PrivateThis] val aProtectedClassProperty = 0
  protected[this] val aProtectedThisProperty = 0
  private val aPrivateProperty = 0
  private[scalaIntro] val aPrivateClassProperty = 0
  private[this] val aPrivateThisProperty = 0

  class PublicInPrivateThisClass
  protected[scalaIntro] class ProtectedPackageInPrivateThisClass
  protected[PrivateThis] class ProtectedClassInPrivateThisClass
  protected[this] class ProtectedThisInPrivateThisClass
  private[scalaIntro] class PrivatePackageInPrivateThisClass
  private[this] class PrivateThisInPrivateThisClass
}

object VisibleMain extends App {
  val publicInstance = new Public
  val publicInPublicInstance = new publicInstance.PublicInPublicClass
  println("All done!")
}
