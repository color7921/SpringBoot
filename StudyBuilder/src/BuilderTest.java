
public class BuilderTest {

	public static void main(String[] args) {
		Member m = Member.builder()
				.id(1234)
				.pwd(1234)
				.name("name")
				.build();
		
		System.out.println(m);
	}
}
