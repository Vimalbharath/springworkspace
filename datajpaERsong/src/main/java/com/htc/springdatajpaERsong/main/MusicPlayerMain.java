package com.htc.springdatajpaERsong.main;

import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.htc.springdatajpaERsong.config.JPAConfig;
import com.htc.springdatajpaERsong.model.Playlist;
import com.htc.springdatajpaERsong.model.Songs;
import com.htc.springdatajpaERsong.model.User;
import com.htc.springdatajpaERsong.service.ERService;





public class MusicPlayerMain {
	public static void main(String[] args) {
	final Logger Logger=LogManager.getLogger(MusicPlayerMain.class);
	Logger.info("HI");
	
	ApplicationContext context=new AnnotationConfigApplicationContext(JPAConfig.class);
	
	ERService erService=(ERService) context.getBean("erservice");
	
	boolean result = false;
//	result=erService.addUser(new User(2,"Bharath",25,"Ajith"));
//	System.out.println(result);
	
//	result=erService.addPlaylist(2, new Playlist(103,"Local",new Date()));
//	System.out.println(result);
	
//	List<Playlist> pl=erService.getAllPlaylists();
//	System.out.println(pl);
	
//	erService.addSong(new Songs(1003,"Chilla Chilla","Thuniv","Aniruth"));
//	erService.addSong(new Songs(1004,"Arabi Kuthu","Beast","Vijay"));
	
//	erService.playlistsongs(1002, 102);
	
	
	}
}
