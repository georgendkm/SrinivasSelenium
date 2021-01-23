package classwork.jse;

import java.io.IOException;

public class KillProcess {

	public static void killDrivers() throws IOException {
		Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
		Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
		Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
		Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
	}

}
