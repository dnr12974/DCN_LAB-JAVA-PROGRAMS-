import java.util.Scanner;
import java.io.*;
public class tdm_labprogram2 {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n,qt,sq=0,count=0;
        int bt[]=new int[10];
        int wt[]=new int[10];
        int rem_bt[]=new int[10];
        int tat[]=new int[10];
        System.out.print("Enter the no of stations(maximum 10):");
        n=sc.nextInt();
        System.out.print("Enter the processing time for each station:\n");
        for(int i=0;i<n;i++)
        {
            System.out.print("S"+i+"=");
            bt[i]=sc.nextInt();
            rem_bt[i]=bt[i];
        }
        System.out.println("Enter the frame size:");
        qt=sc.nextInt();
        while(count<n)
        {
            for(int i=0;i<n;i++)
            {
                if(rem_bt[i]>0)
                {
                    int temp=Math.min(qt,rem_bt[i]);
                    sq=sq+temp;
                    rem_bt[i]=rem_bt[i]-temp;
                    if(rem_bt[i]==0)
                    {
                       tat[i]=sq;
                       count++;
                    
                    }
                }
            }
        }
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Station \t Processing Time \t Completion time \t Waiting time");
        System.out.println("---------------------------------------------------------------------------");
        float awt=0;
        for(int i=0;i<n;i++)
        {
            wt[i]=tat[i]-bt[i];
            awt=awt+wt[i];
            System.out.println("\t"+i+"\t\t"+bt[i]+"\t\t\t"+tat[i]+"\t\t\t"+wt[i]);
        } 
        sc.close();
    }
    }
    

