package aoc.xxi
        
import aoc.unreachable

class Day6: DayXXI() {
    override val dayNum = 6

    private val fish = data.first().split(",").map(String::toInt)
    
    override fun solutionPart1(): Number {
        var mapping = fish.associateWith { i -> fish.count { it == i } }.toMutableMap()
        for (n in 0 until 80) {
            mapping = mapping.map { it.key - 1 to it.value }.toMap().toMutableMap()
            mapping[6] = (mapping[6] ?: 0) + (mapping[-1] ?: 0)
            mapping[8] = (mapping[8] ?: 0) + (mapping[-1] ?: 0)
            mapping.remove(-1)
        }
        return mapping.values.sum()
    }

    override fun solutionPart2(): Number {
        var mapping = fish.associateWith { i -> fish.count { it == i }.toLong() }.toMutableMap()
        for (n in 0 until 256) {
            mapping = mapping.map { it.key - 1 to it.value }.toMap().toMutableMap()
            mapping[6] = (mapping[6] ?: 0) + (mapping[-1] ?: 0)
            mapping[8] = (mapping[8] ?: 0) + (mapping[-1] ?: 0)
            mapping.remove(-1)
        }
        return mapping.values.sum()
    }
}