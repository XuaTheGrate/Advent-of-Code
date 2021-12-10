package aoc

import aoc.xxi.*

val days = listOf(
    Day1(),
    Day2(),
    Day3(),
    Day4(),
    Day5(),
    Day6(),
    Day7(),
    // Day8(),
    // Day9(),
    Day10(),
    // Day11(), 
    // Day12(), 
    // Day13(),
    // Day14(),
    // Day15(),
    // Day16(),
    // Day17(),
    // Day18(),
    // Day19(),
    // Day20(),
    // Day21(), 
    // Day22(), 
    // Day23(), 
    // Day24(),
    // Day25()
)

inline fun <R> timed(crossinline callback: () -> R): Pair<Long, R> {
    val startTime = System.currentTimeMillis()
    val result = callback()
    val elapsed = System.currentTimeMillis() - startTime
    return elapsed to result
}

fun main() {
    days.forEach { day ->
        val (elapsed1, result1) = timed(day::solutionPart1)
        println("Day #${day.dayNum}/1: ${result1.toLong()} ($elapsed1 ms)")

        val (elapsed2, result2) = timed(day::solutionPart2)
        println("Day #${day.dayNum}/2: ${result2.toLong()} ($elapsed2 ms)\n----------")
    }
}