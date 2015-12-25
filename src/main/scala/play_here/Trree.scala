package play_here

object Trree extends App {

  sealed trait Edge
  case class Node(name: String, childs: List[Edge] = List()) extends Edge
  case class Leave(value: String) extends Edge

  val map = Map("foo.bar" -> "15", "foo.lots.dir" -> "/tmp/test", "foo.baz.host" -> "localhost", "foo.baz.port" -> "333")


  def grouping(m: Map[List[String], Any]) : Map[List[String], Any] = {
    println(m)
    val rr = m.filter(_._1.nonEmpty).groupBy(_._1.head).map { el =>
      val internalMap = el._2.map(eel => eel._1.tail -> eel._2)
      internalMap.size match {
        case 1 => el._1 -> internalMap.head._2
        case other => el._1 -> grouping(internalMap)
      }
    }
    rr.map(el => List(el._1) -> el._2)
  }

  println(
    grouping(map.map(e => e._1.split("\\.").toList -> e._2))
  )

  def buildEdge(path: List[String], value: String): Node = {
    path match {
      case head :: Nil => Node(head, List(Leave(value)))
      case head :: tail => Node(head, List(buildEdge(tail, value)))
    }
  }

  def buildTree(map: Map[String, String]) = {
    map.map { path =>
      val pp = path._1.split("\\.").toList
      buildEdge(pp, path._2)
    }
  }

//  def merge(left: List[Edge], right: List[Edge]): List[Node] = {
//    left.map { li =>
//      right.find(_.name == li) match {
//        case Some(n) => merge(li.childs, n.childs)
//      }
//    }
//  }

  buildTree(map).foreach(println)



}
