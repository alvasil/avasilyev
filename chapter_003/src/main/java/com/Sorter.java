//package com;
//
//
//import java.util.*;
//
//public class Sorter {
//	//дефолтный конструктор не требуется, т.к. нет параметизированного
//    public Sorter(){
//
//    }
//	// чекстайл - необходимо убрать пробелы между названием методов и ()
//	// не определен класс User
//    Set<User> sort (List<User> list) {
//        TreeSet<User> sortedList = new TreeSet<>();
//        sortedList.addAll(list);
//        return sortedList;
//    }
//
//    List<User> sortnamelength (List<User> list) {
//        Comparator<User> compar = new Comparator<User>() {
//            @Override
//            public int compare (User o1, User o2) {
//                return o1.getName().length() - o2.getName().length();
//            }
//        };
//        list.sort(compar);
//        return list; //заменить 2 строчки на return list.sort(compar);
//    }
//
//    List<User> sortboth (List<User> list) {
//        Comparator<User> compar1 = new Comparator<User>() {
//            @Override
//            public int compare (User o1, User o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        };
//        Comparator<User> compar2 = new Comparator<User>() {
//            @Override
//            public int compare (User o1, User o2) {
//                return o1.getAge() - o2.getAge();
//            }
//        };
//        list.sort(compar1.thenComparing(compar2));
//        return list; //заменить 2 строчки на return list.sort(compar1.thenComparing(compar2));
//    }
//}