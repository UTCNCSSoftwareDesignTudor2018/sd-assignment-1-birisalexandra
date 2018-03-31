package presentation;

public class Main {

	public static void main(String[] args) {
		GUI g = new GUI();
		new Controller(g);
		g.setVisible(true);

	}

}
