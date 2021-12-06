package aoc.xxi

class Day3: DayXXI() {
    override val dayNum = 3

    private fun mutableListOf(size: Int): MutableList<Int> = mutableListOf<Int>().apply {
        for (i in 0 until size) add(0)
    }

    override fun solutionPart1(): Number {
        val bits = mutableListOf(data.first().length)
        for (line in data) {
            for ((idx, c) in line.withIndex()) {
                if (c == '1') bits[idx]++
                else bits[idx]--
            }
        }
        val gamma = bits
            .map { if (it > 0) 1 else 0 }
            .joinToString(separator = "", transform = Int::toString)
            .toUInt(2)
        val epsilon = gamma.inv() and 0xfffu
        return (gamma * epsilon).toInt()
    }

    private fun filterData(high: Char, low: Char): String {
        val dataCopy = data.toMutableList()
        for (i in data.first().indices) {
            if (dataCopy.size == 1) break
            val bits = dataCopy.map { it[i].digitToInt() }
            val highest = bits.sumOf {
                if (it == 1) 1 else -1 as Int
            }
            val toRemove = if (highest >= 0) high else low
            dataCopy.removeAll {
                it[i] == toRemove
            }
        }
        return dataCopy.first()
    }

    override fun solutionPart2(): Number {
        val oxygen = filterData('0', '1').toInt(2)
        val scrubber = filterData('1', '0').toInt(2)
        return oxygen * scrubber
    }
}