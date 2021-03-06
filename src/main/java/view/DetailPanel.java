﻿package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.domain.Animal;

@SuppressWarnings("serial")
public class DetailPanel extends JPanel {
	private static JLabel lb_no = new JLabel("번호 : ");
	private static JLabel lb_name = new JLabel("이름 : ");
	private static JLabel lb_type = new JLabel("종류 : ");
	private static JLabel lb_grade = new JLabel("등급 : ");
	private static JTextField tf_no = new JTextField();
	private static JTextField tf_name = new JTextField();
	private static JTextField tf_type = new JTextField();
	private static JTextField tf_grade = new JTextField();
	private static JTextArea tf_desc = new JTextArea(10, 30);
	
	
	
	private static Animal animal;
	private static boolean edit;
	
	public DetailPanel(Animal animal) {
		super();
		this.animal = animal;
		init();
	}

	public void init() {
		edit = false;
		this.setBounds(0, 50, 600, 450);
		this.setBackground(Color.white);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.add(getTopPanel());
		this.add(getBottomPanel());

	}
	
	public static JPanel getTopPanel(){
		JPanel p = new JPanel();
		p.add(BorderLayout.WEST, getTopLeftPanel());
		p.add(BorderLayout.WEST, getTopRightPanel());
		p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
		
		return p;
	}
	
	public static JPanel getTopLeftPanel(){
		JPanel p = new JPanel();
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		
		tf_no.setText(String.valueOf(animal.getaNo()));
		tf_name.setText(animal.getaName());
		tf_type.setText(animal.getaType());
		tf_grade.setText(animal.getaGrade());
		
		
		Dimension d1 = new Dimension(80, 50);
		Dimension d2 = new Dimension(150, 50);
		Dimension d3 = new Dimension(30, 50);
		lb_no.setPreferredSize(d1);
		lb_name.setPreferredSize(d1);	
		lb_type.setPreferredSize(d1);	
		lb_grade.setPreferredSize(d1);	
		
		tf_no.setPreferredSize(d2);
		tf_name.setPreferredSize(d2);
		tf_type.setPreferredSize(d2);
		tf_grade.setPreferredSize(d2);
		
		p.setPreferredSize(d3);	
		
		if(edit) {
			tf_no.enable(true);
			tf_name.enable(true);
			tf_type.enable(true);
			tf_grade.enable(true);
		}
		else {
			tf_no.enable(false);
			tf_name.enable(false);
			tf_type.enable(false);
			tf_grade.enable(false);
		}
		
		lb_no.setFont(new Font("Default", Font.BOLD, 20));
		lb_name.setFont(new Font("Default", Font.BOLD, 20));
		lb_type.setFont(new Font("Default", Font.BOLD, 20));
		lb_grade.setFont(new Font("Default", Font.BOLD, 20));
		tf_no.setFont(new Font("Default", Font.BOLD, 20));
		tf_name.setFont(new Font("Default", Font.BOLD, 20));
		tf_type.setFont(new Font("Default", Font.BOLD, 20));
		tf_grade.setFont(new Font("Default", Font.BOLD, 20));
		p1.add(lb_no);
		p1.add(tf_no);
		p2.add(lb_name);
		p2.add(tf_name);
		p3.add(lb_type);
		p3.add(tf_type);
		p4.add(lb_grade);
		p4.add(tf_grade);
		
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.add(BorderLayout.WEST, p1);
		p.add(BorderLayout.WEST, p2);
		p.add(BorderLayout.WEST, p3);
		p.add(BorderLayout.WEST, p4);
		
		
		return p;
	}
	public static JPanel getTopRightPanel(){
		PicturePanel p = new PicturePanel(animal.getaName());
		Dimension d = new Dimension(80, 300);
		p.setPreferredSize(d);	
		
		return p;
	}
	public static JPanel getBottomPanel(){
		JPanel p = new JPanel();
		Dimension d1 = new Dimension(100, 100);
		tf_desc.setPreferredSize(d1);	
		tf_desc.setText(animal.getaDesc());
		tf_desc.setFont(new Font("Default", Font.BOLD, 20));
		tf_desc.setLineWrap(true);
		if(edit) {
			tf_desc.enable(true);
		}
		else {
			tf_desc.enable(false);
		}
		p.add(tf_desc);
		return p;
	}
	

	
	
	public void setEdit(boolean edit){
		this.edit = edit;
		animal.setaNo(Integer.parseInt(tf_no.getText()));
		animal.setaName(tf_name.getText());
		animal.setaType(tf_type.getText());
		animal.setaGrade(tf_grade.getText());
		animal.setaDesc(tf_desc.getText());
		this.removeAll();
		this.add(getTopPanel());
		this.add(getBottomPanel());
	}
	
	public Animal getAnimal(){
		return animal;
	}

}
