import java.io.*;
import java.util.*;

public class Main {


    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));




        Queue<Integer> queue=new LinkedList<>();
        int last=0;

        int a=Integer.parseInt(br.readLine());

        for(int i=0;i<a;i++){
            String str=br.readLine();

            if(str.charAt(0)=='p' ){
                if(str.charAt(1)=='o'){
                    if(queue.isEmpty()){
                        bw.write("-1");
                        bw.newLine();
                        continue;

                    }
                    else{
                        bw.write(String.valueOf(queue.poll()));
                        bw.newLine();
                    }

                }
                else{
                    int insert=Integer.parseInt(str.split(" ")[1]);
                    queue.offer(insert);
                    last=insert;



                }

            }

            if (str.charAt(0)=='s'){
                bw.write(String.valueOf(queue.size()));
                bw.newLine();

            }

            if(str.charAt(0)=='f'){
                if(queue.isEmpty()){
                    bw.write("-1");
                    bw.newLine();

                }
                else{
                    bw.write(String.valueOf(queue.peek()));
                    bw.newLine();

                }


            }

            if(str.charAt(0)=='b'){

                if(queue.isEmpty()){
                    bw.write("-1");
                    bw.newLine();
                }
                else{
                    bw.write(String.valueOf(last));
                    bw.newLine();

                }

            }

            if(str.charAt(0)=='e'){
                if(queue.isEmpty()){
                    bw.write("1");
                    bw.newLine();

                }
                else{
                    bw.write("0");
                    bw.newLine();
                }
            }

        }











        bw.flush();
        bw.close();









    }

    static int func1(int a){
        int sum=0;

        for(int i=1;i<=a;i++){

            if(i%3==0 || i%5==0){
                sum+=i;

            }
        }   //시간복잡도는 ?

        return sum;
    }


    static int func2(int arr[],int length){

        for(int i=0;i<length-1;i++){

            for(int j=1;j<length;j++){

                if(arr[i]+arr[j]==100){

                    return 1;


                }
            }
        }
        return 0;
    }

    static int func3(int N){


        for(int i=1;i*i<=N ;i++){
            if(i*i==N){
                return 1;
            }


        }
        return 0;
    }

    static int func4(int N){
        int k=0;

        for(int i=2 ;i<=N;i=i*2){
            k=i;

        }

        return k;

    }



















}
