package lec06;

public class TestCashRegister {
    public static void main(String[] args) {
        lec.lec06.CashRegister cr = new lec.lec06.CashRegister(0.07);

        cr.addNontaxableItem(5.00);
        System.out.printf("The total should be 5.00 -- it is: %5.2f\n",
                cr.getTotal());
        cr.addNontaxableItem(1.00);
        System.out.printf("The total should be 6.00 -- it is: %5.2f\n",
                cr.getTotal());

        cr.addTaxableItem(1.00);
        System.out.printf("The total should be 7.07 -- it is: %5.2f\n",
                cr.getTotal());

        System.out.printf("Your total purchase was: %5.2f\n", cr.getSubTotal());
        System.out.printf("Your total tax was: %5.2f\n", cr.getTaxTotal());
        System.out.printf("So you own me: %5.2f\n", cr.getTotal());

    }
}