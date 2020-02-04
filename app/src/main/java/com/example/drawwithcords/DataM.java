package com.example.drawwithcords;

import java.util.regex.Pattern;

public class DataM {
    String tester = "1572585258216,1572585038R,187,11687,16664,17\n" +
            "1572585259176,1572585038R,188,7101,8851,592\n" +
            "1572585259181,1572585038R,188,7062,8876,492\n" +
            "1572585259186,1572585038R,188,7031,8893,400\n" +
            "1572585259191,1572585038R,188,7007,8907,300\n" +
            "1572585259196,1572585038R,188,6990,8923,216\n" +
            "1572585259201,1572585038R,188,6981,8941,216\n" +
            "1572585259206,1572585038R,188,6976,8956,216\n" +
            "1572585259211,1572585038R,188,6970,8965,217\n" +
            "1572585259216,1572585038R,188,6970,8965,218\n" +
            "1572585259221,1572585038R,188,6954,8961,219\n" +
            "1572585259226,1572585038R,188,6940,8948,218\n" +
            "1572585259231,1572585038R,188,6923,8928,216\n" +
            "1572585259236,1572585038R,188,6905,8903,1\n" +
            "1572585259241,1572585038R,188,6905,8903,1";

    public DataM () {

    }

    private String splitByLine(int pos) {
        String[] result =  Pattern.compile("\n").split(tester);
        return result[pos];
    }

    private int lengthOf () {
        String[] result =  Pattern.compile("\n").split(tester);
        return result.length;
    }

    public int[][] splitByComma() {
        int[][] indiv = new int[lengthOf()][];
        for (int i = 0; i <= lengthOf(); i++) {
            String[] middleman = Pattern.compile("\n").split(splitByLine(i));
            indiv[i][0] = Integer.parseInt(middleman[0]);
            for (int j = 0; j <= 5; j++) {
                // starts at 2 to remove ID
                indiv[i][j] = Integer.parseInt(middleman[j]);
            }
        }
        return indiv;
    }

}
