package com.easebean.winserve.resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandExecutor {
	public static String execute(String command) {
		String output = "";
		try {
			Process process = Runtime.getRuntime().exec(command);

			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				output += line + "\n";
			}

			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return output;
	}

	public Boolean useMachineCmd(String server, String userName, String password) {
		String output = execute("net use \\\\" + server + "\\admin$ " + password + " /user:" + userName);
		System.out.println(output);
		if (output.isBlank())
			return false;
		else
			return true;
	}
	
	public Boolean startService(String server, String service) {
		String output = execute("sc \\\\"+server+" start "+service);
		System.out.println(output);
		return false;
	}
	
	public Boolean stopService(String server, String service) {
		String output = execute("sc \\\\"+server+" stop "+service);
		System.out.println(output);
		return false;
	}
}
