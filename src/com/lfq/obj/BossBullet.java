package com.lfq.obj;

import com.lfq.utils.GameWin;
import com.lfq.utils.GameUtils;

import java.awt.*;

public class BossBullet extends GameObj{
	public BossBullet() {
		super();
	}

	public BossBullet(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
		super(img, width, height, x, y, speed, frame);
	}

	public BossBullet(Image img, int x, int y, double speed) {
		super(img, x, y, speed);
	}

	public BossBullet(int x, int y) {
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
