import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean language = false;     // false: c++, true: java
    static boolean allOfLower = true;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());

        if(!(checkCpp(sb) && checkJava(sb) && name_check(sb))){
            System.out.println("Error!");
            return;
        }

        // 모든 문자가 소문자일 경우 그대로 return
        if(allOfLower){
            System.out.println(sb.toString());
            return;
        }

        // true = java, false = Cpp
        if(language) sb = makeCpp(sb);
        else sb = makeJava(sb);

        System.out.println(sb.toString());

    }

    public static boolean name_check(StringBuilder sb){
        int isUpperCase = 0;
        int isUnderBar = 0;

        for(int i=0; i < sb.length(); i++){
            char ch = sb.charAt(i);

            if(ch >= 'A' && ch <= 'Z') isUpperCase = 1;
            else if(ch == '_') isUnderBar = 1;
        }

        allOfLower = isUnderBar != 1 && isUpperCase != 1;

        // Java와 Cpp 형식을 혼용 했을때 false return
        if((isUnderBar & isUpperCase) == 0 || allOfLower) {
            language = (isUnderBar != 1);
            return true;
        }else return false;

    }

    public static boolean checkCpp(StringBuilder sb){
        return sb.charAt(sb.length() - 1) != '_'
                && sb.charAt(0) != '_'
                && sb.indexOf("__") < 0;
    }

    public static boolean checkJava(StringBuilder sb){
        return sb.charAt(0) < 'A' || sb.charAt(0) > 'Z';
    }

    public static StringBuilder makeCpp(StringBuilder sb){
        for(int i=0; i<sb.length(); i++){
            char ch = sb.charAt(i);
            if(ch >= 'A' && ch <= 'Z'){
                sb.replace(i, i+1, String.valueOf(ch).toLowerCase());
                sb.insert(i, "_");
            }
        }
        return sb;
    }

    public static StringBuilder makeJava(StringBuilder sb){
        for(int i=0; i<sb.length(); i++){
            if(sb.charAt(i) == '_'){
                sb.deleteCharAt(i);
                sb.replace(i+1, i+1, String.valueOf(sb.charAt(i)).toUpperCase());
                sb.deleteCharAt(i);
            }
        }
        return sb;
    }



}