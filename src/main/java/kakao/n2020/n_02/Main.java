package kakao.n2020.n_02;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.List;
/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 21. 1. 13.
 */
public class Main {
    static final String LEFT = "(";
    static final String RIGHT = ")";

    public static void main(String[] args) {
        String str = ")(";
        System.out.println(solution(str));
    }

    static String solution(String str) {
        if(str.equals("")) return str;
        StringBuffer answer = new StringBuffer();
        String[] divided = divide(str);
        if(isCorrectStr(divided[0])) {
            return answer.append(divided[0])
                    .append(solution(divided[1]))
                    .toString();
        }

        answer.append(LEFT)
                .append(solution(divided[1]))
                .append(RIGHT);

        if(divided[0].length() > 1){
            answer.append(reverse(
                    divided[0].substring(1, divided[0].length() - 1)));
        }else {
            answer.append(reverse(
                    divided[0]));
        }

        return answer.toString();
    }

    static boolean isCorrectStr(String str) {
        String[] splitted = str.split("");
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < splitted.length; i++) {
            String s = splitted[i];
            if(i == 0 && s.equals(RIGHT)) {
                return false;
            }
            if(s.equals(LEFT)) {
                stack.push(s);
            }else if(s.equals(RIGHT)) {
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        return true;
    }

    static String[] divide(String str) {
        String[] dividedString = new String[2];
        int leftCount = 0, rightCount = 0;
        StringBuffer stb = new StringBuffer();
        String[] splitted = str.split("");
        for (String s : splitted) {
            if (s.equals(LEFT)) {
                leftCount++;
            } else if (s.equals(RIGHT)) {
                rightCount++;
            }
            stb.append(s);

            if (leftCount != 0 && leftCount == rightCount) {
                break;
            }
        }

        dividedString[0] = stb.toString();
        dividedString[1] = str.substring(dividedString[0].length());
        return dividedString;
    }

    static String reverse(String str) {
        return Arrays.stream(
                str.split(""))
                .map((el) -> {
                    if (el.equals(RIGHT)) {
                        return LEFT;
                    } else if (el.equals(LEFT)) {
                        return RIGHT;
                    }
                    return el;
                }).collect(Collectors
                            .joining());
    }


}
