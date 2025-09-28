import java.util.Scanner;

/**
 * duytruong.
 */
public class Solution {
    /**
     * duytruong.
     */
    private int numerator;
    /**
     * duytruong.
     */
    private int denominator;

    /**
     * duytruong.
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * duytruong.
     */
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    /**
     * duytruong.
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * duytruong.
     */
    public void setDenominator(int denominator) {
        if (denominator != 0) {
            this.denominator = denominator;
        }
    }


    /**
     * duytruong.
     */
    public Solution() {
        numerator = 0;
        denominator = 1;
    }

    /**
     * duytruong.
     */
    public Solution(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = 1;
        if (denominator != 0) {
            this.denominator = denominator;
        }
    }

    /**
     * duytruong.
     */
    public int gcd(int a, int b) {
        if (a < 0) {
            a = -a;
        }
        if (b < 0) {
            b = -b;
        }
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    /**
     * duytruong.
     */
    public void reduce() {
        if (this.denominator < 0) {
            this.denominator = -this.denominator;
            this.numerator = -this.numerator;
        }
        int tg = gcd(this.numerator, this.denominator);
        this.numerator /= tg;
        this.denominator /= tg;
    }

    /**
     * duytruong.
     */
    public Solution add(Solution s) {
        Solution res = new Solution();
        res.numerator = this.numerator * s.denominator + s.numerator * this.denominator;
        res.denominator = this.denominator * s.denominator;
        res.reduce();
        return res;
    }

    /**
     * duytruong.
     */
    public Solution subtract(Solution s) {
        Solution res = new Solution();
        res.numerator = this.numerator * s.denominator - s.numerator * this.denominator;
        res.denominator = this.denominator * s.denominator;
        res.reduce();
        return res;
    }

    /**
     * duytruong.
     */
    public Solution multiply(Solution s) {
        Solution res = new Solution();
        res.numerator = this.numerator * s.numerator;
        res.denominator = this.denominator * s.denominator;
        res.reduce();
        return res;
    }

    /**
     * duytruong.
     */
    public Solution divide(Solution s) {
        Solution res = new Solution();
        res.numerator = this.numerator * s.denominator;
        res.denominator = this.denominator * s.numerator;
        res.reduce();
        return res;
    }

    /**
     * duytruong.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Solution)) {
            return false;
        }
        Solution other = (Solution) obj;
        return this.numerator * other.denominator == other.numerator * this.denominator;
    }

}
