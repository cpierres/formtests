package com.cpi.formtests;

import org.hamcrest.Matchers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestAssertThatHamcrest {
    public static void main(String[] args) {
        assertThat(1 + 2, is(Matchers.equalTo(4)));
    }
}
