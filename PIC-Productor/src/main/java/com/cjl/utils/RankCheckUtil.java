package com.cjl.utils;

import com.cjl.pojo.Rank;

public class RankCheckUtil {

    public static boolean checkIsRank(String rank){
        if(Rank.SSR.equals(rank) || Rank.SR.equals(rank) || Rank.R.equals(rank) || Rank.N.equals(rank)){
            return true;
        }
        return false;
    }
}
