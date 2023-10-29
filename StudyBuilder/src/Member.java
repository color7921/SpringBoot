

public class Member {

	private Integer id;
	private String name;
	private Integer pwd;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPwd() {
		return pwd;
	}

	public void setPwd(Integer pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", pwd=" + pwd + "]";
	}

	public static MemberBuilder builder() {
		return new MemberBuilder();
	}
	static class MemberBuilder {
		private Integer id;
		private String name;
		private Integer pwd;
		
		public MemberBuilder id(Integer id) {
			this.id = id;
			return this;
			
		}
		public MemberBuilder pwd(Integer pwd) {
			this.pwd = pwd;
			return this;
		}
		
		public MemberBuilder name(String name) {
			this.name = name;
			return this;
		}
		public Member build() {
			Member m = new Member();
			m.setId(this.id);
			m.setPwd(this.pwd);
			m.setName(this.name);
			return m;
		}
	}
}
