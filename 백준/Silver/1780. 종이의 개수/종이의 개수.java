import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    static int N=0;
    static int[][] arr;
    static int gray=0;
    static int black=0;
    static int white=0;
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String [] args )throws IOException{

        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        arr=new int[N][N];

        for(int i=0;i<N;i++){


            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){

                arr[i][j]=Integer.parseInt(st.nextToken());


            }
        }

        partition(0,0,N);
        bw.write(String.valueOf(gray+"\n"));
        bw.write(String.valueOf(black+"\n"));
        bw.write(String.valueOf(white+"\n"));









        bw.flush();
        bw.close();









    }

    static boolean check(int x,int y,int size){
        for(int i=x;i<x+size;i++){

            for(int j=y;j<y+size;j++){

                if(arr[x][y]!=arr[i][j])return false;
            }
        }
        return true;


    }

    static void partition(int x,int y,int size){

        if(check(x,y,size)){
           if(arr[x][y]==-1){
               gray++;
           }
           if(arr[x][y]==0){
               black++;
           }
           if(arr[x][y]==1){
               white++;
           }
           return;

        }
        int newsize=size/3;
        partition(x,y,newsize);
        partition(x,y+newsize,newsize);
        partition(x,y+2*newsize,newsize);

        partition(x+newsize,y,newsize);
        partition(x+newsize,y+newsize,newsize);
        partition(x+newsize,y+2*newsize,newsize);

        partition(x+2*newsize,y,newsize);
        partition(x+2*newsize,y+newsize,newsize);
        partition(x+2*newsize,y+2*newsize,newsize);









    }









}

