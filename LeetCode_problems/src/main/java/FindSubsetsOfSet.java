//Given a list of integers, find all subsets
package main.java;

import java.util.*;

public class FindSubsetsOfSet {
    public static Set<Set<Integer>> findSubsets(List<Integer> numbers){
        Set<Set<Integer>> sets = new HashSet<>();
        if(numbers == null){
            sets.add(new HashSet<>());
            return sets;
        }
        sets.add(new HashSet<>(numbers));
        for(int i = 0; i < numbers.size(); i++){
            List<Integer> newNumbers = new ArrayList<>(numbers); //deep-copy contents to another list
            newNumbers.remove(i);
            sets.addAll(findSubsets(newNumbers));
        }
        return sets;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Set<Set<Integer>> set = findSubsets(List.of(2,3,54,6,1,2,3)); //expect 32
        System.out.println(set);
        System.out.println(set.size());
    }
}
