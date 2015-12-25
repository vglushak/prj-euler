package com.rumoku.test

import scala.io.Source

// Problem 18 and Problem 67
object PathFinder {

  val OUTPUT_DIR = "target/classes/"

  def setup {
    var matrix: List[Array[Int]] = Nil
    for (line <- Source.fromFile(OUTPUT_DIR + "pathfinder.txt").getLines) {
      val list = line.split(" ").map[Int](x => x.trim.toInt)
      matrix = matrix ::: List(list)
    }
    matrix.foreach(x => println(x.toString))
    val nodes = convertToNodes(0, 0, matrix);
    val pathesCost = getChildPathes(nodes)

    var tmp = 0
    pathesCost.foreach(x => if (x > tmp) tmp = x)
    println("Greatest path: " + tmp)
  }

  def getChildPathes(n: Node): List[Int] = n match {
    case null =>
      List(0)
    case node =>
      concatPathesWithCurrVal(n.value, getChildPathes(n.left)) ::: concatPathesWithCurrVal(n.value, getChildPathes(n.right))
  }

  def concatPathesWithCurrVal(vl: Int, l: List[Int]): List[Int] = {
    var res = List[Int]()
    l.foreach(x => res = x + vl :: res)
    res
  }


  def convertToNodes(x: Int, y: Int, matrix: List[Array[Int]]): Node =
    if (matrix.length == x)
      null
    else {
      // println(" " + x + " " + y + " = " + matrix(x)(y))
      new Node(matrix(x)(y), convertToNodes(x + 1, y, matrix), convertToNodes(x + 1, y + 1, matrix))
    }


  def main(args: Array[String]) {
    println()
    setup
  }
}

class Node(v: Int, l: Node, r: Node) {
  var value: Int = v
  var left: Node = l
  var right: Node = r

  override def toString =
    value + " [" + left + " " + right + "]"
}