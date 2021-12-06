package aoc.xxi

import kotlin.properties.Delegates

class Day4: DayXXI() {
    override val dayNum = 4

    data class BingoBoard(val rows: List<List<Int>>, val marked: MutableMap<Int, Boolean> = mutableMapOf()) {
        override fun toString(): String {
            return "\n" + rows.joinToString("\n") {
                it.joinToString("\t", transform = Int::toString)
            }
        }

        fun getIndexOf(number: Int): Int? {
            for ((i, col) in rows.withIndex()) {
                for ((j, item) in col.withIndex()) {
                    if (item == number) return (i * 5) + j
                }
            }
            return null
        }

        private val validWins: List<List<Int>> by lazy {
            val horizontal = mutableListOf<List<Int>>()
            for (i in 0 until 5) {
                horizontal.add((5 * i until (5 * i) + 5).toList())
            }
            val vertical = mutableListOf<List<Int>>()
            for (i in 0 until 5) {
                vertical.add((0 until 25 step 5).map { i + it })
            }
            horizontal.apply { addAll(vertical) }
        }

        fun check(): Boolean {
            for (path in validWins) {
                if (marked.keys.containsAll(path)) {
                    return true
                }
            }
            return false
        }
    }

    private var numbers: List<Int> by Delegates.notNull()

    private val boards: MutableList<BingoBoard> = run {
        val data = rawData.split("\r\n\r\n")
        numbers = data.first().split(",").map(String::toInt)
        val results = mutableListOf<BingoBoard>()
        for (item in data.slice(1 until data.size)) {
            results.add(BingoBoard(
                item.split("\n")
                    .map {
                        it.trim()
                            .split(Regex("\\s+"))
                            .map(String::trim)
                            .filter(String::isNotBlank)
                            .map(String::toInt)
                    }
            ))
        }
        results
    }
    
    override fun solutionPart1(): Number {
        var winning: Pair<Int, BingoBoard> by Delegates.notNull()
        base@for (num in numbers) {
            for (board in boards) {
                val idx = board.getIndexOf(num) ?: continue
                board.marked[idx] = true
                if (board.check()) {
                    winning = num to board
                    break@base
                }
            }
        }
        val (winningNum, winningBoard) = winning
        var sum = 0
        for (row in winningBoard.rows) {
            for (item in row) {
                val idx = winningBoard.getIndexOf(item)!!
                if (idx !in winningBoard.marked) sum += item
            }
        }
        return sum * winningNum
    }
    
    override fun solutionPart2(): Number {
        var winning: Pair<Int, BingoBoard> by Delegates.notNull()
        base@for (num in numbers) {
            val toRemove = mutableListOf<BingoBoard>()
            for (board in boards) {
                val idx = board.getIndexOf(num) ?: continue
                board.marked[idx] = true
                if (board.check()) {
                    if (boards.size == 1) {
                        winning = num to board
                        break@base
                    } else toRemove.add(board)
                }
            }
            boards.removeAll(toRemove)
            if (boards.size == 0) {
                winning = num to toRemove.last()
                break@base
            }
        }
        val (winningNum, winningBoard) = winning
        var sum = 0
        for (row in winningBoard.rows) {
            for (item in row) {
                val idx = winningBoard.getIndexOf(item)!!
                if (idx !in winningBoard.marked) sum += item
            }
        }
        return sum * winningNum
    }
}