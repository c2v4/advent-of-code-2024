package com.c2v4.advent2024

import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions

class Day03Test : AnnotationSpec() {
    @Test
    fun test() {
        Assertions.assertThat(
            mull("xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))")
        ).isEqualTo(161)
    }

    @Test
    fun testPlus() {
        Assertions.assertThat(
            mull2("xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))")
        ).isEqualTo(48)
    }
}
