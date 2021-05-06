package vo;

public class Background {
	public int BG_NO;
	public String BG_NAME;
	public String BG_URL;
	
	public Background() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Background(int bG_NO, String bG_NAME, String bG_URL) {
		super();
		BG_NO = bG_NO;
		BG_NAME = bG_NAME;
		BG_URL = bG_URL;
	}
	
	

	public Background(String bG_NAME, String bG_URL) {
		super();
		BG_NAME = bG_NAME;
		BG_URL = bG_URL;
	}

	public int getBG_NO() {
		return BG_NO;
	}

	public void setBG_NO(int bG_NO) {
		BG_NO = bG_NO;
	}

	public String getBG_NAME() {
		return BG_NAME;
	}

	public void setBG_NAME(String bG_NAME) {
		BG_NAME = bG_NAME;
	}

	public String getBG_URL() {
		return BG_URL;
	}

	public void setBG_URL(String bG_URL) {
		BG_URL = bG_URL;
	}
	
	
}
