package com.vinner.codeme.ctci.ds.arrays_and_strings;

/**
 *
 * write a method to replace all spaces in a string with "%20".
 * Input: URLify(“Mr John Smith ”, 13)
 *
 * We are given True Length of the String , Treu length means the length which is needed in real String with one space
 *
 */
public class Urlify {

        private String urlify(String s, int trueLength)
        {
            char[] arr = s.toCharArray();
            int totalSpaces = 0;
            for(int i=0;i<trueLength;i++)
            {
                if(arr[i] == ' ')
                    totalSpaces++;
            }

            int lastIndex = trueLength + totalSpaces*2; //This is the length of final String
            //We will terminate the String after needed Final length

            arr[lastIndex] = '\0';
            for(int i=trueLength-1; i>=0; i--)
            {
                if(arr[i] == ' ')
                {
                    arr[lastIndex-1]= '0';
                    arr[lastIndex-2]= '2';
                    arr[lastIndex-3]= '%';
                    lastIndex = lastIndex-3;

                }
                else{
                    arr[lastIndex-1] = arr[i];
                    lastIndex--;
                }
            }
            StringBuilder sb = new StringBuilder();
            for(char c: arr) {
                if(c== '\0') //Means Reached End
                    break;
                sb.append(c);
            }
            return sb.toString();

        }

        public static void main(String args[])
        {
            Urlify urlify = new Urlify();
            System.out.println(urlify.urlify("VIN MAH          ",7));

        }
}
