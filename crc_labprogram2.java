import java.util.Scanner;
import java.io.*;
public class crc_labprogram2 {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the message bits:");
        String message=sc.nextLine();
        System.out.print("Enter the generator:");
        String generator=sc.nextLine();
        int data[]=new int[message.length()+generator.length()-1];
        int divisor[]=new int[generator.length()];
        for(int i=0;i<message.length();i++)
        data[i]=Integer.parseInt(message.charAt(i)+"");
        for(int i=0;i<generator.length();i++)
        divisor[i]=Integer.parseInt(generator.charAt(i)+"");
        //calculation of CRC
        for(int i=0;i<message.length();i++)
        {
            if(data[i]==1)
            for(int j=0;j<divisor.length;j++)
            data[i+j]^=divisor[j];
        }
        //Display CRC
        System.out.print("the checksum code is:");
        for(int i=0;i<message.length();i++)
        data[i]=Integer.parseInt(message.charAt(i)+"");
        for(int i=0;i<data.length;i++)
        System.out.print(data[i]);
        System.out.println();
        //Check for input CRC
        System.out.print("Enter the checksum code:");
         message=sc.nextLine();
        System.out.println("Enter the generator:");
         generator=sc.nextLine();
        data=new int[message.length()+generator.length()-1];
         divisor=new int[generator.length()];
        for(int i=0;i<message.length();i++)
        data[i]=Integer.parseInt(message.charAt(i)+"");
        for(int i=0;i<generator.length();i++)
        divisor[i]=Integer.parseInt(generator.charAt(i)+"");
        //calculation of remainder
        for(int i=0;i<message.length();i++)
        {
            if(data[i]==1)
            for(int j=0;j<divisor.length;j++)
            data[i+j]=data[i+j]^divisor[j];
        }
        boolean valid=true;
        for(int i=0;i<data.length;i++)
        {
            if(data[i]==1)
            {
                valid=false;
                break;
            }
        }
        if(valid==true)
        System.out.println("Data Stream is valid!");
        else
        System.out.println("Data Stream is invalid!CRC error occured!");
    }
    
}
