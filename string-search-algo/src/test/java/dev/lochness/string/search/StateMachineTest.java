package dev.lochness.string.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StateMachineTest {

    private StateMachine stateMachine;

    @BeforeEach
    void setUp() {
        stateMachine = new StateMachine();
    }

    @Test
    void findTrue() {
        int expected = 12;
        int actual = stateMachine.find("a long long string", "string");
        assertEquals(expected, actual);
    }

    @Test
    void findFalse() {
        int expected = -1;
        int actual = stateMachine.find("a long long string", "short");
        assertEquals(expected, actual);
    }
}