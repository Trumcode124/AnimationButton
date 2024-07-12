package Component;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.Timer;

import org.w3c.dom.Comment;

public class AnimationButton extends JButton implements ActionListener{
	private Color color1 = Color.decode("#111111");
	private Color color2 = Color.decode("#111111");
	private Boolean status = false;
	private int xlocate = 0;
	private final ChildrenDoc doc;
	private Timer t1;
	
	public AnimationButton() {
		setBackground(null);
		setBorder(null);
		setOpaque(false);
		
		setLayout(null);
		
		setContentAreaFilled(false);
		doc = new ChildrenDoc();
		doc.setBounds(xlocate,0,40,40);
		add(doc);
		addActionListener(this);
	}
	//use function paint
	@Override
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    Graphics2D g2d = (Graphics2D) g;
	    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    
	    int w = getWidth();
	    int h = getHeight();
	    
	    GradientPaint gp = new GradientPaint(0, 0, color1, w, h, color2);
	    g2d.setPaint(gp);
	    g2d.fillRoundRect(0, 0, w, h, 40, 40);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(status == false) {
			status = true;
			//Khi nút bật thì thay đổi màu
			setColor1(Color.decode("#000046"));
			setColor2(Color.decode("#1CB5E0"));
			//Tạo khoảng thời gian lặp lại là 1 millisecond giây, thời gian càng thấp thì đỗ trễ càng nhanh
			t1 = new Timer(1,new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(xlocate < 40) {
						//Ứng với 1 millisecond thì nó di chuyển được 2 bước
						xlocate += 2; //Increase the speed of the animation
						//Cập nhật vị trí của vật thể
						doc.setBounds(xlocate,0,40,40);
						///Cập nhật lại giao diện để hiển thị thay đổi
						invalidate();
						validate();
						repaint();
					}else {
						xlocate = 40;
						t1.stop();//Dừng trạng thái
					}
				}
			});
			t1.start();//Timer sẽ bắt đầu chạy và lập lịch các sự kiện theo delay đã định.
		}else {
			status = false;
			setColor1(Color.decode("#111111"));
			setColor2(Color.decode("#111111"));
			t1 = new Timer(1,new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(xlocate > 0) {
						xlocate -= 2; //Reduce the speed of the animation
						doc.setBounds(xlocate,0,40,40);
						
						invalidate();
						validate();
						repaint();
					}else {
						xlocate = 0;
						t1.stop();
					}
				}
			});
			t1.start();
		}
	}
	public Color getColor1() {
		return color1;
	}
	public void setColor1(Color color1) {
		this.color1 = color1;
	}
	public Color getColor2() {
		return color2;
	}
	public void setColor2(Color color2) {
		this.color2 = color2;
	}
	
}
