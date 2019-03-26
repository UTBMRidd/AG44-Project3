package fr.cedric.components;

public enum NodeType {
	SOURCE(0),
	PIPE(1),
	CITY(2),
	START(3),
	END(4);
	
	private int id;
	
	NodeType(int id){
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
}
