package com.c2v4.advent2023

import kotlin.math.abs

fun historian(input: String): Int {
    val (list1, list2) = input.split(EOL)
        .map { it.split(Regex("\\s+")).map(String::toInt).let { it[0] to it[1] } }
        .unzip()
    val sortedList1 = list1.sorted()
    val sortedList2 = list2.sorted()
    return sortedList1.zip(sortedList2) { a, b -> abs(a - b)}.sum()
}

fun historian2(input: String): Int {
    val (list1, list2) = input.split(EOL)
        .map { it.split(Regex("\\s+")).map(String::toInt).let { it[0] to it[1] } }
        .unzip()
    val sortedList1 = list1.sorted()
    val sortedList2 = list2.sorted()
    val countMap = list2.groupingBy { it }.eachCount()
    return list1.sumOf { it * (countMap[it] ?: 0) }
}

fun main(args: Array<String>) {
    println(historian("day01.txt".asResource()))
    println(historian2("day01.txt".asResource()))
}
