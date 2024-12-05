package com.c2v4.advent2024

open class Day {

    open fun part1(input: String): Any = TODO()

    open fun part2(input: String): Any = TODO()

    fun run() {
        val className = "${this.javaClass.simpleName.lowercase()}.txt"
        // load input file from resources that has name className
        val input = this.javaClass.classLoader.getResource(className)?.readText()
            ?: throw IllegalArgumentException("Resource not found: $className")
        println(part1(input))
        println(part2(input))
    }

}