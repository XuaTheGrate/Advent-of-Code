package aoc.xxi

class Day10: DayXXI() {
    override val dayNum = 10

    private val syntaxScores = mapOf(
        ')' to 3,
        ']' to 57,
        '}' to 1197,
        '>' to 25137
    )

    fun Char.isClosing() = this in ")]}>"
    fun Char.opener() = when (this) {
        ')' -> '('
        ']' -> '['
        '}' -> '{'
        '>' -> '<'
        else -> this
    }
    fun Char.closer() = when (this) {
        '(' -> ')'
        '[' -> ']'
        '{' -> '}'
        '<' -> '>'
        else -> this
    }
    
    override fun solutionPart1() = data.map { line ->
        var i = 0
        val stack = mutableListOf<Char>()
        while (true) {
            val c = line.getOrNull(i) ?: return@map 0
            if (!c.isClosing()) stack.add(c)
            else {
                val open = c.opener()
                val top = stack.removeLast()
                if (top != open) return@map syntaxScores[c]!!
            }
            i++
        }
        0  // idk why it fucks out if i remove this
    }.sum()

    private val autoScores = mapOf(
        ')' to 1,
        ']' to 2,
        '}' to 3,
        '>' to 4
    )

    override fun solutionPart2(): Number {
        val scores = mutableMapOf<Int, Long>()
        lines@for ((index, line) in data.withIndex()) {
            var score = 0L
            var i = 0
            val stack = mutableListOf<Char>()
            while (true) {
                val c = line.getOrNull(i)
                if (c == null) {
                    while (stack.isNotEmpty()) {
                        val top = stack.removeLast()
                        val close = top.closer()
                        score *= 5L
                        score += autoScores[close]!!.toLong()
                    }
                    scores[index] = score
                    continue@lines
                } else {
                    if (!c.isClosing()) stack.add(c)
                    else {
                        val open = c.opener()
                        val top = stack.removeLast()
                        if (top != open) continue@lines
                    }
                }
                i++
            }
        }
        val sort = scores.values.sorted()
        return sort[sort.size / 2]
    }
}