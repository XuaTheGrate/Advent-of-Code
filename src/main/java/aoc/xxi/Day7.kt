package aoc.xxi
        
import kotlin.math.absoluteValue

class Day7: DayXXI() {
    override val dayNum = 7
    
    override fun solutionPart1(): Number {
        val data = data.first().split(",").map(String::toInt)
        val fuels = mutableListOf<Int>()
        for (i in 0 .. data.maxOrNull()!!) {
            fuels.add(data.sumOf { (i - it).absoluteValue })
        }
        return fuels.minOrNull()!!
    }

    override fun solutionPart2(): Number {
        val data = data.first().split(",").map(String::toInt)
        val fuels = mutableListOf<Int>()
        for (i in 0 .. data.maxOrNull()!!) {
            fuels.add(data.sumOf {
                val abs = (i - it).absoluteValue
                (abs * (abs + 1)) / 2
            })
        }
        return fuels.minOrNull()!!
    }
}