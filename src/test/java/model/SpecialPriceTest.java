package model;

import exceptions.SpecialPriceException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class SpecialPriceTest {

    @Test
    public void specialPriceCorrectSplit() {
        SpecialPrice specialPrice = new SpecialPrice("3 for 4.25");
        assertEquals(specialPrice.getItemCount(), Double.valueOf(3));
        assertEquals(specialPrice.getItemPrice(), Double.valueOf(4.25));
    }

    @Test
    public void specialPriceInvalidSplit() {
        assertThrows(SpecialPriceException.class, () -> new SpecialPrice("2,0"));
    }

    @Test
    public void specialPriceNullSplit() {
        assertThrows(SpecialPriceException.class, () -> new SpecialPrice(null));
    }
}