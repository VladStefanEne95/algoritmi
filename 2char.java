import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.next();
        char [] letters = new char[s.length()];
        int n = s.length();
        int last = 0;
        int semafor;
        for(int i = 0;i < n; i++){
            semafor = 0;
            for(int j = 0;j < last; j++){
                if(letters[j] == s.charAt(i))
                    semafor = 1;
            }
            if(semafor == 0){
                letters[last] = s.charAt(i);
                last++;
            }
        }
        if(last < 2){
            System.out.print(0);
            return;
        }
        int max_result = 0;
        for(int i = 0;i < n; i++){
            String aux = new String(s);
            for(int j = 0;j < last; j++){
                int max_not_tested = 0;
                boolean correct = true;
               
                for(int k = 0;k < last; k++){
                    if(k != i && k != j){
                       aux = aux.replaceAll(Character.toString(letters[k]), "");
                    }
                                   
                }
                max_not_tested = aux.length();
                 
                if(max_not_tested > max_result){
                   
                    String remover1 = Character.toString(letters[i]) + Character.toString(letters[i]);
                    String remover2 = Character.toString(letters[j]) + Character.toString(letters[j]);
                         
                    if(aux.indexOf(remover1) == -1 && aux.indexOf(remover2) == -1){
                        max_result = max_not_tested;
                        System.out.println(aux);
                }
                   
                }
            }
               
        }
        System.out.print(max_result);
        
    }
}
