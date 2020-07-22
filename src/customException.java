class MyException extends Exception {
    public MyException(String s){
        super(s);
    }
}

public class customException {

    public static void main(String[] args) {
        try {
            throw new MyException("Test error");
        }
        catch(MyException ex) {
            System.out.println("Caught");
            System.out.println(ex.getMessage());
        }
    }
}
