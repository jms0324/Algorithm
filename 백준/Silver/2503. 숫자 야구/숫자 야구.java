import java.io.*;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        int N=Integer.parseInt(br.readLine());

        int []answer=new int[N];
        int []strike=new int[N];
        int []ball=new int[N];
        int result=0;
        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            answer[i]=Integer.parseInt(st.nextToken());
            strike[i]=Integer.parseInt(st.nextToken());
            ball[i]=Integer.parseInt(st.nextToken());
        }



       for(int i=100;i<1000;i++){

           int first=i/100;
           int second=i%100/10;
           int third=i%10;
           if(first==second || second == third || first==third){
               continue;  //각자리수는 서로 다른 숫자
           }
           if(second==0 || third ==0) continue;
           int cnt=0;


           for(int j=0;j<N;j++){
               int strikecnt=0;
               int ballcnt=0;

               int answerfirst=answer[j]/100;
               int answersecond=answer[j]%100/10;
               int answerthird=answer[j]%10;

               if(first==answerfirst){
                   strikecnt++;
               }
               else if(first==answersecond || first==answerthird)ballcnt++;


               if(second==answersecond){
                   strikecnt++;
               }
               else if(second==answerfirst || second == answerthird)ballcnt++;


               if(third==answerthird){
                   strikecnt++;
               }
               else if(third==answerfirst || third == answersecond)ballcnt++;


               if(strikecnt==strike[j] && ballcnt==ball[j])cnt++;  // 통과하면 추가



           }

           if(cnt==N){  //모든 케이스 다 통과하면
               result++;
           }


       }

       bw.write(String.valueOf(result));



        bw.flush();
        bw.close();


    }
}