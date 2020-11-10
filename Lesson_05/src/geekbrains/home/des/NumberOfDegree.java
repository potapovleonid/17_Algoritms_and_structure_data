package geekbrains.home.des;

public class NumberOfDegree {

    private static int pow(int number, int exponent){
        if (exponent < 0){
            throw new IllegalArgumentException("the degree of the number cannot be less than 0");
        }

        if (exponent == 0){
            return 1;
        }

        return pow(number, exponent-1);
    }

}
