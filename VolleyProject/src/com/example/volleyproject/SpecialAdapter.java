package com.example.volleyproject;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

public class SpecialAdapter extends BaseAdapter {
	
	private LayoutInflater mInflater;
	private List<Video> mVideoListesi;
	
	public SpecialAdapter(Activity activity, List<Video> videos) {
		super();
		mInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mVideoListesi = videos;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mVideoListesi.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mVideoListesi.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View satirView;
		satirView = mInflater.inflate(R.layout.special, null);
		TextView texview = (TextView) satirView.findViewById(R.id.textView1);
		ImageView imageview = (ImageView) satirView.findViewById(R.id.imageView1);
		
		Video video = mVideoListesi.get(position);
		texview.setText(video.getVideoTitle());
		imageview.set
		
	    return satirView;
	}

}
