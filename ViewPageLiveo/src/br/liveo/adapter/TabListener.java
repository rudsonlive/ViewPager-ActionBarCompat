package br.liveo.adapter;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;

public class TabListener implements ActionBar.TabListener {

	private ViewPager mPager;
	public TabListener(ViewPager mPager) {
		this.mPager = mPager;
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		ft.commit();
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		mPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
	}
}