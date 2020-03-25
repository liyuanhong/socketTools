package com.lyh.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.border.Border;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.plaf.basic.BasicTreeUI.SelectionModelPropertyChangeHandler;

import com.lyh.base.BaseObject;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class MainWindow extends BaseObject{

	private JFrame frmSockettools;
	private String curDir;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmSockettools.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//user.dir指定了当前的路径 
		this.curDir = System.getProperty("user.dir");
		
		frmSockettools = new JFrame();
		frmSockettools.setTitle("socketTools");
		frmSockettools.setBounds(100, 100, 763, 756);
		frmSockettools.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmSockettools.setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("开始");
		menu.setFont(new Font("宋体", Font.PLAIN, 15));
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("打开          ");
		menuItem.setFont(new Font("宋体", Font.PLAIN, 15));
		menuItem.setIcon(getIcon("/img/folder.png", 18, 18));
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("保存          ");
		menuItem_1.setFont(new Font("宋体", Font.PLAIN, 15));
		menu.add(menuItem_1);
		
		JMenuItem menuItem_4 = new JMenuItem("退出          ");
		menuItem_4.setFont(new Font("宋体", Font.PLAIN, 15));
		menu.add(menuItem_4);
		menuItem_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JMenu menu_1 = new JMenu("关于");
		menu_1.setFont(new Font("宋体", Font.PLAIN, 15));
		menuBar.add(menu_1);
		
		JMenuItem menuItem_3 = new JMenuItem("帮助          ");
		menuItem_3.setIcon(getIcon("/img/help.png", 18, 18));
		menuItem_3.setFont(new Font("宋体", Font.PLAIN, 15));
		menu_1.add(menuItem_3);
		
		JMenuItem menuItem_2 = new JMenuItem("版本号        ");
		menuItem_2.setIcon(getIcon("/img/info.png", 18, 18));
		menuItem_2.setFont(new Font("宋体", Font.PLAIN, 15));
		menu_1.add(menuItem_2);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);  //设置工具栏不可被拖动
		frmSockettools.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		ImageIcon icon = getIcon("/img/folder.png",25,25);
		JButton button = new JButton(icon);
//		button.setBorder(null);  //去掉图片周围的边框
		toolBar.add(button);
		
		ImageIcon icon_1 = getIcon("/img/start.png",25,25);
		JButton button_1 = new JButton(icon_1);
//		button_1.setBorder(null);
		toolBar.add(button_1);
		
		ImageIcon icon_2 = getIcon("/img/stop.png",25,25);
		JButton button_2 = new JButton(icon_2);
//		button_2.setBorder(null);
		toolBar.add(button_2);
		
		ImageIcon icon_3 = getIcon("/img/info.png",25,25);
		JButton button_3 = new JButton(icon_3);
//		button_3.setBorder(null);
		toolBar.add(button_3);
		
		ImageIcon icon_4 = getIcon("/img/help.png",25,25);
		JButton btnNewButton = new JButton(icon_4);
		toolBar.add(btnNewButton);
		
		JPanel panel = new JPanel();
		frmSockettools.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("宋体", Font.PLAIN, 18));
		panel.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("服务器", null, panel_1, null);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0};
		gbl_panel_1.rowWeights = new double[]{0.2,0.8};
		panel_1.setLayout(gbl_panel_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.menu);
		panel_5.setLayout(null);
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 0;
		panel_1.add(panel_5, gbc_panel_5);
		
		JLabel label = new JLabel("端口：");
		label.setFont(new Font("宋体", Font.PLAIN, 15));
		label.setBounds(14, 13, 45, 18);
		panel_5.add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 15));
		textField.setBounds(60, 10, 155, 24);
		panel_5.add(textField);
		textField.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(SystemColor.menu);
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 1;
		gbc_panel_6.insets = new Insets(5, 5, 5, 5);
		panel_1.add(panel_6, gbc_panel_6);
		panel_6.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_6.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("宋体", Font.PLAIN, 15));
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("客户机", null, panel_2, null);
		panel_2.setLayout(new GridLayout(0, 2, 10, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.PINK);
		panel_2.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.ORANGE);
		panel_2.add(panel_4);
		

	}
	
	/*
	 * 获取壳自适应的icon图标
	 * path传入的是项目当前的相对路径
	 */
	public ImageIcon getIcon(String path,int width,int height){
		ImageIcon icon1 = new ImageIcon(curDir + path);
		Image img = icon1.getImage();
		Image newimg = img.getScaledInstance(width,height,java.awt.Image.SCALE_SMOOTH); 
		ImageIcon icon = new ImageIcon(newimg);
		return icon;
	}
}
