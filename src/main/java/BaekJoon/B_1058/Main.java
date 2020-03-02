package BaekJoon.B_1058;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        int numberOfPerson, numberOf2_Friend;
        String[] friendsOfPerson;

        numberOfPerson = Integer.parseInt(br.readLine());
        List<String[]> friendList = new ArrayList<>();

        String input;

        for(int i = 0; i < numberOfPerson; i++) {

            friendsOfPerson = new String[numberOfPerson];

            input = br.readLine();
            for(int j = 0; j < numberOfPerson; j++){
                friendsOfPerson[j] = String.valueOf(input.charAt(j));
            }
            friendList.add(friendsOfPerson);
        }

        List<Integer> numberOf2_FriendList = new ArrayList<>();

        for(int i = 0; i < numberOfPerson; i++){
            numberOf2_Friend = 0;

            for(int j = 0; j < numberOfPerson; j++){
                if( i != j ){
                    if(is2_Friend(i, j, friendList)) {
                        numberOf2_Friend++;
                    }
                }
            }
            numberOf2_FriendList.add(numberOf2_Friend);
        }

        System.out.println(numberOf2_FriendList.toString());
    }

    private static boolean is2_Friend(int index_a, int index_b,  List<String[]> friendList) {
        if(friendList.get(index_a)[index_b].equals("Y")){
            return true;
        }else{
            for(int i = 0; i < friendList.size(); i++){
                if (friendList.get(index_a)[i].equals("Y") && friendList.get(index_b)[i].equals("Y")){
                    return true;
                }
            }
        }
        return false;
    }
}
