package Sorting_Algorithms;

import java.util.Scanner;

public class Insertion_Sort {

    int[] Sorted_Array(int elements[],int size){
        for (int i=1;i<size;i++){
            for (int j=0;j<i;j++){
                if(elements[i]<elements[j]){
                    int temp=elements[i];
                    elements[i]=elements[j];
                    elements[j]=temp;
                }
            }
        }
        return elements;
    }



    public static void main(String[] args) {
        Insertion_Sort object=new Insertion_Sort();
        Scanner scan=new Scanner(System.in);
        try {
            System.out.println("enter the number of elements");
            int n=scan.nextInt();
            System.out.println("enter the "+n+" elements to be sorted");
            int elements[]=new int[n];
            for(int i=0;i<n;i++){
                elements[i]=scan.nextInt();
            }
            int result[]=object.Sorted_Array(elements,n);
            System.out.println("sorted array is:-");
            for(int i=0;i<n;i++){
                System.out.print(result[i]+" ");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

}
