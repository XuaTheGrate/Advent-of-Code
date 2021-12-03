package aoc

class Day2: Day() {
    override val dayNum = 2

    override fun solutionPart1() {
        var horiPos = 0
        var depth = 0

        for (line in data) {
            val t = line.split(' ')
            val dir = t.first()
            val count = t.last().toInt()
            when (dir) {
                "forward" -> horiPos += count
                "up" -> depth -= count
                "down" -> depth += count
            }
        }
        println("Day #$dayNum/1: ${horiPos * depth}")
    }

    override fun solutionPart2() {
        var horiPos = 0
        var depth = 0
        var aim = 0

        for (line in data) {
            val t = line.split(' ')
            val dir = t.first()
            val count = t.last().toInt()
            when (dir) {
                "forward" -> {
                    horiPos += count
                    depth += count * aim
                }
                "up" -> aim -= count
                "down" -> aim += count
            }
        }
        println("Day #$dayNum/2: ${horiPos * depth}")
    }
}