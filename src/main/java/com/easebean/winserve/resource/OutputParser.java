package com.easebean.winserve.resource;

import java.util.Arrays;
import java.util.List;

public class OutputParser {
	public static String getStatusOfService(String serviceName) {
		String status = "";
		String output = CommandExecutor.execute("powershell.exe get-service "+serviceName+" | select status");
		if(!output.isBlank()) {
			List<String> l = Arrays.asList(output.split("\n"));
			status = l.get(l.size()-1);
		}
		return status;
	}
}
