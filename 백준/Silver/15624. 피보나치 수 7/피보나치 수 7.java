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
        Arrays.fill(mem,-1);


        bw.write(String.valueOf(fib(N)));







        bw.flush();
        br.close();
        bw.close();








    }


    private static int fib(int n){

        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(mem[n]!=-1){
            return mem[n];
        }

        return mem[n]=(fib(n-1)+fib(n-2))%1000000007;
    }












}
