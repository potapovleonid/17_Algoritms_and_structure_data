package geekbrains.home.des;

public class CustomIndexOfBoundException extends RuntimeException{

    public CustomIndexOfBoundException(int index, int size) {
        super(String.format("Invalid index %d for array with length %d", index, size));
    }
}
