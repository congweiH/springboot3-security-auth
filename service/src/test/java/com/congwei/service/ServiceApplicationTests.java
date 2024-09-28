package com.congwei.service;

import io.jsonwebtoken.Jwts;
import jakarta.xml.bind.DatatypeConverter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.SecretKey;

@SpringBootTest
class ServiceApplicationTests {

	@Test
	void contextLoads() {
		SecretKey secretKey = Jwts.SIG.HS512.key().build();
		String s = DatatypeConverter.printHexBinary(secretKey.getEncoded());
		System.out.println(s);
	}

}
