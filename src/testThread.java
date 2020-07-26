public class testThread extends Thread {
    public void run() {
        System.out.println("Test Thread1");
    }

    public static void main(String[] args) {
        (new testThread()).run();
    }
}
