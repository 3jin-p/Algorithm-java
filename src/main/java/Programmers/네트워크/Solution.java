package Programmers.네트워크;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 2020/10/28
 */
public class Solution {
    private static int[] PLAYS;
    private static String[] GENRES;

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "hoho", "pop"};
        int[] plays = {500, 600, 150, 150, 2500};
        solution(genres, plays);
    }
    public static void solution(String[] genres, int[] plays) {
       HashMap<String, List<Integer>> genreMap = new HashMap<>();
       List<Integer> playList = Arrays.stream(plays).boxed().collect(Collectors.toList());

       for(int i = 0; i < genres.length; i++){
           String genre = genres[i];
           if(genreMap.containsKey(genre)) {
               genreMap.get(genre).add(i);
           }else {
               List<Integer> indexes = new ArrayList<>();
               indexes.add(i);
               genreMap.put(genre,indexes);
           }
       }

       Set<String> genreKeys = genreMap.keySet();
       Iterator<String> genreKeyIter = genreKeys.iterator();
       HashMap<Integer, String> genrePlaySumMap = new HashMap<>();
       while (genreKeyIter.hasNext()) {
           String genre = genreKeyIter.next();
           List<Integer> playKeys = genreMap.get(genre);
           int sum = 0;
           for(int key : playKeys) {
               sum += playList.get(key);
           }
           genrePlaySumMap.put(sum, genre);
       }

       Set<Integer> sums = genrePlaySumMap.keySet();
       List<Integer> sumList = sums.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
       HashMap<Integer, Integer> song
       for(int sum : sumList) {
           String genre = genrePlaySumMap.get(sum);
           List<Integer> songs = genreMap.get(genre);
           for(int songKey : songs) {

           }
       }

    }


}
