package com.c2v4.advent2024

import kotlin.math.abs

// find all matches of regex mul\((\d{1,3}),(\d{1,3})\) and return the sum of x*y
fun mull(input: String): Int = Regex("mul\\((\\d{1,3}),(\\d{1,3})\\)").findAll(input).map {
    it.groupValues[1].toInt() * it.groupValues[2].toInt()
}.sum()

//remove from string parts between "don't()" and ("do()" or end of the string) and then find all matches of regex mul\((\d{1,3}),(\d{1,3})\) and return the sum of x*y
fun mull2(input: String): Int = Regex("don't\\(\\)(.*?)(?=do\\(\\)|\$)").replace(input.replace("\n",""), "").let {
    Regex("mul\\((\\d{1,3}),(\\d{1,3})\\)").findAll(it).map {
        it.groupValues[1].toInt() * it.groupValues[2].toInt()
    }.sum()
}

fun main(args: Array<String>) {
    println(mull("day03.txt".asResource()))
    println(mull2("day03.txt".asResource()))
}
