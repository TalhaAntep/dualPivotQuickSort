
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SortingClass sort =new SortingClass();
        Scanner scanner=new Scanner(System.in);
        // Array Length
        System.out.println("Choose array size: 1) 1000 2) 10000 3) 100000" );
        int n=0;
        while(true) {
            n =scanner.nextInt();
            if (n == 1) {
                n = 1000;
                break;
            } else if (n == 2) {
                n = 10000;
                break;
            } else if (n == 3) {
                n = 100000;
                break;
            } else {
                System.out.println("Invalid value!");
            }
        }

        int[] array = new int[n];
        Random rnd =new Random();

        System.out.println("Choose array type: 1) equal array 2) random array 3) increasing array 4) decreasing array ");

        while(true) {
            int answer =scanner.nextInt();
            if (answer==1) {
                // Equal array generator
                 int random = rnd.nextInt(n);
                for (int i=0;i< n;i++){
                    array[i]=random;
                }
                break;
            } else if (answer==2) {
                // Random array generator
                for (int i=0;i< n;i++){
                    int random2 = rnd.nextInt(n);
                    array[i]=random2;
                }
                break;
            } else if (answer == 3) {
                //Increasing array generator
                for (int i=0;i<n;i++)
                    array[i]=i;
                break;
            } else if(answer==4){
                //Decreasing array generator
                int x=0;
                for (int i=n;i>0;i--) {
                    array[x] = i;
                    x++;
                }
                break;
            }
            else
                System.out.println("Invalid value!");

        }


        //calculate runtime
        long startTime = System.nanoTime();
        sort.dualPivotQuickSort(array,0,n-1);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("dualPivotQuickSort - "+n+" size - "+estimatedTime+" nano");


        //calculate runtime
        long startTime2 = System.nanoTime();
        sort.shellSort(array);
        long estimatedTime2 = System.nanoTime() - startTime2;
        System.out.println("shellSort - "+n+" size - "+estimatedTime2+" nano");

        System.out.println("Would like to print it ? 1) yes 2) no ");

        while(true) {
            int answer2 = scanner.nextInt();
            if (answer2 == 1) {
                //print the array
                System.out.println("Ordered");
                printArray(array);
                break;
            } else if (answer2 == 2) {
                break;
            } else
                System.out.println("Invalid value");
        }
    }

    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}