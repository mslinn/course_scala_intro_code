import java.nio.file.Path

object ADT1 extends App {
  sealed trait Index
  class LecturesIndex extends Index
  class SectionsIndex extends Index
  class CoursesIndex  extends Index
  class GroupsIndex   extends Index
  class SitesIndex    extends Index

  def showEm(index: Index): Index = index match {
    case si: SitesIndex =>
      println(si)
      si

    case gi: GroupsIndex =>
      println(gi)
      gi

    case ci: CoursesIndex =>
      println(ci)
      ci

    case si: SectionsIndex =>
      println(si)
      si

    case li: LecturesIndex =>
      println(li)
      li
  }

  showEm(new LecturesIndex)
  showEm(new SectionsIndex)
}


object ADT2 extends App {
  sealed trait Index {
    def show(): Index = {
      println(this)
      this
    }
  }

  class LecturesIndex extends Index {
    def lectureMethod1: LecturesIndex = {
      println("LectureMethod1")
      this
    }
  }

  class SectionsIndex extends Index {
    def sectionMethod1: SectionsIndex = {
      println("SectionMethod1")
      this
    }
  }

  class CoursesIndex  extends Index

  class GroupsIndex   extends Index

  class SitesIndex    extends Index

  def showEm(index: Index): Index = index match {
    case si: SitesIndex    => si.show()
    case gi: GroupsIndex   => gi.show()
    case ci: CoursesIndex  => ci.show()
    case si: SectionsIndex => si.show()
    case li: LecturesIndex => li.show()
  }

  new LecturesIndex().show().asInstanceOf[LecturesIndex].lectureMethod1
  new SectionsIndex().show().asInstanceOf[SectionsIndex].sectionMethod1

  showEm(new LecturesIndex).asInstanceOf[LecturesIndex].lectureMethod1
  showEm(new SectionsIndex).asInstanceOf[SectionsIndex].sectionMethod1
}


object ADT3 {
  sealed trait Index {
    def show(): this.type = {
      println(this)
      this
    }
  }

  class LecturesIndex extends Index {
    def lectureMethod1: LecturesIndex = {
      println("LectureMethod1")
      this
    }
  }

  class SectionsIndex extends Index {
    def sectionMethod1: SectionsIndex = {
      println("SectionMethod1")
      this
    }
  }

  class CoursesIndex extends Index

  class GroupsIndex extends Index

  class SitesIndex extends Index

  def showEm(index: Index): Index = index match {
    case si: SitesIndex    => si.show()
    case gi: GroupsIndex   => gi.show()
    case ci: CoursesIndex  => ci.show()
    case si: SectionsIndex => si.show()
    case li: LecturesIndex => li.show()
  }

  new LecturesIndex().show().lectureMethod1
  new SectionsIndex().show().sectionMethod1

  showEm(new LecturesIndex).asInstanceOf[LecturesIndex].lectureMethod1
  showEm(new SectionsIndex).asInstanceOf[SectionsIndex].sectionMethod1
}
