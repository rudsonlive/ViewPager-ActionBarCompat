package br.liveo.adapter;

import br.liveo.fragments.FragmentsOne;
import br.liveo.fragments.FragmentsThree;
import br.liveo.fragments.FragmentsTwo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

	private final int PAGE_COUNT = 3;

	private FragmentsOne fragmentsOne = new FragmentsOne();
	private FragmentsTwo fragmentsTwo = new FragmentsTwo();
	private FragmentsThree fragmentsThree = new FragmentsThree();
	
	private Fragment[] listaDeFragments;

	public ViewPagerAdapter(FragmentManager fm) {
		super(fm);
		listaDeFragments = new Fragment[] { fragmentsOne, fragmentsTwo, fragmentsThree };
	}

	@Override
	public Fragment getItem(int arg0) {
		Bundle data = new Bundle();
		data.putInt("current_page", arg0 + 1);
		listaDeFragments[arg0].setArguments(data);
		return listaDeFragments[arg0];
	}

	@Override
	public int getCount() {
		return PAGE_COUNT;
	}

	public FragmentsOne getFragmentsOne() {
		return fragmentsOne;
	}

	public FragmentsTwo getfragmentsTwo() {
		return fragmentsTwo;
	}

	public FragmentsThree getfragmentsThree() {
		return fragmentsThree;
	}
}