object eclipseWorksheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(36); 
	val y = 1;System.out.println("""y  : Int = """ + $show(y ));$skip(48); 
	val classWithCompanion = ClassWithCompanion(y);System.out.println("""classWithCompanion  : ClassWithCompanion = """ + $show(classWithCompanion ));$skip(31); 
	println(classWithCompanion.x)}
}
