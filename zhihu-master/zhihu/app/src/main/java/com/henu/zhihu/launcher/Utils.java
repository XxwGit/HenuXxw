package com.henu.zhihu.launcher;

import android.content.Context;

/**
 * Author:    Strange
 * Version    V1.0
 * Date:      17/4/25 下午3:30
 * Description:
 */
public class Utils {
    /**
     * dp转px
     *
     * @param context 上下文
     * @param dpValue dp值
     * @return px值
     */
    public static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
