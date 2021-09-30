package es.upm.miw.iwvg_devops.code;

public class Fraction {

    private int numerator;

    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction() {
        this(1, 1);
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public double decimal() {
        return (double) numerator / denominator;
    }

    public boolean isProper(){
        return this.numerator < this.denominator;
    }

    public boolean isImproper(){
        return this.numerator > this.denominator;
    }

    public boolean isEquivalent(Fraction fraction){
        return ((this.numerator * fraction.getDenominator()) == (this.denominator * fraction.getNumerator()));
    }

    public Fraction add(Fraction fraction){
        return new Fraction(((this.getNumerator() * fraction.getDenominator())+(this.getDenominator() * fraction.getNumerator())),
                this.getDenominator() * fraction.getDenominator());
    }

    public Fraction multiply(Fraction fraction){
        return new Fraction(this.getNumerator() * fraction.getNumerator(),
                this.getDenominator() * fraction.getDenominator());
    }

    public Fraction divide(Fraction fraction){
        return new Fraction(this.getNumerator() * fraction.getDenominator(),
                this.getDenominator() * fraction.getNumerator());
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}
