package _02_Advanced_Robot_Race;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	// Re-do the robot race recipe from level 3 module 0. 
	// This time, use threads to make all of the robots go at the same time.
	
	ArrayList<Robot> r = new ArrayList<Robot>();
	ArrayList<Thread> t = new ArrayList<Thread>();
	
	static int winner = -1;
	
	public static void main(String[] args) {
		AdvancedRobotRace rRace = new AdvancedRobotRace();
		rRace.setup();
		
	}
	
	void setup() {
		int amount = 100;
		
		for(int i = 0; i < amount; i++) {
			r.add(new Robot(i*(1500/amount)+100, 700));
			r.get(i).setSpeed(3);
		}
		
		for(int i = 0; i < amount; i++) {
			int j = i;
			t.add(new Thread(()->race(j) ));
		}
		
		for(int i = 0; i < amount; i++) {
			t.get(i).start();
		}
	}
	
	void race(int loc) {
		Random rand = new Random();
		
		while(winner == -1) {
			if(r.get(loc).getY() <= 100) {
				if(winner == -1) {
					winner = loc;
					JOptionPane.showMessageDialog(null, "Robot " + (winner+1) + " has won!");
				}
			}
			else if(r.get(loc).getY() > 0) {
				r.get(loc).move(rand.nextInt(50));
			}
		}
	}
	
}
