val list = List(1, 2, 3)
def square(num: Int): Int = num * num
list.map(square)
list.map( x => x.toDouble )
Array(1, 2, 3).map( x => x.toDouble )
list.map(_.toDouble)
list.map(x => x * x)
list.map { x => 
  val square = x * x
  square - 2
}
list.map( x => x/2 )
list.filter( x => x/2==0 )
list.filterNot( x => x/2==0 )
list.filter( _/2==0 )
list.filterNot( _/2==0 )
list.partition( _/2==0 )
val (pass, fail) = list.partition( _/2==0 )
pass
fail
val (pass: List[Int], fail: List[Int]) = list.partition( _/2==0 )
