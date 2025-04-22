
import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st=new StringTokenizer(br.readLine()," " );
        int sample=Integer.parseInt(st.nextToken());
        int system=Integer.parseInt(st.nextToken());

        int samplecount=0;
        int systemcount=0;

        for(int i=0;i<sample;i++){
            st=new StringTokenizer(br.readLine()," ");
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            if(a!=b){
                samplecount++;
            }

        }



        for(int i=0;i<system;i++){

            st=new StringTokenizer(br.readLine()," ");
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            if(a!=b ){
                systemcount++;
            }



        }


        if(samplecount==0 && systemcount==0){
            bw.write("Accepted");
        }
        else if(samplecount!=0){
            bw.write("Wrong Answer");

        }
        else if(samplecount==0 && systemcount!=0){
            bw.write("Why Wrong!!!");

        }






        br.close();
        bw.flush();
        bw.close();



    }

}