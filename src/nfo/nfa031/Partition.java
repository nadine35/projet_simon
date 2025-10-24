package nfo.nfa031;

import java.util.ArrayList;
import java.util.Arrays;

public class Partition {

	private String owner;
	private ArrayList<Touche> list;

	public Partition(String owner) {
		this.owner = owner;
		this.list = new ArrayList<Touche>();
	}

	public String getOwner() {
		return this.owner;
	}

	public ArrayList<Touche> getList() {
		return this.list;
	}

	public void setList(String partition) {
		ArrayList<String> partitionArrayList = new ArrayList<String>(Arrays.asList(partition.split(" ")));
		ArrayList<Touche> newList = new ArrayList<Touche>();
		for (String item : partitionArrayList) {
			newList.add(new Touche(new Integer(item)));
		}
		this.list = newList;
	}

	public void display() {
		StringBuilder sb = new StringBuilder();
		sb.append("*** " + owner + " -> ");
		for (Touche touche : list) {
			sb.append(" ");
			sb.append(touche.getValue());
			sb.append(" ");
		}
		System.out.println(sb.toString());
	}

	public boolean compare(Partition other) {
		boolean areEqual = true;
		if (other.getList().size() != this.list.size()) {
			areEqual = false;
		} else {
			int i = 0;
			while (areEqual && i < this.list.size()) {
				if (!this.list.get(i).equals(other.getList().get(i))) {
					areEqual = false;
				}
				i++;
			}
		}
		return areEqual;
	}

	public void increment(Touche addedTouche) {
		this.list.add(addedTouche);
	}

	public int size() {
		return this.list.size();
	}

	public void reset() {
		this.list = new ArrayList<Touche>();
	}
}
