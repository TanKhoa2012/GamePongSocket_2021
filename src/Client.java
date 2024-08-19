
import java.awt.*;
import java.awt.RenderingHints.Key;
import java.awt.event.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.io.*;
import java.net.*;
import java.text.AttributedCharacterIterator;
import java.util.Map;
import java.util.Random;

import javax.swing.*;
import javax.swing.Timer;

public class Client extends JPanel  {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final int duoi = 730;
    final int tren =4;
	
	 Point imageCorner;
	 Point prevPt;
	 
	 int x=0;
	 int xVe=0;
	
	
	
	boolean bl = true;
	 
	 int xBall=285;
	 int yBall=370;
	 
	 int ballSpX=5;
	 int ballSpY=5;
	 String diem="0";
	 String diemdi="0";
	 Socket socket;
	 DataInputStream inputStream;
	 DataOutputStream outputStream;
	public Client()   {
		this.setBackground(Color.black);
		imageCorner = new Point(200,duoi);
		ClickListener clickListener = new ClickListener();
		DragListener dragListener = new DragListener();
		this.addMouseListener(clickListener);
		this.addMouseMotionListener(dragListener);
		 try {
			 socket = new Socket("Localhost",1234);
			 inputStream = new DataInputStream(socket.getInputStream());
			 outputStream = new DataOutputStream(socket.getOutputStream());
			 x=(int)imageCorner.getX();
				outputStream.writeInt(x);
				outputStream.flush();
				x=(int)imageCorner.getX();
				outputStream.writeInt(x);
				outputStream.flush();
				x=(int)imageCorner.getX();
				outputStream.writeInt(x);
				outputStream.flush();
			
				x=(int)imageCorner.getX();
				outputStream.writeInt(x);
				outputStream.flush();
				
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	
		
		
	}
	

	


	
   public void paintComponent(Graphics g) 
   {  
	
		   Graphics2D  g2d = (Graphics2D) g;
		   super.paintComponent(g);
     try {
		
    	 

	            System.out.println("x: "+xBall+" y: "+yBall);
	           
	           
				xVe =600 - inputStream.readInt()-215;
				xBall = inputStream.readInt();
				yBall = inputStream.readInt();
				x=(int)imageCorner.getX();
				outputStream.writeInt(x);
				outputStream.flush();
				diemdi = inputStream.readUTF();
				diem = inputStream.readUTF();
				
	
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
  
    
     g2d.setFont(new Font(" ", Font.BOLD, 70));
     g2d.setPaint(Color.blue);
     g2d.drawString(diem,255,330);
     g2d.drawString(diemdi,255,420);
     g2d.setPaint(Color.orange);
     
     
     g2d.fillRect((int) imageCorner.getX(), duoi,200 ,30);
     
     g2d.fillRect((int) xVe, tren,200 ,30);
     g2d.setPaint(Color.WHITE);
     g2d.fillOval(xBall, yBall, 30, 30);
	

			repaint();
	
	   
   		
   }
   
   private class ClickListener extends MouseAdapter 
   {
	   public void mousePressed(MouseEvent e)
	   {
			   prevPt = e.getPoint();
		
			
	   }

	
	   
   }
   private class DragListener extends MouseMotionAdapter  
   {
	   public void mouseDragged(MouseEvent e)
	   { 
		  
		  Point currentPt = e.getPoint();
		   
		
		   imageCorner.translate((int)(currentPt.getX()-prevPt.getX()),(int)(currentPt.getY()-prevPt.getY()));
	       prevPt = currentPt; 
	  
	       x=(int)imageCorner.getX();
			
	  
		

	        repaint();
	   
	   }
   }






}
