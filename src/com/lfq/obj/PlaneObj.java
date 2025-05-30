package com.lfq.obj;

import com.lfq.utils.GameWin;
import com.lfq.utils.GameUtils;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlaneObj extends GameObj{
	//记录我方飞机碰撞补给的次数
	public static int times=0;
	LittleBoss1 littleBoss1=new LittleBoss1();
	LittleBoss2 littleBoss2=new LittleBoss2();
	public PlaneObj() {
		super();
	}

	public PlaneObj(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
		super(img, width, height, x, y, speed, frame);
		//添加鼠标的移动事件
		this.frame.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				PlaneObj.super.x=e.getX()-19;
				PlaneObj.super.y=e.getY()-20;
			}
		});
	}

	public PlaneObj(Image img, int x, int y, double speed) {
		super(img, x, y, speed);
	}

	@Override
	public void paintSelf(Graphics g) {
		super.paintSelf(g);
		//我方飞机与敌方小飞机的碰撞检测，碰撞时候我方飞机和敌方小飞机都会消失
		for(Enemy1Obj enemy1Obj:GameUtils.enemy1ObjList){
			if(this.getRec().intersects(enemy1Obj.getRec())){
				//绘制爆炸
				ExplodeObj explodeObj=new ExplodeObj(x,y);
				GameUtils.explodeObjList.add(explodeObj);
				GameUtils.removeList.add(explodeObj);
				//让敌方小飞机消失的处理方法就是改变其坐标，让它消失在游戏窗口中，并不是真正的消失
				enemy1Obj.setX(-100);
				enemy1Obj.setY(-100);
				this.x=-200;
				this.y=-200;
				GameUtils.removeList.add(enemy1Obj);
				GameUtils.removeList.add(this);
				GameWin.state=3;
			}
		}
		//我方飞机与敌方大飞机的碰撞检测，碰撞时候我方飞机和敌方大飞机都会消失
		for(Enemy2Obj enemy2Obj:GameUtils.enemy2ObjList){
			if(this.getRec().intersects(enemy2Obj.getRec())){
				//绘制爆炸
				ExplodeObj explodeObj=new ExplodeObj(x,y);
				GameUtils.explodeObjList.add(explodeObj);
				GameUtils.removeList.add(explodeObj);
				//让敌方小飞机消失的处理方法就是改变其坐标，让它消失在游戏窗口中，并不是真正的消失
				enemy2Obj.setX(-100);
				enemy2Obj.setY(-100);
				this.x=-200;
				this.y=-200;
				GameUtils.removeList.add(enemy2Obj);
				GameUtils.removeList.add(this);
				GameWin.state=3;
			}
		}
		//我方飞机与敌方大飞机子弹的碰撞检测，碰撞时候我方飞机和敌方大飞机子弹都会消失
		for(Enemy2BulletObj enemy2BulletObj:GameUtils.enemy2BulletObjList){
			if(this.getRec().intersects(enemy2BulletObj.getRec())){
				//绘制爆炸
				ExplodeObj explodeObj=new ExplodeObj(x,y);
				GameUtils.explodeObjList.add(explodeObj);
				GameUtils.removeList.add(explodeObj);
				//让敌方小飞机消失的处理方法就是改变其坐标，让它消失在游戏窗口中，并不是真正的消失
				enemy2BulletObj.setX(-100);
				enemy2BulletObj.setY(-100);
				this.x=-200;
				this.y=-200;
				GameUtils.removeList.add(enemy2BulletObj);
				GameUtils.removeList.add(this);
				GameWin.state=3;
			}
		}
		//当敌方boss1和我方飞机碰撞的时候，我方飞机消失，敌方飞机不消失
		if(this.getRec().intersects(littleBoss1.getRec())){
			//绘制爆炸
			ExplodeObj explodeObj=new ExplodeObj(x,y);
			GameUtils.explodeObjList.add(explodeObj);
			GameUtils.removeList.add(explodeObj);
			this.x=-200;
			this.y=-200;
			GameUtils.removeList.add(this);
			GameWin.state=3;
		}
		//当敌方boss2和我方飞机碰撞的时候，我方飞机消失，敌方飞机不消失
		if(this.getRec().intersects(littleBoss2.getRec())){
			//绘制爆炸
			ExplodeObj explodeObj=new ExplodeObj(x,y);
			GameUtils.explodeObjList.add(explodeObj);
			GameUtils.removeList.add(explodeObj);
			this.x=-200;
			this.y=-200;
			GameUtils.removeList.add(this);
			GameWin.state=3;
		}
		//当我方飞机和敌方1号boss子弹碰撞之后，两者都消失
		for (LittleBoss1Bullet littleBoss1Bullet:GameUtils.littleBoss1BulletList) {
			if(this.getRec().intersects(littleBoss1Bullet.getRec())){
				//绘制爆炸
				ExplodeObj explodeObj=new ExplodeObj(x,y);
				GameUtils.explodeObjList.add(explodeObj);
				GameUtils.removeList.add(explodeObj);
				littleBoss1Bullet.setX(-100);
				littleBoss1Bullet.setY(-100);
				GameUtils.removeList.add(littleBoss1Bullet);
				this.x=-200;
				this.y=-200;
				GameUtils.removeList.add(this);
				GameWin.state=3;
			}
		}
		//当我方飞机和敌方2号boss子弹碰撞之后，两者都消失
		for (LittleBoss2Bullet littleBoss2Bullet:GameUtils.littleBoss2BulletList) {
			if(this.getRec().intersects(littleBoss2Bullet.getRec())){
				//绘制爆炸
				ExplodeObj explodeObj=new ExplodeObj(x,y);
				GameUtils.explodeObjList.add(explodeObj);
				GameUtils.removeList.add(explodeObj);
				littleBoss2Bullet.setX(-100);
				littleBoss2Bullet.setY(-100);
				GameUtils.removeList.add(littleBoss2Bullet);
				this.x=-200;
				this.y=-200;
				GameUtils.removeList.add(this);
				GameWin.state=3;
			}
		}
		//我方飞机碰撞补给之后，补给消失，我方飞机不消失
		for (GiftObj giftObj: GameUtils.giftObjList) {
			if(this.getRec().intersects(giftObj.getRec())){
				giftObj.setX(-100);
				giftObj.setY(-100);
				GameUtils.removeList.add(giftObj);
				times++;
			}
		}
		//我方飞机碰撞boss子弹后，两者都消失
		for(BossBullet bossBullet:GameUtils.bossBulletList){
			if(this.getRec().intersects(bossBullet.getRec())){
				//绘制爆炸
				ExplodeObj explodeObj=new ExplodeObj(x,y);
				GameUtils.explodeObjList.add(explodeObj);
				GameUtils.removeList.add(explodeObj);
				bossBullet.setX(-100);
				bossBullet.setY(-100);
				this.x=-200;
				this.y=-200;
				GameUtils.removeList.add(bossBullet);
				GameUtils.removeList.add(this);
				GameWin.state=3;
			}
		}


	}

	@Override
	public Rectangle getRec() {
		return super.getRec();
	}
}
