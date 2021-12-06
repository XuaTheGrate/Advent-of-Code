import aoc.xx.DayXX
import aoc.xxi.*

val xx: List<DayXX> = listOf(
    aoc.xx.Day1(), aoc.xx.Day2(), aoc.xx.Day3(), aoc.xx.Day4(), aoc.xx.Day5(), aoc.xx.Day6()
)
val xxi: List<DayXXI> = listOf(
    Day1(), Day2(), Day3(), Day4(), Day5(), Day6(), Day7(), Day8(), Day9(), Day10(), Day11(), Day12(), Day13(),
    Day14(), Day15(), Day16(), Day17(), Day18(), Day19(), Day20(), Day21(), Day22(), Day23(), Day24(), Day25()
)

fun main() {
    xxi.forEach { day ->
        val first = day.solutionPart1()
        println("Day #${day.dayNum}/1: $first")
        val second = day.solutionPart2()
        println("Day #${day.dayNum}/2: $second\n----------")
    }
}