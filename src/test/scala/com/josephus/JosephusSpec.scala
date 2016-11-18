package com.josephus

import org.specs2.Specification

/**
  * Josephus problem solution tests
  */
class JosephusSpec extends Specification { def is = s2"""

 This is a specification for the Josephus problem
    where parameters are invalid                           $e1
    where total number is 4 and the skipping value is 1    $e2
    where total number is 4 and the skipping value is 2    $e3
    where total number is 4 and the skipping value is 3    $e4
    where total number is 4 and the skipping value is 4    $e5
    where total number is 41 and the skipping value is 3   $e6
                                          """

  def e1 = {
    val josephus1 = new Josephus()
    josephus1.findSurvivor(0,-1) must throwAn[java.lang.IllegalArgumentException]

    val josephus2 = new Josephus()
    josephus2.findSurvivor(0,0) must throwAn[java.lang.IllegalArgumentException]
  }

  def e2 = {
    val josephus1 = new Josephus()
    josephus1.findSurvivor(4,0) mustEqual(4)

    val josephus2 = new Josephus()
    josephus2.findSurvivorRecursively(4,0,0) mustEqual(4)

    val josephus3 = new Josephus()
    josephus3.findSurvivorOptimized(4,1) mustEqual(4)
  }

  def e3 = {
    val josephus1 = new Josephus()
    josephus1.findSurvivor(4,1) mustEqual(1)

    val josephus2 = new Josephus()
    josephus2.findSurvivorRecursively(4,1,0) mustEqual(1)

    val josephus3 = new Josephus()
    josephus3.findSurvivorOptimized(4,2) mustEqual(1)
  }

  def e4 = {
    val josephus1 = new Josephus()
    josephus1.findSurvivor(4,2) mustEqual(1)

    val josephus2 = new Josephus()
    josephus2.findSurvivorRecursively(4,2,0) mustEqual(1)

    val josephus3 = new Josephus()
    josephus3.findSurvivorOptimized(4,3) mustEqual(1)
  }

  def e5 = {
    val josephus1 = new Josephus()
    josephus1.findSurvivor(4,3) mustEqual(2)

    val josephus2 = new Josephus()
    josephus2.findSurvivorRecursively(4,3,0) mustEqual(2)

    val josephus3 = new Josephus()
    josephus3.findSurvivorOptimized(4,4) mustEqual(2)
  }

  def e6 = {
    val josephus1 = new Josephus()
    josephus1.findSurvivor(41,2) mustEqual(31)

    val josephus2 = new Josephus()
    josephus2.findSurvivorRecursively(41,2,0) mustEqual(31)

    val josephus3 = new Josephus()
    josephus3.findSurvivorOptimized(41,3) mustEqual(31)
  }
}