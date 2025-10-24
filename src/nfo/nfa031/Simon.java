package nfo.nfa031;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Simon {

	private Random random = new Random();
	private Scanner reader = new Scanner(System.in);

	private int touchesCount = 4;
	private ArrayList<Touche> touches;
	private boolean gameOver = false;
	private Partition iaPartition;
	private Partition playerPartition;

	public Simon() {
		initTouches();
		initPartitions();
	}

	private void initTouches() {
		touches = new ArrayList<Touche>();
		for (int i = 0; i < touchesCount; i++) {
			touches.add(new Touche(new Integer(i)));
		}
	}

	private void initPartitions() {
		iaPartition = new Partition("IA");
		playerPartition = new Partition("Nat");
	}

	private void play() {
		int choosenToucheNumber = random.nextInt(touchesCount);
		Touche choosenTouche = touches.get(choosenToucheNumber);
		iaPartition.increment(choosenTouche);
		iaPartition.display();
	}

	private void letTheOtherPlayerPlaying() {
		// TODO limiter le temps de réponse
		System.out.println("Your proposal (use space for delimiter):");
		String partition = reader.nextLine();
		playerPartition.setList(partition);
	}

	private void check() {
		this.gameOver = !iaPartition.compare(playerPartition);
	}

	public void run() {
		while (!this.gameOver) {
			play();
			letTheOtherPlayerPlaying();
			check();
		}
		System.out.println("Your score : " + iaPartition.size());
		reader.close();
	}

	public static void main(String[] args) {
		Simon simon = new Simon();
		simon.run();
	}

}
