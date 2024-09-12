import java.io.*;
import java.util.*;

public class Main {


    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));



        Deque<Integer> deque = new LinkedList<>();


        int a=Integer.parseInt(br.readLine());

        for (int i=0;i<a;i++){

            String arr=br.readLine();
            String arr2[]=arr.split(" ");

            switch (arr2[0]){

                case "push_front" :
                    deque.addFirst(Integer.parseInt(arr2[1]));
                    break;


                case "push_back" :

                    deque.addLast(Integer.parseInt(arr2[1]));
                    break;

                case "pop_front" :

                    if(deque.isEmpty()){
                        bw.write("-1");
                        bw.newLine();
                        break;
                    }

                    bw.write(String.valueOf(deque.pollFirst()));
                    bw.newLine();

                    break;

                case "pop_back" :

                    if(deque.isEmpty()){
                        bw.write("-1");
                        bw.newLine();
                        break;
                    }

                    bw.write(String.valueOf(deque.pollLast()));
                    bw.newLine();
                    break;

                case "size" :

                    bw.write(String.valueOf(deque.size()));
                    bw.newLine();
                    break;

                case "empty" :

                    if(deque.isEmpty()){
                        bw.write("1");
                        bw.newLine();
                        break;
                    }
                    else{
                        bw.write("0");
                        bw.newLine();
                        break;
                    }
                case "front" :
                    if(deque.isEmpty()){
                        bw.write("-1");
                        bw.newLine();
                        break;
                    }
                    bw.write(String.valueOf(deque.peekFirst()));
                    bw.newLine();
                    break;

                case "back" :
                    if(deque.isEmpty()){
                        bw.write("-1");
                        bw.newLine();
                        break;
                    }
                    bw.write(String.valueOf(deque.peekLast()));
                    bw.newLine();
                    break;
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
