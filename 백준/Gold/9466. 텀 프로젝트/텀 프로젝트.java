import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    static int NOT_VISITED=0;
    static int VISITED=1;

    static int CYCLE=2;
    static int NOT_CYCLE=3;

    static int arr[]=new int[100005];
    static int state[]=new int[100005];





    public static void main(String[] args) throws IOException {
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(br.readLine());

        for(int i=0;i<testcase;i++){
            int N=Integer.parseInt(br.readLine());
            StringTokenizer st=new StringTokenizer(br.readLine());

            for(int j=1;j<N+1;j++){
                arr[j]=Integer.parseInt(st.nextToken());
                state[j]=NOT_VISITED;
            }


            for(int j=1;j<N+1;j++){
                if(state[j]==NOT_VISITED)run(j);

            }
            int cnt=0;
            for(int j=1;j<N+1;j++){
                if(state[j]==NOT_CYCLE){
                    cnt++;

                }

            }
            bw.write(String.valueOf(cnt));
            bw.newLine();






        }






        bw.flush();
        bw.close();


    }


    static void run(int x){


        int cur=x;

        while(true){
            state[cur]=VISITED;
            cur=arr[cur]; //다음학생

            if(state[cur]==CYCLE || state[cur]==NOT_CYCLE){
                cur=x;
                while(state[cur]==VISITED){
                    state[cur]=NOT_CYCLE;
                    cur=arr[cur];
                }

                return;
            }




            if(state[cur]==VISITED && cur!=x){
                while(state[cur]!=CYCLE){
                    state[cur]=CYCLE;
                    cur=arr[cur];
                }
                cur=x;
                while(state[cur]!=CYCLE){
                    state[cur]=NOT_CYCLE;
                    cur=arr[cur];
                }

                return;



            }

            if(state[cur]==VISITED && cur==x){
                while(state[cur]!=CYCLE){
                    state[cur]=CYCLE;
                    cur=arr[cur];
                }
                return;
            }

        }








    }









}