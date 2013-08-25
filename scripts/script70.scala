1 -> 2
(1, 2)
Tuple2(1, 2)
(1, 2, 3)
Tuple3(1, 2, 3)
(1, 2.0, "abc")
val t3 = Tuple3(1, 2.0, "abc")
t3._1
t3._2
t3._3
t3.copy(_2=4.2)
val map = Map(1->"a", 2->"b")
map.get(2)
map(4)
map.getOrElse(42, "z")
val map2 = Map(1->"a", 2->"b").withDefaultValue("z")
map2(99)
map + (3 -> "c")
map + ((3, "c"))
map + (3 -> "c", 4 -> "d")
val map2 = map + (3 -> "c", 4 -> "d")
map2.filter(x => x._1%2==0)
map2.filter(_._1%2==0)
val map6 = map2 ++ map5
map6.keys
val group = map6.groupBy(_._1%2==0)
group(true)
group(false)
val (even, odd) = map6.partition(_._1%2==0)
map6.updated(1, "q")
map.isDefinedAt(42)
map.isDefinedAt(2)

