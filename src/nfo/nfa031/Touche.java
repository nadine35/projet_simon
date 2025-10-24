package nfo.nfa031;

public class Touche {

	private final Integer value;

	public Touche(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return this.value;
	}

	public int hashCode() {
		return this.value.intValue();
	}

	public boolean equals(Object obj) {
		boolean flag = false;
		Touche touche = (Touche) obj;
		if (touche.getValue().intValue() == this.value.intValue())
			flag = true;
		return flag;
	}

}
