package kakao.n2020.n_01;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 21. 1. 12.
 */
public class Main {
    public static void main(String[] args) {
        String str = "abcabcdede";
        System.out.println(solution(str));
    }

    static int solution(String str) {
        int answer = 0;
        StringBuilder stb = new StringBuilder();

        for(int j = 1; j <= str.length(); j++) {
            String temp = "";
            int count = 1;
            int loopSize = str.length() / j - 1;
            if(str.length() % j > 0) {
                loopSize += 1;
            }

            for(int i = 0; i <= loopSize; i++) {
                String substr = "";
                if(i == loopSize && (i + 1) * j >= str.length() ) {
                    substr = str.substring(i * j);
                }else {
                    substr = str.substring(i * j, (i + 1) * j);
                }


                if(temp.equals(substr)) {
                    ++count;
                }else {
                    if(count != 1) {stb.append(count);}
                    stb.append(temp);
                    count = 1;
                }

                temp = substr;

                if( i  == loopSize ){
                    if(count != 1) {stb.append(count);}
                    stb.append(temp);
                }
            }
            int currentLength = stb.toString().length();
            if(answer > currentLength) {
                answer = currentLength;
            }
            if(answer == 0){answer = stb.toString().length();}
            stb = new StringBuilder();
        };
        return answer;
    }

}
