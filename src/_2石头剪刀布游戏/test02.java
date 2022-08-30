package _2石头剪刀布游戏;
import java.awt.*;//引入抽象窗口工具类包
import java.awt.event.*;//引入事件
import javax.swing.*;//引入组件

//定义一个窗口类，该类实现 ActionListener 接口；
public class test02 extends JFrame implements ActionListener{
    JButton shitou,jiandao,bu,clear; //定义 JButton 对象
    JPanel north,center,west,east,south; //定义 JPanel 对象
    JLabel label,imgLabel1,imgLabel2,label2; // 定义JLable 对象
    JMenuBar mbar;
    JMenu show;
    JMenuItem text,image,end,about;  //菜单项
    JDialog dlg;  //弹窗

    static String STPATH = "bu.png",JDPATH = "jiandao.png",BUPATH = "shitou.png";
    int status = 0;
    public test02() {
        setTitle("石头剪刀布游戏"); //设置窗体标题，修改标题为“石头剪刀布游戏”；
        setDefaultCloseOperation(EXIT_ON_CLOSE); //设置窗体关闭按钮
        setBounds(250, 250, 600, 500);  //设置窗体左上顶点坐标；设置窗体大小，修改窗体大小为：350×350；

        dlg = new JDialog(this,"关于游戏");
        dlg.setBounds(325, 375, 350, 200);
        dlg.setModal(true);

        dlg.add(new JLabel("    该游戏为简单的石头剪刀布游戏！！    "),BorderLayout.CENTER);
        //dlg.add(new JLabel("   All rights reserved by Natural"),BorderLayout.SOUTH);

        mbar = new JMenuBar();//创建菜单栏并添加到窗体顶部
        setJMenuBar(mbar);

        show = new JMenu("结果显示方式");
        about = new JMenuItem("关于游戏");
        mbar.add(show);
        mbar.add(about);

        text = new JMenuItem("文本显示");
        image = new JMenuItem("图形显示");
        end = new JMenuItem("结束游戏");
        show.add(text);
        show.add(image);
        show.add(end);

        north = new JPanel(); //建立JPanel对象north
        north.setBackground(Color.yellow); //设置north的背景为yellow
        shitou = new JButton("石头");  //建立JButton对象 并设置文本为石头
        jiandao = new JButton("剪刀"); //建立JButton对象 并设置文本为剪刀
        bu = new JButton("布"); //建立JButton对象 并设置文本为布
        clear = new JButton("清空");//建立JButton对象 并设置文本为清空
        center = new JPanel(); //建立JPanel对象center
        center.setBackground(Color.green);	//设置center的背景为green
        label = new JLabel("选择剪刀、石头、布开始游戏"); //建立JLabel对象label

        west = new JPanel();
        east = new JPanel();
        south = new JPanel();
        imgLabel1 = new JLabel();
        imgLabel2 = new JLabel();
        label2 = new JLabel();
        label2.setFont(new Font("宋体",Font.BOLD,20));

        shitou.addActionListener(this);	//给 shitou 添加事件监听器
        jiandao.addActionListener(this); //给 jiandao 添加事件监听器
        bu.addActionListener(this); //给 bu添加事件监听器
        clear.addActionListener(this); // 给 clear添加事件监听器

        about.addActionListener(this);
        text.addActionListener(this);
        image.addActionListener(this);
        end.addActionListener(this);

        north.add(shitou); //把 shitou 放进 north 中
        north.add(jiandao); // 把 jiandao 放进 north 中
        north.add(bu); //把 bu 放进 north 中
        north.add(clear);// 把 clear 放进 north 中
        center.add(label); //把 label 放进 center 中
        west.add(imgLabel1);
        east.add(imgLabel2);
        south.add(label2);

        add(north,BorderLayout.NORTH); //将north放入 JFrame中 并设置布局为容器的顶部
        add(center,BorderLayout.CENTER);// 将center放入 JFrame中 并设置布局为容器的中央
        add(west,BorderLayout.WEST);
        add(east,BorderLayout.EAST);
        add(south,BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == about) {
            dlg.setVisible(true);
        }

        if(e.getSource() == text) {
            status = 0;
            imgLabel1.setIcon(null);
            imgLabel2.setIcon(null);
            center.setBackground(Color.green);
            label.setText("选择剪刀、石头、布开始游戏");
//            label2.setText("");
//            imgLabel1.setText("");
//            imgLabel2.setText("");
        }else if(e.getSource() == image) {
            status = 1;
            imgLabel1.setHorizontalTextPosition(JLabel.CENTER);
            imgLabel1.setVerticalTextPosition(JLabel.TOP);
            imgLabel2.setHorizontalTextPosition(JLabel.CENTER);
            imgLabel2.setVerticalTextPosition(JLabel.TOP);
            imgLabel1.setIcon(null);
            imgLabel2.setIcon(null);
//            label2.setText("");
//            imgLabel1.setText("");
//            imgLabel2.setText("");
            float[] hsb= Color.RGBtoHSB(238, 238, 238, null);
            center.setBackground(Color.getHSBColor(hsb[0], hsb[1], hsb[2]));
            label.setText("选择剪刀、石头、布开始游戏");
        }

        if(status == 0) {
            if(e.getSource() == shitou){
                int i = (int)(Math.random()*10)%3;
                switch(i){
                    case 0 : label.setText("你出石头，电脑出石头，平局！"); break;
                    case 1 : label.setText("你出石头，电脑出剪刀，恭喜你赢了！"); break;
                    case 2 : label.setText("你出石头，电脑出布，很遗憾你输了！"); break;
                }
            }
            if(e.getSource() == jiandao ){
                int i = (int)(Math.random()*10)%3;
                switch(i){
                    case 0 : label.setText("你出剪刀，电脑出剪刀，平局！"); break;
                    case 1 : label.setText("你出剪刀，电脑出布，恭喜你赢了！"); break;
                    case 2 : label.setText("你出剪刀，电脑出石头，很遗憾你输了！"); break;
                }
            }
            if(e.getSource() == bu){
                int i = (int)(Math.random()*10)%3;
                switch(i){
                    case 0 : label.setText("你出布，电脑出布，平局！"); break;
                    case 1 : label.setText("你出布，电脑出石头，恭喜你赢了！"); break;
                    case 2 : label.setText("你出布，电脑出剪刀，很遗憾你输了！"); break;
                }
            }
            if(e.getSource() == clear) {
                label.setText("选择剪刀、石头、布开始游戏");
            }
        }else if(status == 1) {
            if(e.getSource() == shitou){
                label.setText("");
                imgLabel1.setText("You");
                imgLabel2.setText("Computer");
                imgLabel1.setIcon(new ImageIcon(STPATH));
                int i = (int)(Math.random()*10)%3;
                switch(i){
                    case 0 :
                        imgLabel2.setIcon(new ImageIcon(STPATH));
                        label2.setText("平局");
                        break;
                    case 1 :
                        imgLabel2.setIcon(new ImageIcon(JDPATH));
                        label2.setText("你赢了");
                        break;
                    case 2 :
                        imgLabel2.setIcon(new ImageIcon(BUPATH));
                        label2.setText("你输了");
                        break;
                }
            }else if(e.getSource() == jiandao ){
                label.setText("");
                imgLabel1.setText("You");
                imgLabel2.setText("Computer");
                imgLabel1.setIcon(new ImageIcon(JDPATH));
                int i = (int)(Math.random()*10)%3;
                switch(i){
                    case 0 :
                        imgLabel2.setIcon(new ImageIcon(STPATH));
                        label2.setText("你输了");
                        break;
                    case 1 :
                        imgLabel2.setIcon(new ImageIcon(JDPATH));
                        label2.setText("平局");
                        break;
                    case 2 :
                        imgLabel2.setIcon(new ImageIcon(BUPATH));
                        label2.setText("你赢了");
                        break;
                }
            }else if(e.getSource() == bu){
                label.setText("");
                imgLabel1.setText("You");
                imgLabel2.setText("Computer");
                imgLabel1.setIcon(new ImageIcon(BUPATH));
                int i = (int)(Math.random()*10)%3;
                switch(i){
                    case 0 :
                        imgLabel2.setIcon(new ImageIcon(STPATH));
                        label2.setText("你赢了");
                        break;
                    case 1 :
                        imgLabel2.setIcon(new ImageIcon(JDPATH));
                        label2.setText("你输了");
                        break;
                    case 2 :
                        imgLabel2.setIcon(new ImageIcon(BUPATH));
                        label2.setText("平局");
                        break;
                }
            }else if(e.getSource() == clear) {
                imgLabel1.setIcon(null);
                imgLabel2.setIcon(null);
                label.setText("选择剪刀、石头、布开始游戏");
                label2.setText("");
                imgLabel1.setText("");
                imgLabel2.setText("");
            }
        }

        if(e.getSource() == end)
            dispose(); //释放所有本机屏幕资源
    }


    public static void main(String[] args) {
        test02 g = new test02();
        g.setVisible(true);
    }
}