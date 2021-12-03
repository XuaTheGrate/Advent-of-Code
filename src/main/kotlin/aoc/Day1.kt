package aoc

class Day1: Day() {
    override val dayNum = 1

    override fun solutionPart1() {
        var last: Int? = null
        var incr = 0
        for (line in data) {
            val num = line.toInt()
            if (last != null && num > last)
                incr++
            last = num
        }
        println("Day #$dayNum/1: $incr")
    }

    override fun solutionPart2() {
        val data = data.map(String::toInt)
        var incr = 0
        var last: Int? = null
        main@for ((idx, _) in data.withIndex()) {
            var sum3 = 0
            for (a in 0 until 3) {
                val i = idx + a
                if (i >= data.size) break@main
                val num = data[i]
                sum3 += num
            }
            if (last != null && sum3 > last)
                incr++
            last = sum3
        }
        println("Day #$dayNum/2: $incr")
    }
}