import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int mem[];






    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));


        N=Integer.parseInt(br.readLine());
        int countf=0;
        int count=0;
        if(N==1 || N==3){
            bw.write(String.valueOf(-1));
            bw.flush();
            bw.close();
            return;
        }

        int left=N%5;



        if(left==0){
            bw.write(String.valueOf(N/5));
            bw.flush();
            bw.close();
            return;


        }

        if(left%2==0){
            bw.write(String.valueOf(N/5+left/2));
        } else{
            bw.write(String.valueOf(N/5-1+(left+5)/2));
        }







        bw.flush();
        br.close();
        bw.close();








    }















}
