package aoc.xxi

class Day2: DayXXI() {
    override val dayNum = 2

    override fun solutionPart1(): Number {
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
        return horiPos * depth
    }

    override fun solutionPart2(): Number {
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
        return horiPos * depth
    }
}