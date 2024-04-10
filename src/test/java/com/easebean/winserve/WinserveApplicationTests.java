package com.easebean.winserve;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.easebean.winserve.resource.CommandExecutor;
import com.easebean.winserve.resource.OutputParser;

@SpringBootTest
class WinserveApplicationTests {
	
	@Test
	void executeToGetAllFieldsOfService() {
		String output = CommandExecutor.execute("powershell.exe get-service wuauserv | select *");
		System.out.println(output);
	}

	@Test
	void parseOutputForStatusOfService() {
		String output = OutputParser.getStatusOfService("wuauserv");
		System.out.println(output);
	}
}
