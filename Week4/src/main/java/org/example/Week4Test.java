import org.junit.Test;
import static org.junit.Assert.*;
public class Week4Test {

    @Test
    public void testMax2Int1() {
        assertEquals(5, Week4.max2Int(-100, 5));
    }

    @Test
    public void testMax2Int2() {
        assertEquals(-2, Week4.max2Int(-5, -2));
    }

    @Test
    public void testMax2Int3() {
        assertEquals(10, Week4.max2Int(10, 10));
    }

    @Test
    public void testMax2Int4() {
        assertEquals(100, Week4.max2Int(-50, 100));
    }

    @Test
    public void testMax2Int5() {
        assertEquals(0, Week4.max2Int(-10, 0));
    }

    @Test
    public void testMinArray1() {
        int[] array = {-100, 0, 5, 10};
        assertEquals(-100, Week4.minArray(array));
    }

    @Test
    public void testMinArray2() {
        int[] array = {5, 10, 20};
        assertEquals(5, Week4.minArray(array));
    }

    @Test
    public void testMinArray3() {
        int[] array = {-10, -20, -5};
        assertEquals(-20, Week4.minArray(array));
    }

    @Test
    public void testMinArray4() {
        int[] array = {42};
        assertEquals(42, Week4.minArray(array));
    }

    @Test
    public void testMinArray5() {
        int[] array = {3, 3, 3};
        assertEquals(3, Week4.minArray(array));
    }

    // ===== calculateBMI =====
    @Test
    public void testCalculateBMI1() {
        assertEquals("Thiếu cân", Week4.calculateBMI(45, 1.70));
    }

    @Test
    public void testCalculateBMI2() {
        assertEquals("Bình thường", Week4.calculateBMI(55, 1.64));
    }

    @Test
    public void testCalculateBMI3() {
        assertEquals("Thừa cân", Week4.calculateBMI(70, 1.70));
    }

    @Test
    public void testCalculateBMI4() {
        assertEquals("Béo phì", Week4.calculateBMI(90, 1.70));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateBMI5() {
        Week4.calculateBMI(60, 0); // height = 0
    }
}