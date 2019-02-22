package com.vote.util;

import java.util.*;

public class VoteSingleAction {

    private static VoteSingleAction voteSingleAction;
    private VoteSingleAction(){}
    private Map<String,List<String>> map = new TreeMap<>();
    private Set<String> citys = new TreeSet<>();

    public static VoteSingleAction getInstance(){
        if (voteSingleAction == null){
            synchronized (VoteSingleAction.class){
                if (voteSingleAction == null){
                    voteSingleAction  = new VoteSingleAction();
                }
            }
        }
        return voteSingleAction;
    }
    public static VoteSingleAction getCleanVoteSingleAction(){
        voteSingleAction = new VoteSingleAction();
        return voteSingleAction;
    }

    private void put(String city){
        citys.add(city);
        List<String> list = new ArrayList();
        map.put(city,list);
    }
    public synchronized boolean put(String city,String ip){
        if (!citys.contains(city)){
            put(city);
        }
        if(get(city,ip)){
           return false;
        }else{
            map.get(city).add(ip);
            return true;
        }
    }

    public boolean get(String city,String ip){
        if (!citys.contains(city)){
            put(city);
            return false;
        }
        return map.get(city).contains(ip);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (String item :citys){
            sb.append("城市：" + item + " ips：");
            for (String ip : map.get(item)){
                sb.append(ip);
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        VoteSingleAction action = getCleanVoteSingleAction();
        System.out.println(action.put("开封","120"));
        System.out.println(action.put("开封","119"));
        System.out.println(action.put("开封","120"));
        System.out.println(action.put("郑州","120"));
        System.out.println(action.put("郑州","120"));
        System.out.println(action.put("郑州","120"));
        System.out.println(action);
    }
}
