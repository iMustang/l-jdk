import java.util.Random;

public class App1 {
    public static void main(String[] args) {
        char c ='中';
        Character c1 = 65535;
        short s = (short)65535;
        System.out.println(s);
        c1.charValue();
        System.out.println(new Integer(c1));

        Random random = new Random();
        random.nextInt();
    }
}
