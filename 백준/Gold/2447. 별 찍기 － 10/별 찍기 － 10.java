import java.io.*;

public class Main {

    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char arr[][];



    public  static void main(String []args)throws IOException {

        int N=Integer.parseInt(br.readLine());
        arr=new char[N][N];


        loststars(0,0,N,false);

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                bw.write(arr[i][j]);
            }
            bw.newLine();
        }





        bw.flush();
        bw.close();






    }

    public static void loststars(int x,int y,int size,boolean blank)throws IOException{

        if(blank){

            for(int i=x;i<x+size;i++){
                for(int j=y;j<y+size;j++){
                    arr[i][j]=' ';

                }

            }
            return;
        }
        if(size==1){

            arr[x][y]='*';
            return;
        }
        int count=0;
        int newsize=size/3;
        for(int i=x;i<x+size;i+=newsize){
            for(int j=y;j<y+size;j+=newsize){
                count++;
                if(count==5){
                    loststars(i,j,newsize,true);
                }
                else {
                    loststars(i, j, newsize, false);
                }

            }
        }









    }


}