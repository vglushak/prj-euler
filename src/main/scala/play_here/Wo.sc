import scala.collection.mutable

sealed trait Edge
case class Node(name: String, childs: List[Edge] = List()) extends Edge
case class Leave(value: String) extends Edge

val map = Map("foo.bar" -> "15", "foo.lots.dir" -> "/tmp/test", "foo.baz.host" -> "localhost", "foo.baz.port" -> "333")

//
//def appendNode(root: Node, ppath: List[String], value: String): List[Node] = {
//  root.name match {
//    case "" => root.copy(childs = appendNode(ppath.head, ppath.tail, value))
//  }
//  if (root.name == ppath.head) {
//    root.childs match {
//
//    }
//  } else {
//    ppath match {
//      case head:: Nil => Node(head, List(Leave(value)))
//      case head:: tail => appendNode(Node(ppath.head, List()), tail, value)
//    }
//
//  }
//}

def buildEdge(path: List[String], value: String): Node = {
  path match {
    case head :: Nil => Node(head, List(Leave(value)))
    case head :: tail => Node(head, List(buildEdge(tail, value)))
  }

}
def buildTree(map: Map[String, String]) = {
  map.map { path =>
    println(path)
    val pp = path._1.split("\\.").toList
    buildEdge(pp, path._2)
  }

}

buildTree(map).foreach(println)



//
////println(buildTree(map, )))
//
//Node("foo",
//    List(
//        Node("bar", List(Leave("15"))),
//        Node("baz",
//            List(
//              Node("port", List(Leave("333"))),
//              Node("host", List(Leave("localhost")))
//              )
//            )
//
//      )
//    )