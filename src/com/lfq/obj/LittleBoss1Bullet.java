package com.lfq.obj;

import com.lfq.utils.GameWin;
import com.lfq.utils.GameUtils;

import java.awt.*;

public class LittleBoss1Bullet extends GameObj{
	public LittleBoss1Bullet() {
		super();
	}

	public LittleBoss1Bullet(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
		super(img, width, height, x, y, speed, frame);
	}

	public LittleBoss1Bullet(Image img, int x, int y, double speed) {
		super(img, x, y, speed);
	}

	public LittleBoss1Bullet(int x, int y) {
		super(x, y);
	}

	@Override
	public void paintSelf(Graphics g) {
		super.paintSelf(g);
		y+=speed;
		//越界判断
		if(this.y>800){
			GameUtils.removeList.add(this);
		}
	}

	@Override
	public Rectangle getRec() {
		return super.getRec();
	}
}
