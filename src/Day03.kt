private const val DAY = "03"
private const val PART_1_CHECK = 157
private const val PART_2_CHECK = 70

fun codeToPriority (code: Int): Int {
    return if (code <= 90) code - 65 + 27 else code - 96
}

// a is worth 1, z is worth 26, A is worth 27, Z is worth 52
fun main() {
    fun part1(input: List<String>): Int {
        val rucksacks = input
            .map { it.chunked(it.length / 2)
                .map { chunk ->  chunk.toCharArray().toSet() }
            }

        val duplicates = rucksacks.map {
                var duplicate: Char? = null
                it[0].forEach { c -> if (it[1].contains(c)) duplicate = c }
                duplicate
            }

        return duplicates.map { codeToPriority(it!!.code) }.sum()
    }

    fun part2(input: List<String>): Int {
        val duplicates = input
            .chunked(3)
            .map {
                var duplicate: Char? = null
                it[0].forEach { c -> if (it[1].contains(c) && it[2].contains(c)) duplicate = c }
                duplicate
            }

        return duplicates.map { codeToPriority(it!!.code) }.sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day${DAY}_test")
    check(part1(testInput).also { println("Part 1 check: $it") } == PART_1_CHECK)
    check(part2(testInput).also { println("Part 2 check: $it") } == PART_2_CHECK)


    val input = readInput("Day${DAY}")
    println("Part 1 solution: ${part1(input)}")
    println("Part 2 solution: ${part2(input)}")
}
