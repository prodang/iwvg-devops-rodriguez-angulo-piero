package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    void testIsProper(){
        assertTrue(this.fraction.isProper());
    }

    @Test
    void testIsImproper(){
        fraction = new Fraction(6,5);
        assertTrue(this.fraction.isImproper());
    }

    @Test
    void testIsEquivalent(){
        Fraction fraction = new Fraction(1,2);
        assertTrue(this.fraction.isEquivalent(fraction));
    }

    @Test
    void testAdd(){
        Fraction add = this.fraction.add(new Fraction(1,3));
        Fraction result = new Fraction(5,6);
        assertEquals( add.getNumerator(), result.getNumerator());
        assertEquals( add.getDenominator(), result.getDenominator());
    }

    @Test
    void testMultiply(){
        Fraction multiply = this.fraction.multiply(new Fraction(2,3));
        Fraction result = new Fraction(2,6);
        assertEquals( multiply.getNumerator(), result.getNumerator());
        assertEquals( multiply.getDenominator(), result.getDenominator());
    }

    @Test
    void testDivide(){
        Fraction divide = this.fraction.divide(new Fraction(3,2));
        Fraction result = new Fraction(2,6);
        assertEquals( divide.getNumerator(), result.getNumerator());
        assertEquals( divide.getDenominator(), result.getDenominator());
    }
}
