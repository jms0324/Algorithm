import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int kim;
    static int soo;
    static int cnt;






    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String s=br.readLine();

        N=Integer.parseInt(s.split(" ")[0]);
        kim=Integer.parseInt(s.split(" ")[1]);
        soo=Integer.parseInt(s.split(" ")[2]);
        int cnt=0;


        while(kim!=soo){

            kim=kim/2+kim%2;
            soo=soo/2+soo%2;
            cnt++;
        }



        bw.write(String.valueOf(cnt));



        bw.flush();
        br.close();
        bw.close();








    }












}
