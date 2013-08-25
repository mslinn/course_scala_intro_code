val a1 = Array(1, 2, 3)
val a2 = Array.empty[Int]
val a3: Array[Int] = Array(1, 2, 3)
a1(0) = a1(0) + 1
a1
a1.update(0, at.apply(0) + 1)
val s1 = Seq(1, 2, 3)
List(1, 2, 3)
1 :: 2 :: 3 :: Nil
Set(1, 1, 2)
List(1, 2, 2, 3).distinct
List(1, 2, 3).toArray
List(1, 2, 3).toBuffer
val lb = collection.mutable.ListBuffer(1, 2, 3)
lb(0) = lb(0) * 3
lb
lb.toArray
lb.toSeq
lb.toIndexedSeq
