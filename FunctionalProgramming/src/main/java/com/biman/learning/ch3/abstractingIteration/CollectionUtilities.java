package com.biman.learning.ch3.abstractingIteration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class CollectionUtilities {

    public static <T> List<T> list() {
        return Collections.emptyList();
    }

    public static <T> List<T> list(T t) {
        return Collections.singletonList(t);
    }

    public static <T> List<T> list(List<T> ts) {
        return Collections.unmodifiableList(new ArrayList<>(ts));
    }

    public static <T> List<T> list(T... t) {
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(t, t.length)));
    }

    public static <T> T head(List<T> list) {
        if (list.size() == 0) {
            throw new IllegalStateException("head of empty list");
        }
        return list.get(0);
    }

    private static <T> List<T> copy(List<T> ts) {
        return new ArrayList<>(ts);
    }

    public static <T> List<T> tail(List<T> list) {
        if (list.size() == 0) {
            throw new IllegalStateException("tail of empty list");
        }
        List<T> workList = copy(list);
        workList.remove(0);
        return Collections.unmodifiableList(workList);
    }

    public static <T> List<T> append(List<T> list, T t) {
        List<T> ts = copy(list);
        ts.add(t);
        return Collections.unmodifiableList(ts);
    }

    public static <T, U> U foldLeft(List<T> ts, U identity, Function<U, Function<T, U>> f) {
        U result = identity;
        for (T s : ts) {
            result = f.apply(result).apply(s);
        }
        return result;
    }

    /*public static <T, U> U foldLeft(List<T> ts, U identity, Function<U, Function<T, U>> f) {
            ts.isEmpty()
            ? identity
            : f.apply(foldLeft(head(ts),identity,f)).apply(tail(ts)
    }*/



    /*public static <T, U> U foldRight(List<T> ts, U identity, Function<T, Function<U, U>> f){
        U result = identity;
        for(int i = ts.size(); i > 0; i-- ){
            result = f.apply(ts.get(i-1)).apply(result);
        }

        return result;
    }*/

    public static <T, U> U foldRight(List<T> ts, U identity, Function<T, Function<U, U>> f) {
        return ts.isEmpty()
                ? identity
                : f.apply(head(ts)).apply(foldRight(tail(ts), identity, f));
    }

    public static <T> List<T> prepend(T t, List<T> ts) {
        return foldLeft(ts, list(t), x -> y -> append(x, y));
    }



    /*public static <T> List<T> reverse(List<T> list) {
        List<T> result = new ArrayList<>();
        for (int i = list.size(); i > 0; i--) {
            result.add(list.get(i - 1));
        }
        return Collections.unmodifiableList(result);
    }*/

    public static <T> List<T> reverse(List<T> list) {
        return foldLeft(list, list(), x -> y -> prepend(y, x));
    }

    /*public static <T> List<T> reverse(List<T> list) {
        return foldLeft(list, list(), x -> y ->
                foldLeft(x, list(y), a -> b -> append(a, b)));
    }*/


    public static <T,U> List<U> mapViaFoldLeft(List<T> list, Function<T,U> f){
        return foldLeft(list, list(), x -> y -> append(x,f.apply(y)));
    }

    public static <T,U> List<U> mapViaFoldRight(List<T> list, Function<T,U> f){
        return foldRight(list, list(), x -> y -> prepend(f.apply(x), y));
    }

    /*public static List<Integer> range(int start,int end){
        *//*List<Integer> result = new ArrayList<>();
        int temp = start;
        while (temp < end){
            result = CollectionUtilities.append(result, temp);
            temp += 1;
        }
        return result;*//*
        return unfold(start, x -> x + 1, x -> x < end);
    }*/

    public static List<Integer> range(Integer start, Integer end){
        return end <= start
                ? CollectionUtilities.list()
                : CollectionUtilities.prepend(start, range(start + 1, end ));
    }

    public static <T> List<T> unfold(T seed, Function<T, T> f, Function<T, Boolean> p){
        List<T> result = new ArrayList<>();
        T temp = seed;
        while(p.apply(temp)) {
            result = append(result,temp);
            temp =f.apply(temp);
        }
        return result;
    }




    public static void main(String[] args) {
        Function<String, Function<Integer, String>> f = x -> y -> String.format("(%s+%s)", x, y);
        System.out.println(reverse(Arrays.asList(1, 2, 3, 4)));
        System.out.println(foldLeft(Arrays.asList(1, 2, 3, 4, 5), "0", f));
        System.out.println(foldRight(Arrays.asList(1, 2, 3, 4, 5, 6), "0", x -> y -> String.format("(%s+%s)", x, y)));
    }


}
