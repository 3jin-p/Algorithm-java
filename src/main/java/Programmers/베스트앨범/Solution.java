package Programmers.베스트앨범;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <b>파일 설명</b>
 *
 * @author sejinpark
 * @since 2020/10/28
 */
public class Solution {

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "six", "aop", "legend", "legend"};
        int[] plays = {850, 860, 870, 880, 800, 800};
        solution(genres, plays);
    }

    public static void solution(String[] genres, int[] plays) {
        Map<String, List<Music>> genreMap = initGenreMap(genres,plays);
        Map<String, List<Music>> finalGenreMap = reversSortByPlaySum(genreMap);
        reverseSortByPlay(finalGenreMap);
        List<Integer> answer = new ArrayList<>();
        finalGenreMap.forEach((key, value) ->
        {
            answer.add(value.get(0).getId());
            if(value.size() > 1) answer.add(value.get(1).getId());
        });

        System.out.println(Arrays.toString(answer.toArray()));
    }

    public static Map<String, List<Music>> initGenreMap(String[] genres, int[] plays) {
        Map<String, List<Music>> genreMap = new LinkedHashMap<>();
        for(int i = 0; i < genres.length; i++){
            Music music = new Music(i, genres[i], plays[i]);
            if(genreMap.containsKey(genres[i])) {
                genreMap.get(genres[i]).add(music);
                continue;
            }
            List<Music> musics = new ArrayList<>();
            musics.add(music);
            genreMap.put(genres[i],musics);
        }
        return genreMap;
    }

    public static void reverseSortByPlay(Map<String, List<Music>> genreMap) {
        Set<String> genreKeys = genreMap.keySet();
        genreKeys.forEach((key) -> {
                    List<Music> musics = genreMap.get(key);
                    musics = musics.stream()
                            .sorted(
                                    Comparator.comparing(Music::getPlay)
                                            .reversed()
                                            .thenComparing(Music::getId))
                            .collect(Collectors.toList());
                    genreMap.put(key, musics);
                }
        );
    }
    public static LinkedHashMap<String, List<Music>> reversSortByPlaySum(Map<String, List<Music>> map) {
        List<Map.Entry<String, List<Music>>> entries = new LinkedList(map.entrySet());
        entries.sort(Comparator.comparingInt(o -> -o.getValue().stream().mapToInt(Music::getPlay).sum()));

        LinkedHashMap<String, List<Music>> result = new LinkedHashMap<>();
        for (Map.Entry<String, List<Music>> entry : entries) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }


    public static class Music {
        int id;
        String genre;
        int play;

        public int getId() {
            return id;
        }
        public int getPlay() {
            return play;
        }
        public Music(int id, String genre, int play) {
            this.id = id;
            this.genre = genre;
            this.play = play;
        }
    }

}
