package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FractionTest {

    private Fraction fraction;
    @BeforeEach
    void before() {
        this.fraction = new Fraction(1,2);
    }

    @Test
    void testFractionIntInt() {
        assertEquals(1, this.fraction.getNumerator());
        assertEquals(2, this.fraction.getDenominator());
    }

    @Test
    void testFraction(){
        this.fraction = new Fraction();
        assertEquals(1, this.fraction.getNumerator());
        assertEquals(1, this.fraction.getDenominator());
    }

    @Test
    void testDecimal(){
        this.fraction.setNumerator(2);
        this.fraction.setDenominator(4);
        assertEquals(0.5 , this.fraction.decimal());
    }
}
