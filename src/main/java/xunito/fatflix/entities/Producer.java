package xunito.fatflix.entities;

public class Producer {
	private int id;
	private String name;
	private String foundation;
	
	
	public Producer(String name, String foundation) {
		super();
		this.name = name;
		this.foundation = foundation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFoundation() {
		return foundation;
	}

	public void setFoundation(String foundation) {
		this.foundation = foundation;
	}
	
}
