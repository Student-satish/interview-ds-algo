import java.util.*;
public class StringNotes{
    public static void main(String[] args) {
        // two methods   to convert integer to string
        String str1 = String.valueOf(10);
        String str2 = Integer.toString(10);
        // how to split string array using certain delimeter like space
        String s = "Hello Word";
        // now i have to split s into words based on space
        String[] words = s.split(" ");
        // use of compare to method 
        // it compares to strings lexicographically
        String s1 = "abc";
        String s2 = "dba";
        int result = s1.compareTo(s2);
        // if result is positive s1 comes after s2
        // if result is negative s1 comes before s2
        // if result is zero s1 and s2 are equal
        // if i want to check any string is starting with any prefix 
        String s3 = "abc";
        boolean ans = s3.startsWith("a");
        // here ans = true bcz s3 startswith a
        // give substring from i to end of s3
        System.out.println(s.substring(1)); // it will give substring from index 1 to end of s3
    }
}
