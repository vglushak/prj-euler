package play_here

import java.nio.file.{Paths, Path}
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.locks.ReentrantLock

import scala.concurrent.Future


class Lock(t: String) extends java.util.function.Function[String, ReentrantLock] {


  override def apply(t: String): ReentrantLock = {
    println("Creating new lock!")
    val ree = new ReentrantLock()
    Thread.sleep(1)
    ree
  }

}


object DoDo {
  object SomeLocker {
    val lockerCache = new ConcurrentHashMap[String, ReentrantLock]()

    def lock(str: String): Unit = {
      println("go for lock")
      lockerCache.computeIfAbsent(str, new Lock("")).lock()
      // println("locked")
    }

    def unlock(str: String) = {
      val lock = lockerCache.get(str)
      if (!lock.hasQueuedThreads()) {
        lockerCache.remove(str)
      }
      lock.unlock()
      println("un-locked")
    }
  }


  class Count() {
    val id = Count.id()
    override def toString = s"Count$id"
  }

  object Count {
    var n = -1
    def id() = { n += 1; n }
  }

  def extra = (Math.random() % 10).toInt

  // import scala.concurrent.ExecutionContext.Implicits.global
  def main(str: Array[String]): Unit = {


    println(Vector(new Count, new Count, new Count))


    // println(Paths.get("c:/") == Paths.get(":/"))
//    (0 to 10000).map { th =>
//      Thread.sleep(1)
//      Future {
//        val i = extra
//        SomeLocker.lock("dad" + i)
//        Thread.sleep(1)
//        SomeLocker.unlock("dad" + i)
//      }
//    }
//    Thread.sleep(1000)
  }
}



object Main {


  case class IntWrap(v: Int)  {

  }

  val m = 0
  val km = 1

  implicit def wrapM(v: Int) = new {
    def m = IntWrap(v)
  }

  implicit def wrapKm(v: Int) = new {
    def km = v * 1000
  }

  implicit class toWrap(fromVal: IntWrap) {
    def to(value: Int): Double = {
      if (value.equals(km)) {
        fromVal.v / 1000.0
      } else {
        0
      }
    }
  }

  def main(args:Array[String])
  {

    println(53.m to km)
  }
}