/**
 * Java provides us facility to create our own exceptions which are basically derived classes of Exception.
 * For example MyException in below code extends the Exception class.
 *
 * We pass the string to the constructor of the super class- Exception
 * which is obtained using “getMessage()” function on the object created.
 */

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


