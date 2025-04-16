import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){


            String str=br.readLine();
            if (str == null) break; // ★ null 체크 추가
            int N=Integer.parseInt(str);
            int remainder = 1;
            int cnt=1;

            while(remainder % N!=0){
                    remainder = (remainder * 10 + 1)%N;

                    cnt++;
            }

            System.out.println(cnt);









        }












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