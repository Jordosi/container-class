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

    /**
     * Testing the exception throw while trying to get element at index
     */
    @Test
    void testElementAtThrowsIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> container.elementAt(0));
        container.add(10);
        assertThrows(IndexOutOfBoundsException.class, () -> container.elementAt(1));
    }

    /**
     * Test the exception throw when removing element
     */
    @Test
    void testRemoveThrowsIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> container.remove(0));
        container.add(10);
        assertThrows(IndexOutOfBoundsException.class, () -> container.remove(1));
    }

    /**
     * Test the exception throw when removing range of elements
     */
    @Test
    void testRemoveRangeThrowsIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> container.removeRange(0, 1));
        container.add(10);
        assertThrows(IndexOutOfBoundsException.class, () -> container.removeRange(1, 1));
        assertThrows(IndexOutOfBoundsException.class, () -> container.removeRange(0, 2));
    }

    /**
     * Test adjusting capacity
     */
    @Test
    void testAdjustCapacity() {
        for (int i = 0; i < 15; i++) {
            container.add(i);
        }
        assertEquals(15, container.size());
        assertEquals(14, container.elementAt(14));
    }

    /**
     * Testing string view
     */
    @Test
    void testToString() {
        assertEquals("[]", container.toString()); // empty container

        container.add(10);
        assertEquals("[10]", container.toString()); // 1 element

        container.add(20);
        container.add(30);
        assertEquals("[10, 20, 30]", container.toString()); // several elements
    }
}
