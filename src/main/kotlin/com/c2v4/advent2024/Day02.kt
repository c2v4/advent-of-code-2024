package com.c2v4.advent2024

import kotlin.math.abs

fun redNosed(input: String): Int = input.split(EOL).map { line ->
    line.split(" ").map { it.toInt() }
}.count {
    val zipWithNext = it.zipWithNext()
    isSafe(zipWithNext)
}

private fun isSafe(zipWithNext: List<Pair<Int, Int>>) =
    zipWithNext.all { (a, b) -> (a < b) && abs(a - b) > 0 && abs(a - b) < 4 } || zipWithNext.all { (a, b) ->
        (a > b) && abs(
            a - b
        ) > 0 && abs(a - b) < 4
    }

fun redNosed2(input: String): Int = input.split(EOL).map { line ->
    line.split(" ").map { it.toInt() }
}.count { report ->
    List(report.size) { index -> report.filterIndexed { i, _ -> i != index }.zipWithNext() }.any {
        isSafe(it)
    }
}

fun main(args: Array<String>) {
    println(redNosed("day02.txt".asResource()))
    println(redNosed2("day02.txt".asResource()))
}
