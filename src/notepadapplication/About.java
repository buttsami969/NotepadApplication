/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepadapplication;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class About extends JFrame{
    
About()
    {
    
      setTitle("About NotePad Application");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(90, 65, 840, 650);
      setLayout(null);
      ImageIcon i=new ImageIcon(getClass().getResource("Images of Notepad Application of software/icons8_notepad_127px_2.png"));
      setIconImage(i.getImage());
     
     JLabel i1= new JLabel (new ImageIcon(getClass().getResource("Images of Notepad Application of software/icons8_notepad_127px_2.png")));
     i1.setBounds(390, 30, 100, 100);
     
     
    
      add(i1);
   
       JLabel i2= new JLabel ("<html><h2>Welcome to Notepad</h2><p>Windows Notepad is a simple text editor for Microsoft Windows and a basic text-editing program which enables computer users to create documents. It was first released as a mouse-based MS-DOS program in 1983, and has been included in all versions of Microsoft Windows since Windows 1.0 in 1985.All rights are reserved@2021</p><br><h2>Features Of NotePad Application:</h2>NoteApplication has six main menu Such as File,Edit,Format,Theme.Color,Help.Notepad File menu has also submenu in it such as New ,New Window,Save,SaveAs,Open,Exit,Print such as it is also Edit menu  as they sub menus such as  undo ,redo,cut,paste,selectAll,Findand File and replace menus in it.Also more menus visit and check it how it will help you. <br><br><h2>Java Developer:</h2>Abdul Sami Butt<br><h2>Phone No:</h2>03487967819<h2>Email:</h2>buttsami969@gmail.com<html>");
      i2.setBounds(100, 100, 640, 520);
      i2.setFont(new Font("Times New Roman",Font.PLAIN,15));
      add(i2);
      
      
    }
      public static void main(String args[]) {
       
       
      new About().setVisible(true);
    
     }
}
