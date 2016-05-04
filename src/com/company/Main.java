package com.company;

public class Main {

    private static String[] list = new String[]{"G", "R", "C", "Z", "A"};

    public static void main(String[] args) {

        String[] sortedList = quickSort(list);
        for (String str : sortedList)
            System.out.println(str);
    }

    private static String[] quickSort(String[] list){
        if (list.length <= 1)
            return list;
        String[] sortedList = new String[list.length];

        String pivot = list[list.length - 1];

        String[] lessThan = new String[list.length];
        String[] equalTo = new String[list.length];
        String[] greaterThan = new String[list.length];

        int i = 0, j = 0, k = 0;

        for (String str : list){
            int comparable = str.compareTo(pivot);
            if (comparable < 0){
                lessThan[i] = str;
                i++;
            }
            else if (comparable > 0){
                greaterThan[j] = str;
                j++;
            }
            else {
                equalTo[k] = str;
                k++;
            }
        }
        String[] lessThanSorted = quickSort(lessThan);
        String[] greaterThanSorted = quickSort(greaterThan);

        i = 0;

        for (String str : lessThanSorted){
            sortedList[i] = str;
            i++;
        }
        for (String str : equalTo){
            sortedList[i] = str;
            i++;
        }
        for (String str : greaterThanSorted){
            sortedList[i] = str;
            i++;
        }
        return sortedList;
    }
}
