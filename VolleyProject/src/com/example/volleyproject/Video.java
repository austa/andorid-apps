package com.example.volleyproject;

import android.net.Uri;

public class Video {
	private String videoTitle;
	private String videoPlayer;

	public Video(String videoTitle, String videoPlayer) {
		super();
		this.videoTitle = videoTitle;
		this.videoPlayer = videoPlayer;
	}
	
	
	public String getVideoPlayer() {
		return videoPlayer;
	}

	public void setVideoPlayer(String videoPlayer) {
		this.videoPlayer = videoPlayer;
	}

	public String getVideoTitle() {
		return videoTitle;
	}

	public void setVideoNames(String videoTitle) {
		this.videoTitle = videoTitle;
	}
	

}
