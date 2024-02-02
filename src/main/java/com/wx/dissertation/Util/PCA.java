package com.wx.dissertation.Util;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class PCA {
    private static HashMap<String, List<Double>> DataMap = new HashMap<String, List<Double>>();
    private static final int window = 5;
    private static HashMap<String,Double> answerMap = new HashMap<String, Double>();
    private static HashMap<String,Double> error_upperMap  = new HashMap<String, Double>();
    private static HashMap<String,Double> error_lowerMap  = new HashMap<String, Double>();
    //小数点以下2桁まで結果を保持
    private static DecimalFormat df = new DecimalFormat("0.00");

    public static boolean CheckAnswer(String id,double data){
        List<Double> dataList = DataMap.get(id);
        if(dataList != null){
            dataList.add(data);
//            System.out.println("add data");
            if (dataList.size() == window){
                double sum=0;
                double temp = dataList.get(0);
                double Max = temp;
                double Min = temp;
                for(int i=0;i<window;i++){
                    temp = dataList.get(i);
                    if(temp>Max){
                        Max = temp;
                    }
                    if(temp<Min){
                        Min = temp;
                    }
                    sum += temp;
                }
                double answer = sum/window;
                DataMap.put(id,null);
                answerMap.put(id,answer);
                error_upperMap.put(id,Max-answer);
                error_lowerMap.put(id,answer-Min);
//                System.out.println("you can get answer");
                return true;
            }else {
                DataMap.put(id,dataList);
            }
        }else{
//            System.out.println("data list of "+id+" = null");
            dataList = new LinkedList<Double>();
            dataList.add(data);
            DataMap.put(id,dataList);
        }
        return false;
    }
    public static double getAnswer(String id){
        return Double.parseDouble(df.format(answerMap.get(id)));
    }

    public static double getError_upper(String id) {
        return Double.parseDouble(df.format(error_upperMap.get(id)));
    }

    public static double getError_lower(String id) {
        return Double.parseDouble(df.format(error_lowerMap.get(id)));
    }
}
