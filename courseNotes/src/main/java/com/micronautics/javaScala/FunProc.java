package com.micronautics.javaScala;

import scala.Function1;
import scala.collection.immutable.List;
import scala.collection.immutable.List$;
import scala.runtime.AbstractFunction1;

    public class FunProc {
        List<Integer> nil = List$.MODULE$.empty();      // Nil, a.k.a. List(), a.k.a. the empty list

        List<Integer> list1 = nil.$colon$colon(1).$colon$colon(2).$colon$colon(3).$colon$colon(14).$colon$colon(8); // List(8, 14, 3, 2, 1)

        List<Integer> list2 = nil.$colon$colon(20).$colon$colon(30).$colon$colon(40); // List(40, 30, 20)

        List<Integer> concatenated = list1.$colon$colon$colon(list2); // List(40, 30, 20, 8, 14, 3, 2, 1)

        Function1<Integer, Object> filterFn = new AbstractFunction1<Integer, Object>() {
            public Boolean apply(Integer value) { return value<10; }
        };

        List<Integer> filteredList1 = concatenated.toTraversable().filter(filterFn).toList(); // List(8, 3, 2, 1)

        // gives same result: List(8, 3, 2, 1)
        List<Integer> filteredList2 = (List<Integer>)
                ((scala.collection.TraversableLike)concatenated.toTraversable().filter(filterFn).toList());

        public void doIt() {
            System.out.println("1ist1=" + list1);
            System.out.println("1ist2=" + list2);
            System.out.println("concatenated=" + concatenated);
            System.out.println("filteredList1=" + filteredList1);
            System.out.println("filteredList2=" + filteredList2);
        }
    }
