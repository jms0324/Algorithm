import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int []arr;

    static int []want;
    static int M;
    public static void main(String[] args) throws IOException {

        N=Integer.parseInt(br.readLine());

        arr= new int[N];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<arr.length;i++){
            arr[i]=Integer.parseInt(st.nextToken());

        }

        Arrays.sort(arr);

        M=Integer.parseInt(br.readLine());
        want=new int[M];
        st=new StringTokenizer(br.readLine());

        for(int i=0;i<want.length;i++){
            want[i]=Integer.parseInt(st.nextToken());

            bw.write(String.valueOf(upper_idx(want[i])-low_idx(want[i])+" "));
        }

        bw.flush();
        bw.close();







    }
    static int low_idx(int target){

        int low=0;
        int hi=arr.length;

        while(low<hi){
            int mid=(low+hi)/2;

            if(target<=arr[mid])hi=mid;
            else{
                low=mid+1;

            }

        }
        return low;
    }
    static int upper_idx(int target){

        int low=0;
        int hi=arr.length;

        while(low<hi){
            int mid=(low+hi)/2;

            if(target>=arr[mid])low=mid+1;
            else {
                hi=mid;

            }

        }
        return low;
    }
}