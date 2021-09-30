package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {
    private User user;

    @BeforeEach
    void before() {
        user = new User("1", "Juan", "Perez", null);
    }

    @Test
    void testUserStringString() {
        assertEquals("1",this.user.getId());
        assertEquals("Juan",this.user.getName());
        assertEquals("Perez",this.user.getFamilyName());
    }

    @Test
    void testUser() {
        this.user = new User();
        assertEquals(new ArrayList<>(),this.user.getFractions());
    }

    @Test
    void testFullName(){
        this.user.setFamilyName("Rodriguez");
        assertEquals(this.user.getName()+" "+this.user.getFamilyName(),this.user.fullName());
    }

    @Test
    void testInitials(){
        this.user.setName("Piero");
        assertEquals("P.",this.user.initials());
    }

    @Test
    void testAddFractions(){
        this.user.setFractions(new ArrayList<>());
        this.user.addFraction(new Fraction(1,2));
        assertEquals(1,this.user.getFractions().size());
    }
}
