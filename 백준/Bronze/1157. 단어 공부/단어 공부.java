import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main{

    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        String str=br.readLine();
        int arr[]=new int[26];

        //각 문자마다 나오는 빈도를 어떻게 저장하고 최대값을 산출할 것인지

        //대문자와 소문자를 어떻게 같게 처리할 것인지

        for(int i=0;i<str.length();i++){

            int sample = (int)str.charAt(i);
            if(sample>90){
                sample-=32;
            }
            arr[sample-65]++;

        }
        int max=0;
        int maxi=0;
        for(int i=0;i<arr.length;i++){

            if(max<arr[i]){

                max=arr[i];
                maxi=i;
            }

        }
        for(int i=0;i<arr.length;i++){

            if(max==arr[i] && i!=maxi){
                bw.write(String.valueOf("?"));
                bw.flush();
                bw.close();
                return;
            }
        }

        char answer=(char)(maxi+65);
        bw.write(String.valueOf(answer));







        bw.flush();
        bw.close();












    }
}