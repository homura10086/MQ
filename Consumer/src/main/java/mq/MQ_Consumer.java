package mq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.util.Arrays;

@SpringBootApplication
public class MQ_Consumer {

	public static void main(String[] args) {
		SpringApplication.run(MQ_Consumer.class, args);
	}

}
