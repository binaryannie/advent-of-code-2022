private const val DAY = "05"
private const val PART_1_CHECK = "CMZ"
private const val PART_2_CHECK = "MCD"

fun inputToColumns(input: List<String>): MutableList<MutableList<String>> {
    val separatorIndex = input.indexOf("")
    val numberOfColumns = input[separatorIndex - 1].chunked(4).size
    val boat = input
        .slice(0 until separatorIndex - 1)
        .map { it.chunked(4).map { box -> box.replace("\\W".toRegex(), "") } }

    val flipped = Array(numberOfColumns) { Array<String>(boat.size) { "" } }
    boat.reversed().forEachIndexed { row, strings -> strings.forEachIndexed { column, s -> flipped[column][row] = s } }

    return flipped.map { row -> row.map { t -> t }.filterNot { it.isBlank() }.toMutableList() }.toMutableList()
}

fun inputToMoves(input: List<String>):
        List<List<Int>> {
    val separatorIndex = input.indexOf("")
    return input
        .slice(separatorIndex + 1 until input.size)
        .map {
            val matches = Regex("move (\\d+) from (\\d+) to (\\d+)").find(it)!!
            val (i, amount, from, to) =  matches.groupValues
            listOf(amount.toInt(), from.toInt() - 1, to.toInt() - 1)
        }
}

fun main() {
    fun part1(input: List<String>): String {
        val columns = inputToColumns(input)
        val moves = inputToMoves(input)

        moves.forEach { move ->
            for (i in 1..move[0]) {
                val block = columns[move[1]].removeLast()
                columns[move[2]].add(block)
            }
        }

        return columns.joinToString("") { it.last() }
    }

    fun part2(input: List<String>): String {
        val columns = inputToColumns(input)
        val moves = inputToMoves(input)

        moves.forEach { move ->
            val stack = columns[move[1]].takeLast(move[0])
            repeat(move[0]){columns[move[1]].removeLastOrNull()}
            columns[move[2]].addAll(stack)
        }

        return columns.joinToString("") { it.last() }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day${DAY}_test")
    check(part1(testInput).also { println("Part 1 check: $it") } == PART_1_CHECK)
    check(part2(testInput).also { println("Part 2 check: $it") } == PART_2_CHECK)


    val input = readInput("Day${DAY}")
    println("Part 1 solution: ${part1(input)}")
    println("Part 2 solution: ${part2(input)}")
}