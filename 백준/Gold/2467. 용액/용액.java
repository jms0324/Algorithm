import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        int N=Integer.parseInt(br.readLine());
        int arr[]=new int[N];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());

        }



        int []answer=new int[2];

        int max=Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            int left=i+1;
            int right=N-1;

            while(left<=right){
                int mid=(left+right)/2;
                int sum=arr[mid]+ arr[i];
                if(Math.abs(sum)<max){
                    answer[0]=arr[i];
                    answer[1]=arr[mid];
                    max=Math.abs(sum);
                }

                if(sum>0){
                    right=mid-1;
                }
                else {
                    left=mid+1;
                }


            }







        }

        bw.write(answer[0]+" "+answer[1]);
        bw.flush();
        bw.close();




    }
}