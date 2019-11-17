package _01_Olympic_Rings;

import java.awt.Color;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One robot should draw one ring simultaneously with the other 4 robots.

	public static void main(String[] args) {
		
		Robot[] r = new Robot[5];
		Thread[] threads = new Thread[5];
		
		r[0] = new Robot(100, 635);
		r[1] = new Robot(165, 700); 
		r[2] = new Robot(230, 635); 
		r[3] = new Robot(295, 700); 
		r[4] = new Robot(360, 635); 
		
		for(int i = 0; i < r.length; i++) {
			r[i].hide();
		}
		
		r[0].setPenColor(new Color(3, 135, 201));
		r[1].setPenColor(new Color(255, 178, 45));
		r[2].setPenColor(Color.BLACK);
		r[3].setPenColor(new Color(26, 138, 68));
		r[4].setPenColor(new Color(243, 48, 83));

		for(int i = 0; i < r.length; i++) {
			r[i].setPenWidth(20);
		}

		for(int i = 0; i < r.length; i++) {
			r[i].setSpeed(5);
		}

		for(int i = 0; i < threads.length; i++) {
			int j = i;
			threads[i] = new Thread(()->circle(r[j]));
		}
		
		for(int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
	}
	
	public static void circle(Robot r) {
		int in = 10;
		r.penDown();
		for(int i = 0; i < 360/in; i++) {
			r.move(in);
			r.turn(in);
		}
		r.penUp();
	}
}

