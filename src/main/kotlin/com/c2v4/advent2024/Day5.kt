package com.c2v4.advent2024

import arrow.fx.coroutines.Race3

object Day5 : Day() {
    override fun part1(input: String): Any {
        val split = input.split(PARAGRAPH)
        val orderMap = split[0].split(EOL)
            .associate { it.split("|").map { it.toInt() }.let { (first, second) -> Pair(first, second) } }
        val pages = split[1].split(EOL).map { it.split(",").map { it.toInt() } }
        return pages.filter { isCorrectOrder(it, orderMap) }.sumOf { findMiddle(it) }
    }

    private fun isCorrectOrder(list: List<Int>, orderMap: Map<Int, Int>): Boolean {
        val alreadyPrinted = mutableSetOf<Int>()
        for (i in list) {
            if (alreadyPrinted.contains(orderMap.getOrDefault(i, -1))) {
                return false
            }
            alreadyPrinted.add(i)
        }
        return true
    }

    private fun findMiddle(list: List<Int>): Int {
        val size = list.size
        val middle = size / 2
        return if (size % 2 == 0) {
            (list[middle] + list[middle - 1]) / 2
        } else {
            list[middle]
        }
    }

    override fun part2(input: String): Any {
        val split = input.split(PARAGRAPH)
        val orderMap = split[0].split(EOL)
            .associate { it.split("|").map { it.toInt() }.let { (first, second) -> Pair(first, second) } }
        val pages = split[1].split(EOL).map { it.split(",").map { it.toInt() } }
        return pages.filter { !isCorrectOrder(it, orderMap) }
            .map { orderCorrectly(it, orderMap) }
            .sumOf { findMiddle(it) }
    }

    fun orderCorrectly(list: List<Int>, orderMap: Map<Int, Int>): List<Int> {
        val toReturn = list.toMutableList()
        while (!isCorrectOrder(toReturn, orderMap)) {
            val alreadyPrinted = mutableSetOf<Int>()
            for (i in toReturn) {
                val shouldBeAfter = orderMap.getOrDefault(i, -1)
                if (alreadyPrinted.contains(shouldBeAfter)) {
                    toReturn.swapElements(i, shouldBeAfter)
                }
                alreadyPrinted.add(i)
            }
        }
        return toReturn
    }

}

private fun <E> MutableList<E>.swapElements(first: E, second: E) {
    val firstIndex = indexOf(first)
    val secondIndex = indexOf(second)
    this[firstIndex] = second
    this[secondIndex] = first
}

fun main(args: Array<String>) {
    Day5.run()
}
