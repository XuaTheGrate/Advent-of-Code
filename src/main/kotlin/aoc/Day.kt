package aoc

import java.io.File

abstract class Day {
    abstract val dayNum: Int
    open val data: List<String> by lazy {
        rawData
            .trim()
            .split('\n')
            .map(String::trim)
    }
    open val rawData: String by lazy {
        File("data/day$dayNum.txt").readText(Charsets.UTF_8)
    }

    abstract fun solutionPart1()
    abstract fun solutionPart2()
}