package _06_Snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

// Go through the methods and complete the steps in this class
// and the Snake class

public class _00_SnakeGame implements ActionListener, KeyListener {
	public static final Color BORDER_COLOR = Color.WHITE;
	public static final Color BACKGROUND_COLOR = Color.BLACK;
	public static final Color FOOD_COLOR = Color.RED;
	public static final int WIDTH = 15;
	public static final int HEIGHT = 12;
	public static final int WINDOW_SCALE = 50;
	public static final int WINDOW_WIDTH = WINDOW_SCALE * WIDTH;
	public static final int WINDOW_HEIGHT = WINDOW_SCALE * HEIGHT;
	Random ranGen = new Random();

	private JFrame window;
	private JPanel panel;

	private Snake snake;

	private Timer timer;

	private Location foodLocation;

	public _00_SnakeGame() {
		makeFrame();

		setFoodLocation();

		startGame();
	}

	public void startGame() {
		// 1. Save the instructions for the game in the following string variable.
		String instructions = "1. Have fun!!" + "2. Have fun!!!" + "3. DON'T ASK QUESTIONS!!!!" + "4. Figure it out.";

		String[] options = new String[] { "Expert", "Moderate", "Beginner" };
		int input = JOptionPane.showOptionDialog(null, instructions, "Snake", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, JOptionPane.NO_OPTION);
		String choice = options[input];

		// 2. Use a switch statement to determine which difficulty was chosen.
		// Use timer.setDelay(delay) with different numbers to change the speed
		// of the game. The smaller the number, the faster it goes.
		switch (choice) {
		case "Expert":
			timer.setDelay(50);
			break;

		case "Moderate":
			timer.setDelay(100);
			break;

		case "Beginner":
			timer.setDelay(150);
			break;

		default:
			System.out.println("Something went wrong in the start game method.");
			System.exit(0);
			break;
		}
		// 3. start the timer
		timer.start();
	}

	public void makeFrame() {
		snake = new Snake(new Location(WIDTH / 2, HEIGHT / 2));

		window = new JFrame("Snake");
		panel = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			public void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;

				g2.setColor(BACKGROUND_COLOR);
				g2.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

				g2.setColor(FOOD_COLOR);
				g2.drawOval(foodLocation.x * WINDOW_SCALE, foodLocation.y * WINDOW_SCALE, Snake.BODY_SIZE,
						Snake.BODY_SIZE);
				g.setColor(Color.GREEN);
				g.drawString("You score is : " + snake.score, WINDOW_WIDTH - 150, 20);
				snake.draw(g);
			}
		};

		panel.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		window.add(panel);

		timer = new Timer(0, this);

		window.pack();
		window.addKeyListener(this);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);

	}

	public void restartGame() {
		window.dispose();

		makeFrame();
		int lx = ranGen.nextInt(WINDOW_WIDTH);
		int ly = ranGen.nextInt(WINDOW_HEIGHT);
		Location newHeadLocation = new Location(lx,ly);
snake.reset(newHeadLocation);  
		setFoodLocation();

		startGame();
	}

	public static void main(String[] args) {
		new _00_SnakeGame();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// 1. Use a switch statement on e.getKeyCode()
		// to determine which key was pressed.
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			snake.setDirection(Direction.LEFT);
			break;

		case KeyEvent.VK_D:
			snake.setDirection(Direction.RIGHT);
			break;

		case KeyEvent.VK_W:
			snake.setDirection(Direction.UP);

			break;

		case KeyEvent.VK_S:
			snake.setDirection(Direction.DOWN);
			break;
		case KeyEvent.VK_SPACE:
			snake.feed();
break;
		default:
			System.out.println("invalid key.");
			break;
		}
		// if an arrow key is pressed, set the snake's
		// direction accordingly

		// if the space key is pressed, call the snake's feed method

	}

	private void setFoodLocation() {
		// 1. Create a new Location object that is set to a random location
		int foodX = ranGen.nextInt(WIDTH);
		int foodY = ranGen.nextInt(HEIGHT);
		Location location = new Location(foodY, foodY);
		// 2. set the foodLocation variable equal to the Location object you just
		// created.
		foodLocation = location;
		// use the snake's isLocationOnSnake method to make sure you don't put the food
		// on the snake
		snake.isLocationOnSnake(foodLocation);

	}

	private void gameOver() {

		// 1. stop the timer
		timer.stop();
		// 2. tell the user their snake is dead
		JOptionPane.showMessageDialog(null, "Your snake has died");
		// 3. ask them if they want to play again.
		int choice = JOptionPane.showConfirmDialog(null, "Do you want to play again");
		if (choice == JOptionPane.YES_OPTION) {
			restartGame();
		}
		if (choice == JOptionPane.NO_OPTION) {
			System.exit(0);
		} else {
			System.exit(0);
		}
		// 4. if they want to play again
		// reset the snake and the food and start the timer
		// else, exit the game

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 1. update the snake
		snake.update();
		// 2. if the snake is colliding with its own body
		// or if the snake is out of bounds, call gameOver
		if (snake.isHeadCollidingWithBody() || snake.isOutOfBounds()) {
			gameOver();
		}
		// 3. if the location of the head is equal to the location of the food,
		// feed the snake and set the food location
		if (snake.getHeadLocation().equals(foodLocation)) {
			snake.feed();
			setFoodLocation();
		}
		// 4. call panel.repaint();
		panel.repaint();
	}
}
