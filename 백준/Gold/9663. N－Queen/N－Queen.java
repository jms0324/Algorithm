

import java.io.*;

public class Main {
    static int arr[];
    static int count=0;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));



        N=Integer.parseInt(br.readLine());
        arr=new int[N];
        backtracking(0);
        bw.write(String.valueOf(count));

        bw.flush();
        bw.close();







    }

    static void backtracking(int depth){
        if(depth==N){
            count++;
            return;
        }


        for(int i=0;i<N;i++){
            arr[depth]=i;
            if(check(depth)){
                backtracking(depth+1);
            }
        }


    }
    static boolean check(int col){


        for(int i=0;i<col;i++){
            if(arr[col]==arr[i]){
                return false;
            }

            if(Math.abs(arr[col]-arr[i])==Math.abs(col-i)){
                return false;
            }
        }

        return true;
    }



}
