package com.gonitro.josephus

import java.lang.{Integer => JInteger}
import java.util.{LinkedList => JLinkedList, List => JList}

/** Josephus companion object
  *
  * @author Joel Mata
  */
object Main {

  /** Main method: Do the arg line processing and call the functions. */
  final def main(args: Array[String]): Unit = {
    require(args.size == 2, "Usage: Josephus <numOfSoldiers> <killingEvery>")

    val numOfSoldiers = args(0).toInt
    val killingEvery = args(1).toInt

    val josephus = new Josephus
//    println(josephus.findSurvivor(numOfSoldiers, killingEvery-1))
//    println(josephus.findSurvivorRecursively(numOfSoldiers, killingEvery-1, 0))
    println(josephus.findSurvivorOptimized(numOfSoldiers, killingEvery))
  }
}