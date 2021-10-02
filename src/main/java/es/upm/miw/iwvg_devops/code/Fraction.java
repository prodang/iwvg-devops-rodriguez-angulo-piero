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

    private int mcd(int a, int b) {
        int temp;
        while (b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private int mcm(int a, int b) {
        return (a * b) / mcd(a, b);
    }

    private int partial(int mcm, Fraction fraction){
        return (mcm/fraction.getDenominator())*fraction.getNumerator();
    }

    private boolean isInitial(){
        return (this.getNumerator() == 0) && (this.getDenominator() == 0);
    }

    private Fraction simplify(Fraction fraction){
        int mcd = this.mcd(fraction.getDenominator(),fraction.getNumerator());
        return new Fraction(fraction.getNumerator()/mcd,fraction.getDenominator()/mcd);
    }

    public Fraction sub(Fraction fraction){
        int mcm = this.mcm(this.getDenominator(), fraction.getDenominator());
        return new Fraction(partial(mcm,this)-(partial(mcm,fraction)),mcm);
    }

    public Fraction add(Fraction fraction){
        int mcm = this.mcm(this.getDenominator(), fraction.getDenominator());
        return simplify(new Fraction(partial(mcm,this)+(partial(mcm,fraction)),mcm));
    }

    public Fraction subtract(Fraction fraction){
        return this.isInitial() ? fraction : simplify(sub(fraction));
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
