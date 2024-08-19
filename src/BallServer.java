
	import java.awt.*;

	import java.awt.event.*;
	
import java.io.*;

import java.net.*;

import java.util.*;


import javax.swing.*;
import javax.swing.Timer;


	public class BallServer extends JPanel implements ActionListener{
	

		 
		 int x=0;

		 

		 int xVe=0;

		 
		 int xBall=285;
		 int yBall=370;
		
		 int ballSpX=5;
		 int ballSpY=5;
		 int Diem=0;
		 int DiemDi=0;
		 String diem="0";
		 String diemdi="0";
		 

		 
		int randomX=0;

		Server server = new Server();

		public BallServer() {
			Timer timer = new Timer(1, this);
			timer.start();
		}



	@Override
	public void actionPerformed(ActionEvent e) {
		  System.out.println("đang xu ly");
          
          try {
        	  xBall +=ballSpX;
	          yBall +=ballSpY;
	         
	          server.OneSocket(600-xVe-215,xBall, yBall, diemdi, diem);
	          server.TwoSocket(x, 560- xBall, 735 - yBall, diemdi, diem);
	          x=server.OneSocket1();
	          xVe = 600-server.OneSocket2()-215;
	       
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		if((yBall>=700&&xBall>=x-30&&xBall<=x+200)||(yBall<=30&&xBall>=xVe-30&&xBall<=xVe+200))
		{
			ballSpY+=1*Math.signum(ballSpY);
			ballSpX+=1*Math.signum(ballSpX);
			ballSpX *= new Random().nextInt(2)==0 ? 1:-1;
			ballSpY *=-1;
			
		}
		if(yBall>800||yBall<0)
		{
			if(yBall>=800)
			{
				DiemDi= Integer.parseInt(diemdi)+1;
				diemdi =""+DiemDi;
				
			}else
			{
				Diem= Integer.parseInt(diem)+1;
				diem =""+Diem;
				
			}
			yBall = 370;
			xBall = 280;
			ballSpX = new Random().nextInt(2)==0 ? 5:-5;
			ballSpY = new Random().nextInt(2)==0 ? 5:-5;
			
		}
		if(xBall<=0||xBall>=560) 
		{
			ballSpX*=-1;
		}
		
		
		
		
		
		
	}

	
	


}
