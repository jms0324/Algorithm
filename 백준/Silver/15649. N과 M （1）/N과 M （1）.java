import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main{

    static BufferedReader br=new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(out));

    static boolean used[];
    static int arr[];
    static int N;
    static int M;


    public static void main(String[] args) throws IOException {

        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        used=new boolean[N+2];
        arr=new int [N+2];

        NM(0);



        bw.flush();
        bw.close();







    }

    static void NM(int k)throws IOException{
        if(k==M){

            for(int i=0;i<M;i++){
                bw.write(String.valueOf(arr[i])+" ");

            }
            bw.newLine();
        }
        for(int i=1;i<=N;i++){

            if(!used[i]){

                arr[k]=i;
                used[i]=true;
                NM(k+1);
                used[i]=false;

            }
        }





    }




}