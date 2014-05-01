package com.example.listviewproject;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class OzelAdapter extends BaseAdapter {
	
	private LayoutInflater mInflater;
	private List<Kisi> mKisiListesi;
	
	public OzelAdapter(Activity activity, List<Kisi> kisiler) {
		mInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mKisiListesi = kisiler;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mKisiListesi.size();
	}

	@Override
	public Kisi getItem(int position) {
		// TODO Auto-generated method stub
		return mKisiListesi.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View satirView;
		satirView = mInflater.inflate(R.layout.satir_layout, null);
		TextView texview = (TextView) satirView.findViewById(R.id.isimsoyisim);
		ImageView imageView = (ImageView) satirView.findViewById(R.id.simge);
		
		Kisi kisi = mKisiListesi.get(position);
		texview.setText(kisi.getIsim());
		
		if (kisi.isKadinMi()) {
	        imageView.setImageResource(R.drawable.kadin_simge);
	    }
	    else {
	        imageView.setImageResource(R.drawable.erkek_simge);
	    }
	    return satirView;
		
	}

}
