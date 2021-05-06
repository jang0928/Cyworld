package sistProject3.vo;

public class Follow {
	private String mem_id;
	private String following_id;
		public Follow(String mem_id) {
			super();
			this.mem_id = mem_id;
		}
		public String getMem_id() {
			return mem_id;
		}
		public void setMem_id(String mem_id) {
			this.mem_id = mem_id;
		}
		
		public String getFollowing_id() {
			return following_id;
		}
		public void setFollowing_id(String following_id) {
			this.following_id = following_id;
		}
		public Follow(String mem_id, String following_id) {
			super();
			this.mem_id = mem_id;
			this.following_id = following_id;
		}
		public Follow() {
			super();
			// TODO Auto-generated constructor stub
		}
}
