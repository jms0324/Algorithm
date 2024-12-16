import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    static int N=0;
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String [] args )throws IOException{



        int n=Integer.parseInt(br.readLine());

        bw.write(String.valueOf((1<<n)-1));
        bw.newLine();

        Hanoi(1,3,n);

        bw.flush();
        bw.close();









    }


    static void Hanoi(int a,int b,int n) throws IOException{

        if(n==1){
            bw.write(String.valueOf(a)+" "+String.valueOf(b));
            bw.newLine();
            return ;
        }
        Hanoi(a,6-a-b,n-1);
        bw.write(String.valueOf(a)+" "+String.valueOf(b));
        bw.newLine();
        Hanoi(6-a-b,b,n-1);




    }
}

