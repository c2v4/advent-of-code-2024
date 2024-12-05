package com.c2v4.advent2024

import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions

class Day5Test : AnnotationSpec() {

    private val day = Day5

    @Test
    fun test() {
        Assertions.assertThat(
            day.part1("47|53\n" +
                    "97|13\n" +
                    "97|61\n" +
                    "97|47\n" +
                    "75|29\n" +
                    "61|13\n" +
                    "75|53\n" +
                    "29|13\n" +
                    "97|29\n" +
                    "53|29\n" +
                    "61|53\n" +
                    "97|53\n" +
                    "61|29\n" +
                    "47|13\n" +
                    "75|47\n" +
                    "97|75\n" +
                    "47|61\n" +
                    "75|61\n" +
                    "47|29\n" +
                    "75|13\n" +
                    "53|13\n" +
                    "\n" +
                    "75,47,61,53,29\n" +
                    "97,61,53,29,13\n" +
                    "75,29,13\n" +
                    "75,97,47,61,53\n" +
                    "61,13,29\n" +
                    "97,13,75,29,47")
        ).isEqualTo(143)
    }

    @Test
    fun testPlus() {
        Assertions.assertThat(
            day.part2("47|53\n" +
                    "97|13\n" +
                    "97|61\n" +
                    "97|47\n" +
                    "75|29\n" +
                    "61|13\n" +
                    "75|53\n" +
                    "29|13\n" +
                    "97|29\n" +
                    "53|29\n" +
                    "61|53\n" +
                    "97|53\n" +
                    "61|29\n" +
                    "47|13\n" +
                    "75|47\n" +
                    "97|75\n" +
                    "47|61\n" +
                    "75|61\n" +
                    "47|29\n" +
                    "75|13\n" +
                    "53|13\n" +
                    "\n" +
                    "75,47,61,53,29\n" +
                    "97,61,53,29,13\n" +
                    "75,29,13\n" +
                    "75,97,47,61,53\n" +
                    "61,13,29\n" +
                    "97,13,75,29,47")
        ).isEqualTo(123)
    }
}
