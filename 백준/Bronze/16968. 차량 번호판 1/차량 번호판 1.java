import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str=br.readLine();

        bw.write(String.valueOf(go(str,0,' ')));




        bw.flush();
        bw.close();






    }

    static int go(String s, int index, char last){

        if(s.length()==index){
            return 1;
        }
        char start= s.charAt(index) == 'c' ? 'a' : '0';
        char end = s.charAt(index) == 'c' ? 'z' : '9';

        int ans=0;
        for(char i=start ;i<=end;i++){
            if(i!=last){
                ans+=go(s,index+1,i);
            }
        }

        return ans;
    }
}