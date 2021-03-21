import java.io.*;

public class Intro3 {
    public static void main(String[] args) throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        String s = br.readLine();
        int a = Integer.parseInt(s);

        s = br.readLine();
        int b = Integer.parseInt(s);

        int c = a + b;
        System.out.println("Sum of " + a + " and " + b + " is " + c);
    }
}
