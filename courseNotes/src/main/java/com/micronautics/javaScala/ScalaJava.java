package com.micronautics.javaScala;

import com.micronautics.scalaJava.Container;
import com.micronautics.scalaJava.Container$;
import scala.Function0;
import scala.Option;
import scala.Tuple2;
import scala.runtime.AbstractFunction0;
import scala.sys.SystemProperties;
import scala.util.Either;
import scala.util.Left;
import scala.util.Right;

public class ScalaJava {

    public void miscFun() {
        scala.Option<String> stringNone = Option.empty();
        scala.Option<String> stringSome = Option.apply("Something in the way she moves...");

        if (stringNone.isEmpty())
            System.out.println("Option.empty works");
        System.out.println("Option.apply returned " + stringSome.get());

        Function0<String> elseOption = new AbstractFunction0<String>() {
            @Override public String apply() { return "default"; }
        };

        System.out.println("Option.apply returned " + stringNone.getOrElse(elseOption));

        final Either<Throwable, String> result1 = new Right<Throwable, String>("yay!");
        final Either<Throwable, String> result2 = new Left<Throwable, String>(new RuntimeException());
        System.out.println("result1.right=" + result1.isRight());
        System.out.println("result1.isLeft=" + result1.isLeft());
        System.out.println("result1.right=" + result1.right().get());
        System.out.println("result2.right=" + result2.left().get());
    }

    public void libPhun() {
        new SystemProperties().$plus$eq(new Tuple2("myProp", "42")); // persists in SystemProperties singleton
        System.out.println(new SystemProperties().get("myProp")); // prints 42
    }

	public void traitFun() {
        // @BeanProperty not used on ScalaClass1 public properties
        ScalaClass1 scalaClass1 = new ScalaClass1(2, 3.0);
        scalaClass1.prop2_$eq(4.0);
        System.out.printf("scalaClass1 prop1=%d; prop2=%f; prop3=%d; prop4=%f\n",
            scalaClass1.prop1(), scalaClass1.prop2(), scalaClass1.prop3(), scalaClass1.prop4());
   	    System.out.println("scalaClass1 with largest prop1: " + scalaClass1.largestProp(scalaClass1));

        // @BeanProperty decorates all public properties of ScalaClass2
        ScalaClass2 scalaClass2 = new ScalaClass2(5, 6.0);
        scalaClass2.setProp2(7.0); // Java setter
        scalaClass2.prop4_$eq(8.0); // Scala setter
        System.out.printf("scalaClass2 (Scala getters) prop1=%d; prop2=%f; prop3=%d; prop4=%f\n",
            scalaClass2.prop1(), scalaClass2.prop2(), scalaClass2.prop3(), scalaClass2.prop4());
        System.out.printf("scalaClass2 (Java getters) prop1=%d; prop2=%f; prop3=%d; prop4=%f\n",
            scalaClass2.getProp1(), scalaClass2.getProp2(), scalaClass2.getProp3(), scalaClass2.getProp4());

		// Cannot create Java class directly from a Scala trait:
		//ScalaTrait scalaTrait = new ScalaTrait() {};

		// Instead, define a Scala class that extends the trait and let Java work with it:
		ScalaTraitClass scalaTraitClass = new ScalaTraitClass();
        scalaTraitClass.s_$eq("Modified string"); // funny syntax for setter because @BeanProperty was not used
   	    System.out.println("scalaTraitClass.toString: " + scalaTraitClass);
		System.out.printf("scalaTraitClass: i()=%d; s()=%s; truncateS(7)=%s\n",
			scalaTraitClass.i(), scalaTraitClass.s(), scalaTraitClass.truncateS(7));

        System.out.println();
        // just prints the name of the case class
        System.out.println("ScalaCaseClass$.MODULE$.toString()=" + ScalaCaseClass$.MODULE$.toString());

        // same as new ScalaCaseClass(2, , "Argh!");
        ScalaCaseClass scalaCaseClass = ScalaCaseClass$.MODULE$.apply(2, "Argh!");
	    System.out.println("scalaCaseClass.toString: " + scalaCaseClass);

        // Define as scala.Option<ATypeHere> if arity == 1
        @SuppressWarnings("unchecked")
		scala.Option<Tuple2<Object, String>> extracted = ScalaCaseClass$.MODULE$.unapply(scalaCaseClass);
        System.out.println("extracted: " + extracted); // displays Some(2, Argh!)

        System.out.printf("scalaCaseClass: j=%d; s=%s; hashCode=%d\n",
               scalaCaseClass.j(), scalaCaseClass.s(), scalaCaseClass.hashCode());

        Object element0 = scalaCaseClass.productElement(0); // returns value of first property
        Object element1 = scalaCaseClass.productElement(1); // returns value of second property
        String productPrefix = scalaCaseClass.productPrefix();
        int arity = scalaCaseClass.productArity(); // returns number of properties
        System.out.printf("scalaCaseClass.productPrefix=%s; arity=%d; element0=%d; element1: %s\n",
            productPrefix, arity, element0, element1);

        int prop1 = scalaCaseClass.copy$default$1(); // returns value of first property of case class
        ScalaCaseClass copy1 = scalaCaseClass.copy(prop1, "Blah");
        System.out.println("copy1: " + copy1);
        String prop2 = scalaCaseClass.copy$default$2(); // returns value of second property of case class
        ScalaCaseClass copy2 = scalaCaseClass.copy(42, prop2);
        System.out.println("copy2: " + copy2);

        System.out.printf("scalaCaseClass %s be tested for equality with copy1 and %s equivalent.\n",
            scalaCaseClass.canEqual(copy1) ? "can" : "can not",
            scalaCaseClass.equals(copy1) ? "is" : "is not");
	}

	public void objectFun() {
		// A Scala object is a singleton, and the class instance is stored in the <tt>MODULE$</tt> property.
		// ScalaObject has no companion class, so method forwarding is not possible and you must write out MODULE$
		System.out.println("ScalaObject: " + ScalaObject$.MODULE$);
		System.out.printf("ScalaObject: i()=%d; s()=%s; truncateS(7)=%s\n",
				ScalaObject$.MODULE$.i(), ScalaObject$.MODULE$.s(), ScalaObject$.MODULE$.truncateS(7));
	}

	public void funFun() {
        System.out.println("");
        scala.Function1<String, String> hello = FunFun.hello();
        System.out.println(hello.apply("Hello"));
        System.out.println(FunFun.hello().apply("Toodles"));
        scala.Function1<String, Object> count = FunFun.count();
        System.out.println("Shakespeare quote 1 length: " + count.apply("The evil that men do lives after them;"));
        System.out.println("Shakespeare quote 2 length: " + FunFun.count().apply("The good is oft interred with their bones."));
	}

	public void collectionFun() {
        // Access Scala list wrapped by JavaConverters.toJava
        Container$ demo = Container.getInstance(); // talk about this technique in lecture 1
        System.out.println("JavaConvertersDemo.wrappedScalaList().get(1): " + demo.wrappedScalaList().get(1));

       // TODO finish this
       // Object x = new scala.collection.IndexedSeq<Integer>();
       // System.out.println(x);
	}

	public void libFun() {
		/** @see http://www.scala-lang.org/api/current/index.html#scala.sys.SystemProperties */
		scala.sys.SystemProperties sysProps = new scala.sys.SystemProperties();
		System.out.println("System properties:");
		for (String key : scala.collection.JavaConversions.asJavaIterable(sysProps.keys())) {
			System.out.println("   " + key);
		}
	}

	public static void main(String[] args) {
		ScalaJava scalaJava = new ScalaJava();
        scalaJava.miscFun();
        new FunProc().doIt();

		scalaJava.traitFun();
		System.out.println();
		scalaJava.objectFun();

		System.out.println();
		scalaJava.funFun();

		System.out.println();
		scalaJava.collectionFun();

		System.out.println();
		scalaJava.libFun();

        System.out.println();
        scalaJava.libPhun();
	}
}

