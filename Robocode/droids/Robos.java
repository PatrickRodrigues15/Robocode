package droids;

import robocode.*;

public class Robos extends AdvancedRobot {
	boolean movingForward;

	public void run() {
		// executa o robo
		while (true) {

			setAhead(400);
			movingForward = true; // move o robo
			waitFor(new TurnCompleteCondition(this));

			setTurnLeft(180);

			waitFor(new TurnCompleteCondition(this));

			setTurnRight(180);

			waitFor(new TurnCompleteCondition(this));

			turnGunRight(360);// vira o canhão para direita
			// execute();
			back(100); // move o robo
			turnGunRight(360);
		}
	}

	public void onScannedRobot(ScannedRobotEvent e) {
		if (e.getDistance() > 100) {
			fire(1);
		} else {
			// atira
			if (e.getDistance() <= 40)
				fire(3);	
		}
		// fire(1);
	}

	public void onHitByBullet(HitByBulletEvent e) {
		// chamado quano o inimigo é atingido pela bala
		setTurnRight(e.getBearing());
		fire(1);
		back(30); 
	}

	public void onHitWall(HitWallEvent e) {
		reverseDirection();
		// back(20);
	}

	public void reverseDirection() {
		if (movingForward) {
			setBack(400);
			movingForward = false;
		} else {
			setAhead(400);
			movingForward = true;
		}
	}

}
