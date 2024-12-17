import java.io.*;
import java.util.StringTokenizer;

public class Main{


    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;


    static boolean isused1[]=new boolean[40];
    static boolean isused2[]=new boolean[40];
    static boolean isused3[]=new boolean[40];
    static int cnt=0;




    public static void main(String[] args) throws IOException {

        N=Integer.parseInt(br.readLine());
        nqueen(0);
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();






    }


    static void nqueen(int cur){

        if(cur==N){
            cnt++;
            return;
        }

        for(int i=0;i<N;i++){
            if(isused1[i] || isused2[cur+i] || isused3[cur-i+N-1])continue;

            isused1[i]=true;
            isused2[i+cur]=true;
            isused3[cur-i+N-1]=true;
            nqueen(cur+1);
            isused1[i]=false;
            isused2[i+cur]=false;
            isused3[cur-i+N-1]=false;



        }


    }


}