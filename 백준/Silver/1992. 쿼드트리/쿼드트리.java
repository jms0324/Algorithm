import java.io.*;
import java.util.StringTokenizer;

public class Main{

    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int zero=0;
    static int one=0;

    static int arr[][];



    public static void main(String[] args) throws IOException {

        int N=Integer.parseInt(br.readLine());
        arr=new int[N][N];

        for(int i=0;i<N;i++){

            String str=br.readLine();

            for(int j=0;j<N;j++){
                arr[i][j]=str.charAt(j)-'0';

            }
        }

        frust(0,0,N);


        bw.flush();
        bw.close();





    }

    static boolean check(int x, int y,int size){

        for(int i=x;i<x+size;i++){

            for(int j=y;j<y+size;j++){
                if(arr[x][y]!=arr[i][j])return false;
            }
        }
        return true;
    }

    static void frust(int x,int y,int size)throws IOException{

        if(check(x,y,size)){
            if(arr[x][y]==1)bw.write("1");
            if(arr[x][y]==0)bw.write("0");
            return;
        }
        int newsize=size/2;

        bw.write("(");
        frust(x,y,newsize);
        frust(x,y+newsize,newsize);
        frust(x+newsize,y,newsize);
        frust(x+newsize,y+newsize,newsize);
        bw.write(")");


    }


}