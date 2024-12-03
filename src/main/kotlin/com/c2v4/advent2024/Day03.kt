package com.c2v4.advent2024

fun mull(input: String): Int = Regex("mul\\((\\d{1,3}),(\\d{1,3})\\)").findAll(input).map {
    it.groupValues[1].toInt() * it.groupValues[2].toInt()
}.sum()

fun mull2(input: String): Int = mull(Regex("don't\\(\\)(.*?)(?=do\\(\\)|\$)").replace(input.replace("\n", ""), ""))

fun main(args: Array<String>) {
    println(mull("day03.txt".asResource()))
    println(mull2("day03.txt".asResource()))
}
