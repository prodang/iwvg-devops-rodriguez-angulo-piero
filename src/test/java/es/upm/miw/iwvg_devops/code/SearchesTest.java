package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchesTest {

    @Test
    void testFindDecimalFractionByUserName(){
        assertEquals(List.of(2.0, -0.2, 0.5, 1.3333333333333333), new Searches().findDecimalFractionByUserName("Ana")
                .collect(Collectors.toList()));
    }

    @Test
    void testFindFractionSubtractionByUserName(){
        Fraction result = new Searches().findFractionSubtractionByUserName("Oscar");
        assertEquals(21, result.getNumerator());
        assertEquals(-5, result.getDenominator());
    }

    @Test
    void testFindFirstProperFractionByUserId(){
        Fraction result = new Searches().findFirstProperFractionByUserId("5");
        assertEquals(0, result.getNumerator());
        assertEquals(1, result.getDenominator());
    }
}
