package com.c2v4.advent2024

import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions

class Day04Test : AnnotationSpec() {
    @Test
    fun test() {
        Assertions.assertThat(
            ceres("MMMSXXMASM\n" +
                    "MSAMXMSMSA\n" +
                    "AMXSXMAAMM\n" +
                    "MSAMASMSMX\n" +
                    "XMASAMXAMM\n" +
                    "XXAMMXXAMA\n" +
                    "SMSMSASXSS\n" +
                    "SAXAMASAAA\n" +
                    "MAMMMXMMMM\n" +
                    "MXMXAXMASX")
        ).isEqualTo(18)
    }

    @Test
    fun testPlus() {
        Assertions.assertThat(
            ceres2("MMMSXXMASM\n" +
                    "MSAMXMSMSA\n" +
                    "AMXSXMAAMM\n" +
                    "MSAMASMSMX\n" +
                    "XMASAMXAMM\n" +
                    "XXAMMXXAMA\n" +
                    "SMSMSASXSS\n" +
                    "SAXAMASAAA\n" +
                    "MAMMMXMMMM\n" +
                    "MXMXAXMASX")
        ).isEqualTo(48)
    }
}
