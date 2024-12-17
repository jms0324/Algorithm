import java.io.*;

public class Main {

    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char arr[][];



    public  static void main(String []args)throws IOException {

        int N=Integer.parseInt(br.readLine());
        arr=new char[N][N*2-1];

        for(int i=0;i<N;i++){
            for(int j=0;j<N*2-1;j++){
                arr[i][j]=' ';
            }
        }


        loststars(0,N-1,N);

        for(int i=0;i<N;i++){
            for(int j=0;j<2*N-1;j++){
                bw.write(arr[i][j]);
            }
            bw.newLine();
        }





        bw.flush();
        bw.close();






    }



    public static void loststars(int x,int y,int size){

        if(size==3){
            arr[x][y]='*';
            arr[x+1][y-1]='*';

            arr[x+1][y+1]='*';
            arr[x+2][y-2]=arr[x+2][y-1]=arr[x+2][y]=arr[x+2][y+1]=arr[x+2][y+2]='*';
            return;
        }
        int newsize=size/2;
        loststars(x,y,newsize);
        loststars(x+newsize,y-newsize,newsize);
        loststars(x+newsize,y+newsize,newsize);




    }




}