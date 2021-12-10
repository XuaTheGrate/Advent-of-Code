package aoc.xxi

class Day5: DayXXI() {
    override val dayNum = 5

    data class Vector2(val x1: Int, val x2: Int, val y1: Int, val y2: Int)

    private val geysers = data.map {
        val (start, end) = it.split(" -> ")
        val (x1, y1) = start.split(",").map(String::toInt)
        val (x2, y2) = end.split(",").map(String::toInt)

        Vector2(x1, x2, y1, y2)
    }
    
    override fun solutionPart1(): Number {
        val counter = mutableMapOf<Pair<Int, Int>, Int>()
        for (point in geysers) {
            if (point.y1 == point.y2) {
                for (x in point.x1 rangeTo point.x2) {
                    counter[x to point.y1] = counter[x to point.y1]?.inc() ?: 1
                }
            } else if (point.x1 == point.x2) {
                for (y in point.y1 rangeTo point.y2) {
                    counter[point.x1 to y] = counter[point.x1 to y]?.inc() ?: 1
                }
            }
        }
        val overlap = counter.values.filter { it > 1 }
        return overlap.size
    }

    infix fun Int.rangeTo(other: Int): IntProgression {
        if (this > other) return this downTo other
        return this .. other
    }
    
    override fun solutionPart2(): Number {
        val counter = mutableMapOf<Pair<Int, Int>, Int>()
        for (point in geysers) {
            if (point.y1 == point.y2) {
                for (x in point.x1 rangeTo point.x2) {
                    counter[x to point.y1] = counter[x to point.y1]?.inc() ?: 1
                }
            } else if (point.x1 == point.x2) {
                for (y in point.y1 rangeTo point.y2) {
                    counter[point.x1 to y] = counter[point.x1 to y]?.inc() ?: 1
                }
            } else {
                for ((x, y) in (point.x1 rangeTo point.x2).zip(point.y1 rangeTo point.y2)) {
                    counter[x to y] = counter[x to y]?.inc() ?: 1
                }
            }
        }
        val overlap = counter.values.filter { it > 1 }
        return overlap.size
    }
}