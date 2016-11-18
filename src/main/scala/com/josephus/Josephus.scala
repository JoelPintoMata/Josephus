package com.josephus

import java.lang.{Integer => JInteger}
import java.util.{LinkedList => JLinkedList, List => JList}

import scala.annotation.tailrec

/** Josephus solution object
  *
  * @author Joel Mata
  */
class Josephus {
  var currentPos = 1
  var kAux = 1

  /** Returns the position from where to remove
    *
    * @param k number of elements to skip
    * @param elements the list of remaining elements
    * @return
    */
  def findSkipping(k: Int, elements: JLinkedList[JInteger]): Int = {
    var skippingAux = currentPos + k
    while(skippingAux > elements.size())
      skippingAux = skippingAux - elements.size()
    skippingAux
  }

  /** Returns the remaining element
    *
    * @param n number of total elements
    * @param k number of elements to skip
    */
  final def findSurvivor(n: Int, k: Int): Int = {
    require(n >= 1)
    require(k >= 0)

    val elementsAux: JList[JInteger] = new JLinkedList[JInteger]()
    for(i <- 1 to n)
      elementsAux.add(new JInteger(i))

    val elements = new JLinkedList(elementsAux)

    while(elements.size > 1) {
      kAux = findSkipping(k, elements)
      elements.remove(kAux-1)
      currentPos = kAux
      if(currentPos > elements.size())
        currentPos = 1
    }
    elements.get(0)
  }

  /** Returns the remaining element
    *
    * Recursive solution
    *
    * @param n number of total elements
    * @param k number of elements to skip
    * @param index index position from where to start counting
    */
  final def findSurvivorRecursively(n: Int, k: Int, index: Int): Int = {
    require(n >= 1)
    require(k >= 0)

    val elementsAux: JList[JInteger] = new JLinkedList[JInteger]()

    for(i <- 1 to n)
      elementsAux.add(new JInteger(i))

    val elements = new JLinkedList(elementsAux)

    /** Returns the remaining element using tail recursion method
      *
      * @param index index position from where to start counting.
      * @return
      */
    @tailrec
    def findSurvivorRecursion(index: Int): Int = {
      require(elements.size >= 1)

      if(elements.size == 1)
        elements.get(0)
      else {
        kAux = findSkipping(k, elements)
        elements.remove(kAux-1)
        currentPos = kAux
        if(currentPos > elements.size())
          currentPos = 1
        findSurvivorRecursion(currentPos)
      }
    }
    findSurvivorRecursion(currentPos)
  }

  /** Returns the remaining element
    *
    * This is the most optimized version
    *
    * @param n number of total elements
    * @param k number of elements to skip
    */
  final def findSurvivorOptimized(n: Int, k: Int): Int = {
    if (n == 1)
      return 1;
    else
      return (findSurvivorOptimized(n - 1, k) + k-1) % n + 1;
  }
}