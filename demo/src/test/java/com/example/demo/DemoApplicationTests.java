package com.example.demo;

import com.example.demo.to.SendTo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	public static final String SERVER_URI = "http://localhost:8080/";

	@Test
	public void contextLoads() {
		DemoApplication.main(new String[] {});
		testCallService();
	}


	private static void testCallService() {
		RestTemplate restTemplate = new RestTemplate();
		SendTo sendTo = new SendTo();
		sendTo.setAction("send");
		sendTo.setWallet("000D1BAEC8EC208142C99059B393051BAC8380F9B5A2E6B2489A277D81789F3F");
		sendTo.setSource("ban_3e3j5tkog48pnny9dmfzj1r16pg8t1e76dz5tmac6iq689wyjfpi00000000");
		sendTo.setDestination("ban_3e3j5tkog48pnny9dmfzj1r16pg8t1e76dz5tmac6iq689wyjfpi00000000");
		sendTo.setAmount("1000000");
		SendTo response = restTemplate.postForObject(SERVER_URI+"send", sendTo, SendTo.class);
		System.out.print(response.toString());
	}

}
