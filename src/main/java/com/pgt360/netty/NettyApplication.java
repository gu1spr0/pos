package com.pgt360.netty;

import com.pgt360.netty.netty.TCPServer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

@RequiredArgsConstructor
@SpringBootApplication
public class NettyApplication {

	public static void main(String[] args) {
		SpringApplication.run(NettyApplication.class, args);
	}

	private final TCPServer tcpServer;

	@Bean
	public ApplicationListener<ApplicationReadyEvent> readyEventApplicationListener(){
		return new ApplicationListener<ApplicationReadyEvent>() {
			@Override
			public void onApplicationEvent(ApplicationReadyEvent event) {
				tcpServer.start();
			}
		};
	}
}
