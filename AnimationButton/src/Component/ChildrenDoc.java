package Component;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class ChildrenDoc extends JPanel {
	private Color color1 = Color.decode("#ffffff");
	private Color color2 = Color.decode("#ffffff");
	
	public ChildrenDoc() {
		setBackground(null); //Xóa màu nền của panel
		setOpaque(false); //Thành phần được vẽ trong suốt
		setBorder(null);// Xóa đường viền của panel
		setLayout(null);
	}
	@Override
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    Graphics2D g2d = (Graphics2D) g;
	    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    //Lấy chiều rộng và chiều cao của Panel
	    int w = getWidth();
	    int h = getHeight();
	    //Tạo một đối tượng GradientPaint với hai màu trắng ở hai điểm đầu và cuối của gradient.
	    GradientPaint gp = new GradientPaint(0, 0, color1, w, h, color2);
	    g2d.setPaint(gp);
	    g2d.fillRoundRect(0, 0, w, h, 40, 40); //Vẽ một hình chữ nhật bo góc với chiều rộng, chiều cao của panel 
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
