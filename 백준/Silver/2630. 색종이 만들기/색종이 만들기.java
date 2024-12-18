import java.io.*;
import java.util.StringTokenizer;

public class Main{

    static int [][] arr;

    static int white=0;
    static int blue=0;



    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        int N=Integer.parseInt(br.readLine());
        arr=new int[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){

                arr[i][j]=Integer.parseInt(st.nextToken());

            }
        }

        recur(N,0,0);
        bw.write(String.valueOf(white+"\n"));
        bw.write(String.valueOf(blue));
        bw.flush();
        bw.close();




    }

    static void recur(int n,int r,int c){

        if(n==1){
            if(arr[r][c]==0) white++;
            if(arr[r][c]==1) blue++;

            return;


        }

        if(check(n,r,c)){
            if(arr[r][c]==0) white++;
            if(arr[r][c]==1) blue++;

            return;

        }

        int newsize=n/2;

        recur(newsize,r,c);
        recur(newsize,r,c+newsize);
        recur(newsize,r+newsize,c);
        recur(newsize,r+newsize,c+newsize);




    }

    static boolean check(int n,int r,int c){

        for(int i=r;i<r+n;i++){

            for(int j=c;j<c+n;j++){

                if(arr[r][c]!=arr[i][j])return false;
            }


        }
        return true;

    }
}