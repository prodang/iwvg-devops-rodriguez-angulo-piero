package es.upm.miw.iwvg_devops.code;

import org.apache.logging.log4j.LogManager;

import java.util.stream.Stream;

public class Searches {
    public Stream<Double> findDecimalFractionByUserName(String name) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getName().equals(name))
                .flatMap(user -> user.getFractions().stream())
                .map(Fraction::decimal);
    }

    public Fraction findFractionSubtractionByUserName(String name) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getName().equals(name))
                .flatMap(user -> user.getFractions().stream())
                .reduce(new Fraction(0,0), (fraction, fraction2) -> fraction.subtract(fraction2));

    }

    public Fraction findFirstProperFractionByUserId(String id) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getId().equals(id))
                .flatMap(user -> user.getFractions().stream())
                .filter(fraction -> fraction.isProper())
                .findFirst().orElseThrow();
    }
}
