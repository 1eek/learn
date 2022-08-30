package _3分数的加减乘除;

import java.util.Scanner;

class Fraction{
    private int molecule; //分子
    private int denominator; //分母
    public Fraction(){
        this.molecule = 1;
        this.molecule = 1;
    }
    public Fraction(int molecule,int denominator) {
        this.molecule = molecule;
        this.denominator = denominator;
    }
    public int getMolecule() {
        return molecule;
    }

    public void setMolecule(int molecule) {
        this.molecule = molecule;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }
}

public class test03{
    private static Fraction a,b;
    static Scanner sc = new Scanner(System.in);

    //最大公约数方法  (辗转相除法)
    public static int greatTestCommonDivispr(int a,int b){
        return (a % b == 0) ? b : greatTestCommonDivispr(b,a%b);
    }

    //约分
    public static Fraction yuefeng(int molecule,int denominator){
        int result_CommonDivispr = greatTestCommonDivispr(Math.abs(molecule),Math.abs(denominator));
        molecule /= result_CommonDivispr;
        denominator /= result_CommonDivispr;
        if(denominator<0){
            return new Fraction(molecule*(-1),Math.abs(denominator));
        }
        return new Fraction(molecule,denominator);
    }

    public static Fraction Add(Fraction a, Fraction b){
        int molecule = a.getMolecule()*b.getDenominator()+b.getMolecule()*a.getDenominator();
        int denominator = a.getDenominator()*b.getDenominator();

        return yuefeng(molecule,denominator);
    }
    public static Fraction Sub(Fraction a, Fraction b){
        int molecule = (a.getMolecule()*b.getDenominator())-(b.getMolecule()*a.getDenominator());
        int denominator = a.getDenominator()*b.getDenominator();

        return yuefeng(molecule,denominator);
    }
    public static Fraction Mul(Fraction a, Fraction b){
        int molecule = a.getMolecule()*b.getMolecule();
        int denominator = a.getDenominator()*b.getDenominator();

        return yuefeng(molecule,denominator);
    }
    public static Fraction Div(Fraction a, Fraction b){
        int molecule = a.getMolecule()*b.getDenominator();
        int denominator = a.getDenominator()*b.getMolecule();

        return yuefeng(molecule,denominator);
    }

    public static void main(String[] args) {
        Fraction a = new Fraction(5,15);
        a = yuefeng(a.getMolecule(),a.getDenominator());
        System.out.println("a =" + a.getMolecule() +"/" + a.getDenominator());
        Fraction b = new Fraction(-2,4);
        b = yuefeng(b.getMolecule(),b.getDenominator());
        System.out.println("b =" + b.getMolecule() +"/" + b.getDenominator());
        System.out.println("a + b =" + Add(a,b).getMolecule() + "/" + Add(a,b).getDenominator());
        System.out.println("a - b =" + Sub(a,b).getMolecule() + "/" + Sub(a,b).getDenominator());
        System.out.println("a * b =" + Mul(a,b).getMolecule() + "/" + Mul(a,b).getDenominator());
        System.out.println("a - b =" + Div(a,b).getMolecule() + "/" + Div(a,b).getDenominator());
    }

}