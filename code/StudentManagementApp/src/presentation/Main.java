package presentation;

public class Main {

	public static void main(String[] args) {
		GUI g = new GUI();
		Controller con = new Controller(g);
		g.setVisible(true);

	}

}
