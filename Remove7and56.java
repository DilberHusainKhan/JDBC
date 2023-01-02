import java.util.Scanner;

/*
 * Write a program to remove 7 and 56 from given string.
 */
public class Remove7and56 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] ch =str.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='7'){
                ch[i] = '\0';
            }
            if(ch[i]=='5' && ch[i+1]=='6'){
                ch[i] ='\0';
                ch[i+1]='\0';
            }
        }
        for(int i=0;i<ch.length;i++){
            System.out.print(ch[i]);
        }
    }
}
