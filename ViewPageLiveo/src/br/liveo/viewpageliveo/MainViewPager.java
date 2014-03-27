package br.liveo.viewpageliveo;

import br.liveo.adapter.TabListener;
import br.liveo.adapter.ViewPagerAdapter;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

public class MainViewPager extends ActionBarActivity {

	private ViewPager mPager;    
	private ActionBar mActionBar;   
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainviewpager);

		mActionBar = getSupportActionBar();
        mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);		
		
        tabViewPage();     		
	}
		
	private void tabViewPage() {
		
        mPager = (ViewPager) findViewById(R.id.viewPager);
        mPager.setOffscreenPageLimit(3);
        mPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
        	
			@Override
			public void onPageSelected(int position) {
				super.onPageSelected(position);
				mActionBar.setSelectedNavigationItem(position);
			}
		});       
		
		FragmentManager fm = getSupportFragmentManager();
		ViewPagerAdapter adapter = new ViewPagerAdapter(fm);
		mPager.setAdapter(adapter);
		
		TabListener tabListener = new TabListener(mPager);

		ActionBar.Tab tabFragmentsOne = getSupportActionBar().newTab();
		ActionBar.Tab tabFragmentsTwo = getSupportActionBar().newTab();
		ActionBar.Tab tabFragmentsThree = getSupportActionBar().newTab();

		tabFragmentsOne.setText(R.string.tabone).setTabListener(tabListener);
		tabFragmentsTwo.setText(R.string.tabtwo).setTabListener(tabListener);
		tabFragmentsThree.setText(R.string.tabthree).setTabListener(tabListener);

		mActionBar.addTab(tabFragmentsOne);
		mActionBar.addTab(tabFragmentsTwo);
		mActionBar.addTab(tabFragmentsThree);
	}	
}
