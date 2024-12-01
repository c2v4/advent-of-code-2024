package com.c2v4.advent2023

import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions

class Day01Test : AnnotationSpec() {
    @Test
    fun test() {
        Assertions.assertThat(
            historian("3   4\n" +
                    "4   3\n" +
                    "2   5\n" +
                    "1   3\n" +
                    "3   9\n" +
                    "3   3")
        ).isEqualTo(11)
    }

    @Test
    fun testPlus() {
        Assertions.assertThat(
            historian2("3   4\n" +
                    "4   3\n" +
                    "2   5\n" +
                    "1   3\n" +
                    "3   9\n" +
                    "3   3")
        ).isEqualTo(31)
    }
}
