fun convertInputToGames(input: List<String>): List<List<Int>> {
    return input
        .map { it.split(' ') }
        .map { listOf(it[0].toCharArray()[0].code - 65, it[1].toCharArray()[0].code - 88) }
}

fun scoreGame (opponentPlays: Int, wePlay: Int): Int {
    val playerScore = wePlay + 1
    return when (opponentPlays) {
        wePlay -> 3 + playerScore // Draw
        (wePlay + 1) % 3 -> playerScore // Lose
        else -> 6 + playerScore // Win
    }
}

// 0 = rocks, 1 = paper, 2 = scissors
// 0 wins against 2 but loses against 1
// 1 wins against 0 but loses against 2
// 2 wins against 1 but loses against 0
fun main() {
    fun part1(input: List<String>): Int {
        val games = convertInputToGames(input)
        val scores = games
            .map {
                scoreGame(it[0], it[1])
            }

        return scores.sum()
    }

    // 0 = Lose, 1 = Draw, 2 = Win
    fun part2(input: List<String>): Int {
        val games = convertInputToGames(input)
        val scores = games
            .map {
                val result = it[1]
                val opponentPlays = it[0]
                val wePlay = when (result) {
                    1 -> opponentPlays
                    2 -> (opponentPlays + 1) % 3
                    else -> if (opponentPlays == 0) 2 else opponentPlays - 1
                }

                scoreGame(opponentPlays, wePlay)
            }

        return scores.sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)


    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
