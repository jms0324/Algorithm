import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N = 100001;
    static int[] board=new int[N+2];

    static Queue<Integer> queue;

    static int sis;
    static int bro;







    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        sis = Integer.parseInt(st.nextToken());
        bro = Integer.parseInt(st.nextToken());

        if(sis==bro){
            bw.write("0");
            bw.flush();
            bw.close();
            return;
        }
        queue=new LinkedList<>();

        board[sis]=1;
        queue.offer(sis);
        teleport(sis);
        while(board[bro]==0){

            int cur= queue.poll();
            int arr[]=new int[]{cur-1,cur+1};
            for(int i:arr){
                if(i<0 || i>=N)continue;
                if(board[i]!=0)continue;
                board[i]=board[cur]+1;
                queue.offer(i);
                teleport(i);
            }
        }

        bw.write(String.valueOf(board[bro]-1));
        bw.flush();
        bw.close();






    }


    static void teleport(int sis){

        int tmp=sis;
        if(tmp==0)return; //0이면 곱하기 2해도 0
        while(tmp < N && board[bro] ==0){
            if(board[tmp]==0){  //처음방문
                board[tmp]= board[sis];
                queue.offer(tmp);
                if(tmp ==bro){
                    return;
                }
            }
            tmp*=2;
        }


    }




}



