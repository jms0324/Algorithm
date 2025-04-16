import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str=br.readLine();
        int ans=1;
        ans = str.charAt(0) == 'c' ? 26 : 10 ;
        for(int i=1;i<str.length();i++){

            if(str.charAt(i)=='c'){
                if(str.charAt(i-1)=='c')ans*=25;
                else ans*=26;


            }
            else{
                if(str.charAt(i-1)=='d')ans*=9;
                else ans*=10;

            }


        }
        bw.write(String.valueOf(ans));





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