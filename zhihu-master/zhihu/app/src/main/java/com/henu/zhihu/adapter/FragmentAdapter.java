package com.henu.zhihu.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;

import java.util.List;

import static com.henu.zhihu.activity.FragmentActivity.fragmentsUpdateFlag;

/**
 * Created by 随大大 on 2017/4/3.
 */

public class FragmentAdapter extends FragmentPagerAdapter{
    /**
     * 获取fragment的容器
     */
    private List<Fragment> list;

    /**
     * 声明fragment的管理
     */
    private FragmentManager fm;

    /**
     * 必须实现的构造方法
     * @param fm
     */
    public FragmentAdapter(FragmentManager fm) {
        super(fm);
        this.fm = fm;
    }

    /**
     * 建议使用的构造函数 对fm和list进行初始化
     * @param fm
     * @param list
     */
    public FragmentAdapter(FragmentManager fm,List list){
        super(fm);
        this.list = list;
        this.fm = fm;
    }


    /**
     * 必须实现的方法用来获取当前的fragment对象的引用
     * @param position
     * @return
     */
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    /**
     * 必须实现的方法 用于返回fragment的数量
     * @return
     */
    @Override
    public int getCount() {
        return list.size();
    }


    /**
     * 完美刷新fragment 博客地址http://blog.csdn.net/z13759561330/article/details/40737381
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //得到缓存的fragment
        Fragment fragment = (Fragment) super.instantiateItem(container,
                position);
        //得到tag，这点很重要
        String fragmentTag = fragment.getTag();


        if (fragmentsUpdateFlag[position % fragmentsUpdateFlag.length]) {
            //如果这个fragment需要更新

            FragmentTransaction ft = fm.beginTransaction();
            //移除旧的fragment
            ft.remove(fragment);
            //换成新的fragment
            fragment = list.get(position % list.size());
            //添加新fragment时必须用前面获得的tag，这点很重要
            ft.add(container.getId(), fragment, fragmentTag);
            ft.attach(fragment);
            ft.commit();
            //复位更新标志
            fragmentsUpdateFlag[position % fragmentsUpdateFlag.length] = false;
        }
        return fragment;
    }
}
