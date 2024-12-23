import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static char arr[][];  //값을 담는 배열
    static int dx[]={0,-1,0,1};
    static int dy[]={1,0,-1,0};

    static boolean visited[];  //방문했는지 안했는지
    static int[] selected=new int[7];  //결과값(백트래킹)-> 조합
    static int count=0;


    public static void main(String[] args) throws IOException {

        arr=new char[5][5];

        for(int i=0;i<5;i++){
            String str=br.readLine();
            for(int j=0;j<5;j++){
                arr[i][j]=str.charAt(j);



            }
        }
        backtracking(0,0);
        bw.write(String.valueOf(count)+"\n");
        bw.close();



    }
    static void backtracking(int depth,int start){
        if(depth==7){
            visited=new boolean[7];
           int s=0;
           int y=0;
           for(int i=0;i<7;i++){
               int r=selected[i]/5;
               int c=selected[i]%5;
               if(arr[r][c]=='S')s++;

               else y++;
               if(y>=4)return;

           }
           BFS();

           return;
        }
        for(int i=start;i<25;i++){
            selected[depth]=i;
            backtracking(depth+1,i+1);

        }
    }

    static void BFS(){

        Queue<Node> queue=new LinkedList<>();
        queue.add(new Node(selected[0]/5,selected[0]%5));
        visited[0]=true;
        int conn=1;
        while(!queue.isEmpty()){

            Node cur=queue.poll();

            for(int dir=0;dir<4;dir++){

                int nx=cur.x+dx[dir];
                int ny=cur.y+dy[dir];
                int nextIndex=nx*5+ny;

                if(check(nx,ny))continue;

                for(int i=0;i<7;i++){
                    if(!visited[i] && selected[i]==nextIndex){

                        queue.add(new Node(nx,ny));
                        visited[i]=true;
                        conn++;
                    }
                }


            }



        }
        if(conn==7)count++;


    }

    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean check(int nx,int ny){
        if(nx<0 || nx>=5 || ny<0 || ny>=5)return true;
        return false;
    }
}