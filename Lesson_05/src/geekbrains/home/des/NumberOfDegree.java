package geekbrains.home.des;

public class NumberOfDegree {
    public static void main(String[] args) {
        System.out.println(pow(2, 5));
    }

    private static int pow(int number, int exponent){
        if (exponent < 0){
            throw new IllegalArgumentException("the degree of the number cannot be less than 0");
        }

        if (exponent == 0){
            return 1;
        }

        return number * pow(number, exponent-1);
    }

}
