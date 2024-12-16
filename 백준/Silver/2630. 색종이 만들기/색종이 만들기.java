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

            StringTokenizer st=new StringTokenizer(br.readLine());

            for(int j=0;j<N;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());

            }
        }

        frust(0,0,N);

        bw.write(String.valueOf(zero+"\n"));
        bw.write(String.valueOf(one));
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

    static void frust(int x,int y,int size){

        if(check(x,y,size)){
            if(arr[x][y]==1)one++;
            if(arr[x][y]==0)zero++;
            return;
        }
        int newsize=size/2;

        frust(x,y,newsize);
        frust(x,y+newsize,newsize);
        frust(x+newsize,y,newsize);
        frust(x+newsize,y+newsize,newsize);


    }


}