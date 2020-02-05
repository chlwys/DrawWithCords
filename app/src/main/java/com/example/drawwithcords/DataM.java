package com.example.drawwithcords;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class DataM {
    /*String tester = "1572585258216,1572585038R,187,11687,16664,17\n" +
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
            "1572585259241,1572585038R,188,6905,8903,1"; */
    private String tester;

    public DataM (Context context) {
        StringBuilder returnString = new StringBuilder();
        InputStream fIn = null;
        InputStreamReader isr = null;
        BufferedReader input = null;
        try {
            fIn = context.getResources().getAssets()
                    .open("sampleData", Context.MODE_WORLD_READABLE);
            isr = new InputStreamReader(fIn);
            input = new BufferedReader(isr);
            String line = "";
            while ((line = input.readLine()) != null) {
                returnString.append(line);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            try {
                if (isr != null)
                    isr.close();
                if (fIn != null)
                    fIn.close();
                if (input != null)
                    input.close();
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
        String tester = returnString.toString();
    }

    private String getString(String fileName, Context context) {
        StringBuilder returnString = new StringBuilder();
        InputStream fIn = null;
        InputStreamReader isr = null;
        BufferedReader input = null;
        try {
            fIn = context.getResources().getAssets()
                    .open(fileName, Context.MODE_WORLD_READABLE);
            isr = new InputStreamReader(fIn);
            input = new BufferedReader(isr);
            String line = "";
            while ((line = input.readLine()) != null) {
                returnString.append(line);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            try {
                if (isr != null)
                    isr.close();
                if (fIn != null)
                    fIn.close();
                if (input != null)
                    input.close();
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
        return returnString.toString();
    }

    private String splitByLine(int pos) {
        String[] result =  Pattern.compile("\n").split(tester);
        return result[pos];
    }

    private int lengthOf () {
        String[] result =  Pattern.compile("\n").split(tester);
        return result.length;
    }

    public long[][] splitByComma() {
        long[][] indiv = new long[lengthOf()][];

        for (int i = 0; i < lengthOf(); i++) {
            String[] middleman = Pattern.compile(",").split(splitByLine(i));
            long[] intiLong = new long[6];
            intiLong[0] = Long.parseLong(middleman[0]);
            for (int j = 2; j < 5; j++) {
                // starts at 2 to remove ID
                intiLong[j] = Long.parseLong(middleman[j]);
            }
            indiv[i] = intiLong;
        }
        return indiv;
    }

}
