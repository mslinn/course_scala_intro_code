val object1 = Some("Hi there")
val object2 = None
Option(System.getProperty("os.name"))
Option(System.getProperty("os.name")).get
Option(System.getProperty("not.present"))
Option(System.getProperty("not.present")).getOrElse("default")
Option(System.getProperty("not.present")).getOrElse(Some("default"))
Option(System.getProperty("not.present")).getOrElse(Some("default")).get

