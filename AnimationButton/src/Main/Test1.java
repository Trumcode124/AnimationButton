package Main;

import javax.swing.JFrame;

import Component.AnimationButton;

public class Test1 extends JFrame{
	public Test1() {
		this.setTitle("Animation Button");
		this.setSize(300,300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		AnimationButton btn = new AnimationButton();
		btn.setBounds(100, 100, 80, 40);
		this.add(btn);
	}
	public static void main(String[] args) {
		Test1 t = new Test1();
		t.setVisible(true);
	}
}
