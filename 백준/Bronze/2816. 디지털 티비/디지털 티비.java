import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {


        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        boolean check = false;

        int index1=0;
        int index2=0;

        for(int i=0;i<N;i++){

            arr[i]=br.readLine();
            if(arr[i].equals("KBS1"))index1=i;
            if(arr[i].equals("KBS2"))index2=i;
        }

        if(index1>index2){
            index2++;  //1을 앞으로 옮길때 2가 뒤로가니까 인덱스 1증가
        }

        for(int i=0;i<index1;i++){
            bw.write("1");
        }

        for(int i=0;i<index1;i++){
            bw.write("4");
        }

        for(int i=0;i<index2;i++){
            bw.write("1");
        }
        for(int i=1;i<index2;i++){
            bw.write("4");
        }







        bw.flush();
        bw.close();

    }
}