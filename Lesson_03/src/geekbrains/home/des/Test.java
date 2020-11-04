package geekbrains.home.des;

import geekbrains.home.des.stack.StackImpl;

public class Test {
    public static void main(String[] args) {
        String test = "test";

        StackImpl<Character> testStr = new StackImpl<>(test.length());
        for (int i = 0; i < test.length(); i++) {
            testStr.push(test.charAt(i));
        }
        while (!testStr.isEmpty()){
            System.out.print(testStr.pop());
        }
    }
}
