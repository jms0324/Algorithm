import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{


    static int[] want;
    static int[] arr;

    static int N;
    static int M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        M=Integer.parseInt(br.readLine());
        want=new int[M];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<want.length;i++){
            want[i]=Integer.parseInt(st.nextToken());
        }


        N=Integer.parseInt(br.readLine());
        arr= new int [N];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<arr.length;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(want);


        for(int i=0;i<arr.length;i++){
            if(BinarySearch(arr[i])){
                bw.write("1 ");
            }
            else{
                bw.write("0 ");
            }

        }


        bw.flush();
        bw.close();






    }

    static boolean BinarySearch(int target){

        int st=0;
        int en=want.length-1;
        while(st<=en){

            int mid=(st+en)/2;
            if(want[mid]==target)return true;
            if(want[mid]>target)en=mid-1;
            if(want[mid]<target)st=mid+1;
        }

        return false;


    }
}