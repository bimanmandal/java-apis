package com.biman.learning.ch4;

import java.util.List;
import java.util.function.Function;

import static com.biman.learning.ch3.abstractingIteration.CollectionUtilities.head;
import static com.biman.learning.ch3.abstractingIteration.CollectionUtilities.tail;

public class Addition {
    /*static int add(int x, int y){
        while(y > 0){
            x = ++x;
            y = --y;
        }
        return x;
    }*/

    static int addRec(int x, int y){
        return y == 0
                ? x
                : addRec(++x, --y);
    }

    static TailCall<Integer> add(int x, int y) {
        return y == 0
                ? new TailCall.Return<>(x)
                : new TailCall.Suspend<>(() -> add(x + 1, y - 1));
    }

    static Integer sum(List<Integer> list) {
//        return list.isEmpty()
//                ? 0
//                : head(list) + sum(tail(list));
        return sumTail(list,0);
    }

    static Integer sumTail(List<Integer> list,  int acc){
        return list.isEmpty()
                ? acc
                : sumTail(tail(list), acc+head(list));
    }

    public static void main(String[] args) {
        System.out.println(addRec(10000,3));
        System.out.println(addRec(3,100000));

    }
}
