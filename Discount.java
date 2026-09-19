public class Discount{
    public static void main(String args[]){
        double originalPrice = 40000;
        double discountRate = 0.15;
        double discountedAmount = originalPrice * discountRate;
        System.out.println("discount=" + discountedAmount);
        double finalPrice = originalPrice - discountedAmount;
        System.out.println("finalPrice=" + finalPrice);
        
    }
}



    



