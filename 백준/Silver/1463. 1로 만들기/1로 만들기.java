import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int mem[];






    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        mem=new int[N+1];

        mem[1]=0;

        for(int i=2;i<=N;i++){
            int tmp=mem[i-1]+1;
            if(i%3==0)tmp=Math.min(tmp,mem[i/3]+1);
            if(i%2==0)tmp=Math.min(tmp,mem[i/2]+1);
            mem[i]=tmp;
        }

        bw.write(String.valueOf(mem[N]));








        bw.flush();
        br.close();
        bw.close();








    }















}
