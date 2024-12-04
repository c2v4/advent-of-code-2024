package com.c2v4.advent2024

import kotlin.math.max
import kotlin.math.min

//input is a string with line breaks count the number of words "XMAS" and "SAMX" horizontally and vertically and diagonally
// i.e.
//MMMSXXMASM
//MSAMXMSMSA
//AMXSXMAAMM
//MSAMASMSMX
//XMASAMXAMM
//XXAMMXXAMA
//SMSMSASXSS
//SAXAMASAAA
//MAMMMXMMMM
//MXMXAXMASX
fun ceres(input: String): Int = input.let {
    val regex = Regex("XMAS")
    val regex2 = Regex("SAMX")
    val xmas = regex.findAll(it).count() + regex2.findAll(it).count()
    val vertical = it.split("\n").transposed()
    val verticalCount = regex.findAll(vertical).count() + regex2.findAll(vertical).count()
    val diagonal = it.split("\n").diagonal()
    val diagonalCount = regex.findAll(diagonal).count() + regex2.findAll(diagonal).count()
    val transposedDiagonal = it.split("\n").otherDiagonal()
    val transposedDiagonalCount = regex.findAll(transposedDiagonal).count() + regex2.findAll(transposedDiagonal).count()
    xmas + verticalCount + diagonalCount + transposedDiagonalCount
}

private fun List<String>.diagonal(): String {
    var string = ""
    var i = -this.size
    while (i < this[0].length) {
        var current = (max(0, -i) to max(i, 0))
        while (current.first < this.size && current.second < this[0].length) {
            string += this[current.first][current.second]
            current = (current.first + 1 to current.second + 1)
        }
        string += "\n"
        i++
    }
    return string
}

private fun List<String>.otherDiagonal(): String {
    var string = ""
    var i = 0
    while (i < 2 * this[0].length) {
        var current = (min(this.size * 2 - i - 2, this.size - 1) to min(i, this.size - 1))
        while (current.first >= 0 && current.second >= 0) {
            string += this[current.first][current.second]
            current = (current.first - 1 to current.second - 1)
        }
        string += "\n"
        i++
    }
    return string
}

private fun List<String>.transposed(): String {
    //transpose the list of strings
    return this[0].indices.map { i -> this.map { it[i] }.joinToString("") }.joinToString("\n")

}

fun ceres2(input: String): Int {
    return input.split("\n").map { it.toCharArray() }.let { map ->
        map.indices.sumOf { i ->
            map[i].indices.count { j ->
                checkXmas(map, i, j)
            }
        }
    }
}

private fun checkXmas(map: List<CharArray>, i: Int, j: Int): Boolean {
    return getCharacter(map, i + 1, j + 1) == 'A' && (
            ((getCharacter(map, i, j) == 'S' && getCharacter(map, i + 2, j + 2) == 'M') ||
                    (getCharacter(map, i , j ) == 'M' && getCharacter(map, i +2, j +2) == 'S')) &&
                    ((getCharacter(map, i+2, j) == 'S' && getCharacter(map, i, j + 2) == 'M') ||
                            (getCharacter(map, i+2 , j ) == 'M' && getCharacter(map, i, j +2) == 'S'))
            )
}

private fun getCharacter(
    map: List<CharArray>,
    i: Int,
    j: Int
): Char {
    val emptyArray = "".toCharArray()
    return map.getOrElse(i ) { emptyArray }.getOrElse(j ) { '.' }
}

fun main(args: Array<String>) {
    println(ceres("day04.txt".asResource()))
    println(ceres2("day04.txt".asResource()))
}
