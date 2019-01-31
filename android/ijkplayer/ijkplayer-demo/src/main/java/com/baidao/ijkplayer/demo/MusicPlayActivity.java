package com.baidao.ijkplayer.demo;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class MusicPlayActivity extends AppCompatActivity {

    private IjkMediaPlayer ijkMediaPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_play);
        Button btnMusic = (Button) findViewById(R.id.button_play_music);
        Button btnVideo = (Button) findViewById(R.id.button_play_video);

        initPlayer();
        btnMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ijkMediaPlayer.setDataSource("http://www.ytmp3.cn/down/57903.mp3");
                    ijkMediaPlayer.prepareAsync();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = VideoPlayActivity.newIntent(MusicPlayActivity.this,
                        "http://cache.utovr.com/201508270528174780.m3u8 ", "ceshi ");
                startActivity(newIntent);
            }
        });
    }

    private void initPlayer() {
        ijkMediaPlayer = new IjkMediaPlayer();
        ijkMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        ijkMediaPlayer.setScreenOnWhilePlaying(true);
        ijkMediaPlayer.setOnPreparedListener(new OnPreparedListener(){
            @Override
            public void onPrepared(IMediaPlayer iMediaPlayer) {

            }
        });
    }
}