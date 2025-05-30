package com.lfq.obj;

import com.lfq.utils.GameWin;
import com.lfq.utils.GameUtils;

import java.awt.*;

public class ShellObj extends GameObj{
	public ShellObj() {
		super();
	}

	public ShellObj(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
		super(img, width, height, x, y, speed, frame);
	}

	public ShellObj(Image img, int x, int y, double speed) {
		super(img, x, y, speed);
	}

	@Override
	public void paintSelf(Graphics g) {
		super.paintSelf(g);
		//实现子弹的移动，改变子弹的纵坐标
		y -= speed;

		if(y<0){
			GameUtils.removeList.add(this);
		}
	}

	@Override
	public Rectangle getRec() {
		return super.getRec();
	}
}
