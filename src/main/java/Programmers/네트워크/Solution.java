package Programmers.네트워크;

import java.util.*;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

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
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        solution(genres, plays);
    }
    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = new int[100];
        List<Integer> answerList = new ArrayList<>();
        GENRES = genres;
        PLAYS = plays;
        HashMap<String, HashMap<Integer, List<Integer>>> genreMap = new HashMap<>();
        for(int i = 0; i < GENRES.length; i++) {
            if (genreMap.containsKey(GENRES[i])) {
                HashMap<Integer, List<Integer>> playMap = genreMap.get(GENRES[i]);
                putSong(playMap, i);
            }else {
                HashMap<Integer, List<Integer>> playMap = new HashMap<>();
                putSong(playMap, i);
                genreMap.put(GENRES[i], playMap);
            }
        }

        Set<String> genreKeySet = genreMap.keySet();
        Iterator<String> genreIter = genreKeySet.iterator();
        HashMap<Integer, String> genrePlaySumMap = new HashMap<>();
        while (genreIter.hasNext()) {
            String key = genreIter.next();
            HashMap<Integer, List<Integer>> playMap = genreMap.get(key);
            Set<Integer> playKeys = playMap.keySet();
            int genrePlaySum = playKeys.stream().mapToInt(Integer::intValue).sum();
            genrePlaySumMap.put(genrePlaySum, key);
        }

        Set<Integer> keys = genrePlaySumMap.keySet();
        List<Integer> list = keys.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        for(int key : list){
            String genre = genrePlaySumMap.get(key);
            HashMap<Integer, List<Integer>> playMap = genreMap.get(genre);
            Set<Integer> playCounts = playMap.keySet();
            List<Integer> countList = playCounts.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
            int index = 0;
            for(int count : countList) {
                if(index > 1) { break; }
                List<Integer> numbers = playMap.get(count);
                numbers.stream().sorted().forEach(answerList::add);
                ++index;
            }
        }

        answer = answerList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }

    private static void putSong(HashMap<Integer, List<Integer>> playMap, int i) {
        if(playMap.containsKey(PLAYS[i])){
            playMap.get(PLAYS[i]).add(i);
        }else {
            List<Integer> songs = new ArrayList<>();
            songs.add(i);
            playMap.put(PLAYS[i], songs);
        }
    }




}
