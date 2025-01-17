import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main{

    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        int N=Integer.parseInt(br.readLine());
        int i=2;
        int j=7;
        int cnt=1;

        while(true){

            if(N==1){
                bw.write(String.valueOf("1"));
                break;
            }
            if(N>=i && N <=j){
                bw.write(String.valueOf(cnt+1));
                break;

            }

            i+=(cnt*6);
            j+=((cnt+1)*6);
            cnt++;





        }

        bw.flush();
        bw.close();












    }
}