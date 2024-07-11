import java.io.*;
import java.util.*;

public class Main {





    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        if(N%2==0){
            bw.write("CY");

        }
        else{
            bw.write("SK");
        }






        bw.flush();
        br.close();
        bw.close();








    }















}
