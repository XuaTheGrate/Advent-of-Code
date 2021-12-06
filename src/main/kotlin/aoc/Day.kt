package aoc

import java.io.File

abstract class Day {
    abstract val dayNum: Int
    abstract val year: Int
    open val data: List<String> by lazy {
        rawData
            .trim()
            .split('\n')
            .map(String::trim)
    }
    open val rawData: String by lazy {
        File("data/$year/day$dayNum.txt").readText(Charsets.UTF_8)
    }

    abstract fun solutionPart1(): Number
    abstract fun solutionPart2(): Number
}