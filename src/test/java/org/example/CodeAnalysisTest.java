package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CodeAnalysisTest {
    @Test
    void main() {
        assertDoesNotThrow(() -> {
            String[] args = {};
            CodeAnalysis.main(args);
        });
    }

    @Test
    void sumOfValues() {
        assertEquals(5, CodeAnalysis.sumOfValues(2, 3));
        assertNotEquals(6, CodeAnalysis.sumOfValues(2, 3));
    }

    @Test
    void subOfValues() {
        assertEquals(2, CodeAnalysis.subOfValues(5, 3));
        assertNotEquals(3, CodeAnalysis.subOfValues(5, 3));
    }

    @Test
    void divOfValues() {
        assertEquals(2, CodeAnalysis.divOfValues(6, 3));
        assertNotEquals(3, CodeAnalysis.divOfValues(6, 3));

        assertThrows(IllegalArgumentException.class, () ->
            CodeAnalysis.divOfValues(5, 0)
        );
    }

    @Test
    void mulOfValues() {
        assertEquals(15, CodeAnalysis.mulOfValues(5, 3));
        assertNotEquals(10, CodeAnalysis.mulOfValues(5, 3));
    }
}