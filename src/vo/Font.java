package vo;

public class Font {
	public int FONT_NO;
	public String FONT_NAME;
	public String FONT_URL;
	public String FONT_FAMILY;
	
	
	public Font() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Font(int fONT_NO, String fONT_NAME, String fONT_URL, String fONT_FAMILY) {
		super();
		FONT_NO = fONT_NO;
		FONT_NAME = fONT_NAME;
		FONT_URL = fONT_URL;
		FONT_FAMILY = fONT_FAMILY;
	}
	
	

	public Font(String fONT_NAME, String fONT_URL, String fONT_FAMILY) {
		super();
		FONT_NAME = fONT_NAME;
		FONT_URL = fONT_URL;
		FONT_FAMILY = fONT_FAMILY;
	}


	public int getFONT_NO() {
		return FONT_NO;
	}


	public void setFONT_NO(int fONT_NO) {
		FONT_NO = fONT_NO;
	}


	public String getFONT_NAME() {
		return FONT_NAME;
	}


	public void setFONT_NAME(String fONT_NAME) {
		FONT_NAME = fONT_NAME;
	}


	public String getFONT_URL() {
		return FONT_URL;
	}


	public void setFONT_URL(String fONT_URL) {
		FONT_URL = fONT_URL;
	}


	public String getFONT_FAMILY() {
		return FONT_FAMILY;
	}


	public void setFONT_FAMILY(String fONT_FAMILY) {
		FONT_FAMILY = fONT_FAMILY;
	}
	
	
}
