/*Name:Kavya Chapparapu
 Student id:A00246626
 Name :Shiva Rama Krishna Nutakki
Student id:A00245380
Name: Prathyusha Peddireddy
Student id:A00245208
Program Description:This program is about encryption and decryption of strings using ceaser cipher algorithm
                    It is about use of arrays and different operations like finding average ,searching an elemnt using linear search
                    and reversing an array*/
import java.io.*;
import java.util.Scanner;
import java.lang.*;
class ARRAY_OP_methods
{
  public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

  public static String encrypt(String plainText, int shiftKey)
  {
      plainText = plainText.toLowerCase();//converts the text into lowercase
      String cipherText = "";
      for (int i = 0; i < plainText.length(); i++)
      {
          int charPos = ALPHABET.indexOf(plainText.charAt(i));//getting the numeric value of corresponding character
          int keyVal = (shiftKey + charPos) % 26;//getting the resultant position with shiftKey
          char replaceVal = ALPHABET.charAt(keyVal);// getting the replacing  character
          cipherText += replaceVal;//assigning the resultant character to cipher text
      }
      return cipherText;//returning the cipher text
  }

  public static String decrypt(String cipherText, int shiftKey)
  {
      cipherText = cipherText.toLowerCase();//converts the text into lowercase
      String plainText = "";
      for (int i = 0; i < cipherText.length(); i++)
      {
          int charPos = ALPHABET.indexOf(cipherText.charAt(i));//getting the numeric value of corresponding character of cipher text
          int keyVal = (charPos - shiftKey) % 26;//getting back the resultant position with shiftKey
          if (keyVal < 0)
          {
              keyVal = ALPHABET.length() + keyVal;// getting the replacing  character position
          }
          char replaceVal = ALPHABET.charAt(keyVal);// getting the replacing  character
          plainText += replaceVal;//assigning the resultant character to plain text
      }
      return plainText;//returning the plain text
    }
  public static void arrayAvg(int[] a,int n)//method calculating the mean of the array elements
  {
    int i;
    double sum=0.0,avg;
    for(i=0;i<n;i++)
    {
      sum = sum + a[i];
    }
    avg=sum/n;
    System.out.println("The Average of array=" + avg);//printing the average result
  }
  public static void arrayContains(int a[],int n,int k)//method finding the element present in the array
  {
    int i,flag=0;
    for(i=0;i<n;i++)//The algorithm used to find an element is LINEAR SEARCH algorithm
    {
      if(a[i]==k)
      {
       System.out.println("The array contains " + a[i] + "at" + i);//printing the element with position if found
       flag=1;
       break;
     }
   }
        if(flag==0)
           System.out.println("The array does not contain " + k);//printing the element if not found

  }
  public static void reverse(int a[],int n)//method which prints the array in reverse fashion
  {
    int i;
    System.out.print("[\t");
    for(i=n;i>0;i--)// the loop traverses in reverse order fashiom
    {
      System.out.print( a[i-1] + "\t");
    }
    System.out.println("]");
  }
  public static void main(String args[])
  {
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter the String for Encryption: ");
      String text = new String();
      text = scan.next();//getting the text from user to encrypt
      System.out.print("Enter the value of shift key:");
      int key=scan.nextInt();//getting the key from the user which is used as shift key in ceaser cipher algorithm
      System.out.println("The encrypted String: "+encrypt(text, key));//printing the cipher text by calling encrypt method
      System.out.println("\ndecrypting\t"+encrypt(text, key));//processing for decrypting the cipher text
      System.out.println("\nAfter decryption : "+decrypt(encrypt(text, key), key));//printing the resultant plain text by calling decrypt method
      int n,i,search;
      int a[]=new int[100];//declaring an array
     System.out.print("Enter no of elements:");
      n=scan.nextInt();// getting no of elements from the user
      System.out.println("enter elements of the array");
      for(i=0;i<n;i++)
      {
        a[i]=scan.nextInt();//asking the elememts of an array
      }
      System.out.println(" Elements of the array are");
      for(i=0;i<n;i++)
      {
        System.out.print("\t"+a[i]);// printing the elements of array
      }
      System.out.println();
      arrayAvg(a,n);//calling average method
      System.out.print("enter an element to be searched:");
      search = scan.nextInt();// asking the user to enter an element to be searched
      arrayContains(a,n,search);// calling serch method
      System.out.println("The reverse array is ");
     reverse(a,n);//calling reverse method to print reverse of the array

  }
}
