import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int arr[];

    static int math[];

    static int Max=Integer.MIN_VALUE;
    static int Min=Integer.MAX_VALUE;


    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());

        arr=new int[N];

        StringTokenizer st=new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        math=new int[4];
        st=new StringTokenizer(br.readLine());
        int sum=0;

        for(int i=0;i<4;i++){
            math[i]=Integer.parseInt(st.nextToken());


        }

        Permu(arr[0],1);



        bw.write(String.valueOf(Max));
        bw.newLine();
        bw.write(String.valueOf(Min));







        bw.flush();
        br.close();
        bw.close();








    }

    private static void Permu(int num,int index){

        if(index==N){
            Max=Math.max(Max,num);
            Min=Math.min(Min,num);
            return;

        }

        for(int i=0;i<4;i++){
            if(math[i]>0){

                math[i]--;

                if(i==0){
                    Permu(num+arr[index],index+1);
                }
                if(i==1){
                    Permu(num-arr[index],index+1);

                }
                if(i==2){
                    Permu(num*arr[index],index+1);
                }
                if(i==3){
                    Permu(num/arr[index],index+1);
                }

                math[i]++;

            }

        }








    }







}
