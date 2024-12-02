package com.c2v4.advent2024

import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions

class Day02Test : AnnotationSpec() {
    @Test
    fun test() {
        Assertions.assertThat(
            redNosed("7 6 4 2 1\n" +
                    "1 2 7 8 9\n" +
                    "9 7 6 2 1\n" +
                    "1 3 2 4 5\n" +
                    "8 6 4 4 1\n" +
                    "1 3 6 7 9")
        ).isEqualTo(2)
    }

    @Test
    fun testPlus() {
        Assertions.assertThat(
            redNosed2("7 6 4 2 1\n" +
                    "1 2 7 8 9\n" +
                    "9 7 6 2 1\n" +
                    "1 3 2 4 5\n" +
                    "8 6 4 4 1\n" +
                    "1 3 6 7 9")
        ).isEqualTo(4)
    }
}
