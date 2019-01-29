package UI;

import Main.Handler;
import Resources.Images;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by AlexVR on 7/1/2018.
 */
public class UIManager {

    private Handler handler;
    private ArrayList<UIObject> objects;

    public UIManager(Handler handler){
        this.handler=handler;
        objects = new ArrayList<UIObject>();
    }

    public void tick(){
        for(UIObject o: objects){
            o.tick();
        }
    }

    public void Render(Graphics g){
        for(UIObject o: objects){
            o.render(g);
        }
    }

    public void onMousePressed(MouseEvent e) {
        for(UIObject o: objects){
            o.onMousePressed(e);
        }
    }

        public void onMouseMove(MouseEvent e){
        for(UIObject o: objects){
            o.onMouseMove(e);
        }
    }

    public void onMouseRelease(MouseEvent e){
        for(UIObject o: objects){
            o.onMouseRelease(e);
        }
    }

    public void addObjects (UIObject o){
        objects.add(o);
    }

    public void removeObsjects(UIObject o){
        objects.remove(o);
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ArrayList<UIObject> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<UIObject> objects) {
        this.objects = objects;
    }

    public void isActive(ArrayList<UIObject> o, Boolean active){
        for(UIObject i: o){
            i.active=active;
        }
    }
    
    //JJMP
    
    public class JJMP {

    	Handler handler;
    	Random random = new Random();

    	public boolean onScreen = false;

    	private int side = random.nextInt(6);

    	private int speed = 15;
    	private int xPos;
    	private int yPos;
    	private int width = 200;
    	private int height = 140;

    	public JJMP() {

    		if(this.side == 0) {

    			this.setxPos(0 - this.getWidth());

    		}

    		else {

    			this.setxPos(576 + this.getWidth());

    		}

    		this.setyPos(random.nextInt(768 - 100) + 100);

    	}

    	public void render(Graphics g) {

    		Graphics2D g2 = (Graphics2D) g;

    		g2.drawImage(Images.object[this.side], this.getxPos(), this.getyPos(), this.getWidth(), this.getHeight(), null);

    	}

    	public void tick() {

    		if(this.side % 2 == 0) {

    			if(this.xPos >= 768) {

    				this.setOnScreen(false);

    				this.setxPos(0 - this.width);

    				this.setyPos(random.nextInt(768 - this.getHeight()));

    				this.side = random.nextInt(6);

    			}

    			if(this.onScreen) {

    				this.setxPos(this.getxPos() + this.getSpeed());

    			}

    		}

    		else {

    			if(this.xPos + this.getWidth() <= 0) {

    				this.setOnScreen(false);

    				this.setxPos(576);

    				this.setyPos(random.nextInt(768 - this.getHeight()));	

    				this.side = random.nextInt(6);

    			}

    			if(this.onScreen) {

    				this.setxPos(this.getxPos() - this.getSpeed());

    			}

    		}
    		
    	}

    	public int getSpeed() {
    		return speed;
    	}
    	public int getxPos() {
    		return xPos;
    	}
    	public int getyPos() {
    		return yPos;
    	}
    	public int getWidth() {
    		return width;
    	}
    	public int getHeight() {
    		return height;
    	}
    	public void setSpeed(int speed) {
    		this.speed = speed;
    	}
    	public void setxPos(int xPos) {
    		this.xPos = xPos;
    	}
    	public void setyPos(int yPos) {
    		this.yPos = yPos;
    	}
    	public void setWidth(int width) {
    		this.width = width;
    	}
    	public void setHeight(int height) {
    		this.height = height;
    	}

    	public boolean isOnScreen() {
    		return onScreen;
    	}

    	public void setOnScreen(boolean onScreen) {
    		this.onScreen = onScreen;
    	}

    }

}
