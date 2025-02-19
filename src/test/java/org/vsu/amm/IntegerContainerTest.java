package org.vsu.amm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * IntegerContainerTest: class for container's testing using JUnit tool
 */
class IntegerContainerTest {
    private IntegerContainer container;

    /**
     * setting up the container before each test with default constructor
     */
    @BeforeEach
    void setUp() {
        container = new IntegerContainer();
    }

    /**
     * testing adding and peeking elements
     */
    @Test
    void testAddAndGet() {
        container.add(10);
        container.add(20);
        assertEquals(10, container.elementAt(0));
        assertEquals(20, container.elementAt(1));
    }

    /**
     * Testing getting container's size
     */
    @Test
    void testSize() {
        assertEquals(0, container.size());
        container.add(1);
        assertEquals(1, container.size());
    }

    /**
     * Test check is container empty
     */
    @Test
    void testIsEmpty() {
        assertTrue(container.isEmpty());
        container.add(5);
        assertFalse(container.isEmpty());
    }

    /**
     * Testing elements' removal
     */
    @Test
    void testRemove() {
        container.add(10);
        container.add(20);
        container.add(25);
        container.remove(1);
        assertEquals(2, container.size());
        assertEquals(10, container.elementAt(0));
        assertEquals(25, container.elementAt(1));
    }

    /**
     * Testing range of elements removal
     */
    @Test
    void testRemoveRange() {
        container.add(10);
        container.add(20);
        container.add(25);
        container.add(30);
        container.add(50);
        container.removeRange(1, 2);
        assertEquals(3, container.size());
        assertEquals(10, container.elementAt(0));
        assertEquals(30, container.elementAt(1));
        assertEquals(50, container.elementAt(2));
    }

    /**
     * Test clearing of the container
     */
    @Test
    void testClear() {
        container.add(10);
        container.add(20);
        container.add(30);
        container.clear();

        assertTrue(container.isEmpty());
        assertEquals(0, container.size());
    }
}
