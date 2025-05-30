package com.lfq.obj;

import com.lfq.utils.GameWin;
import com.lfq.utils.GameUtils;

import java.awt.*;

public class TripleShellObj extends GameObj{
	public TripleShellObj() {
		super();
	}

	public TripleShellObj(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
		super(img, width, height, x, y, speed, frame);
	}

	public TripleShellObj(Image img, int x, int y, double speed) {
		super(img, x, y, speed);
	}

	public TripleShellObj(int x, int y) {
		super(x, y);
	}

	@Override
	public void paintSelf(Graphics g) {
		super.paintSelf(g);
		y-=speed;
		if(y<0){
			GameUtils.removeList.add(this);
		}
	}

	@Override
	public Rectangle getRec() {
		return super.getRec();
	}
}
