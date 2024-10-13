import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{

    static int NOTVISITED=0;
    static int VISITED=1;
    static int cycle=2;
    static int notcycle=3;

    static int arr[]=new int[100005];
    static int state[]=new int[100005];

    public static void main(String []args)throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));


        int testcase=Integer.parseInt(br.readLine());

        for(int qwe=0;qwe<testcase;qwe++){

            int N=Integer.parseInt(br.readLine());
            StringTokenizer st=new StringTokenizer(br.readLine());

            for(int i=1;i<=N;i++){

                arr[i]=Integer.parseInt(st.nextToken());
                state[i]=NOTVISITED;


            }
            for(int i=1;i<=N;i++){

                if(state[i]==NOTVISITED){
                    run(i);
                }
            }
            int cnt=0;

            for(int i=1;i<N+1;i++){

                if(state[i]==notcycle){
                    cnt++;

                }
            }

            bw.write(String.valueOf(cnt+"\n"));




        }





        bw.flush();
        bw.close();





    }

    static  void run(int x){

        int cur=x;


      while (true){

          state[cur]=VISITED;
          cur=arr[cur]; //다음학생

          if(state[cur]==cycle || state[cur]==notcycle){  //이미 사이클이 아닌지 맞는지 판가름이 난 곳을 만난 경우

              cur=x;
              while(state[cur]==VISITED){
                  state[cur]=notcycle;
                  cur=arr[cur];
              }


              return;


          }

          if(state[cur]==VISITED && cur != x){ // 쭉 진행되다가 사이클을 처음 발견한경우

              while(state[cur]!=cycle){
              state[cur]=cycle;
              cur=arr[cur];

               }

              cur=x;
              while(state[cur]!=cycle){
                  state[cur]=notcycle;
                  cur=arr[cur];
              }
              return;


          }


          if(arr[cur]==x && state[cur]==VISITED ){   //사이클을 만나는 경우

              while(state[cur]!=cycle){
                  state[cur]=cycle;
                  cur=arr[cur];

              }

              return;

          }





      }







    }






}