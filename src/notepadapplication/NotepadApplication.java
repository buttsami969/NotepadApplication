
package notepadapplication;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDarkerContrastIJTheme;
import java.awt.*;
import java.awt.event.*;
import static java.awt.event.ActionEvent.SHIFT_MASK;
import java.awt.event.*;
import java.awt.print.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.*;
import javax.swing.filechooser.*;
import static javax.swing.text.html.HTML.Tag.TEXTAREA;
import javax.swing.undo.*;
import say.swing.JFontChooser;

public class NotepadApplication extends JFrame implements ActionListener {

    private Container c;
    String filename;
    String fileContent;
    JFileChooser jc;
    JLabel statusBar;
    JMenuBar menubar = new JMenuBar();

    JMenu File = new JMenu("File");
    JMenu Edit = new JMenu("Edit");
    JMenu Format = new JMenu("Format");
    JMenu coLor = new JMenu("Color");
    JMenu Theme = new JMenu("Theme");
    JMenu view = new JMenu("View");
    JMenu Help = new JMenu("Help");

    //All file menu option
    ImageIcon newicon = new ImageIcon(getClass().getResource("Images of Notepad Application of software/icons8_file_30px.png"));
    ImageIcon newwindwoicon = new ImageIcon(getClass().getResource("Images of Notepad Application of software/icons8_new_document_30px.png"));
    ImageIcon openicon = new ImageIcon(getClass().getResource("Images of Notepad Application of software/icons8_open_view_30px_1.png"));
    ImageIcon saveicon = new ImageIcon(getClass().getResource("Images of Notepad Application of software/icons8_save_all_30px_2.png"));
    ImageIcon saveiconas = new ImageIcon(getClass().getResource("Images of Notepad Application of software/icons8_save_close_30px.png"));
    ImageIcon print = new ImageIcon(getClass().getResource("Images of Notepad Application of software/icons8_print_30px_1.png"));
    ImageIcon exit = new ImageIcon(getClass().getResource("Images of Notepad Application of software/icons8_exit_30px.png"));

    JMenuItem New = new JMenuItem("New", newicon);
    JMenuItem NewWindow = new JMenuItem("New Window", newwindwoicon);
    JMenuItem Open = new JMenuItem("Open", openicon);
    JMenuItem save = new JMenuItem("Save", saveicon);
    JMenuItem SaveAs = new JMenuItem("SaveAs", saveiconas);
    JMenuItem Print = new JMenuItem("Print", print);
    JMenuItem Exit = new JMenuItem("Exit", exit);

    ImageIcon Textureicon = new ImageIcon(getClass().getResource("Images of Notepad Application of software/icons8_theme_park_30px_1.png"));
    ImageIcon Smarticon = new ImageIcon(getClass().getResource("Images of Notepad Application of software/icons8_theme_park_30px_3.png"));
    ImageIcon Noireicon = new ImageIcon(getClass().getResource("Images of Notepad Application of software/icons8_change_theme_30px.png"));
    ImageIcon Acryicon = new ImageIcon(getClass().getResource("Images of Notepad Application of software/icons8_theme_park_30px_4.png"));
    ImageIcon Aeroicon = new ImageIcon(getClass().getResource("Images of Notepad Application of software/icons8_ios_themes_30px_4.png"));
    ImageIcon Aluminiumicon = new ImageIcon(getClass().getResource("Images of Notepad Application of software/icons8_ios_themes_30px_6.png"));
    ImageIcon Bernsteinicon = new ImageIcon(getClass().getResource("Images of Notepad Application of software/icons8_new_document_30px.png"));
    ImageIcon Fasticon = new ImageIcon(getClass().getResource("Images of Notepad Application of software/icons8_theme_park_40px.png"));
    ImageIcon Graphiteicon = new ImageIcon(getClass().getResource("Images of Notepad Application of software/icons8_themes_30px_1.png"));
    ImageIcon HiFiicon = new ImageIcon(getClass().getResource("Images of Notepad Application of software/icons8_xlarge_icons_30px_2.png"));
//

    JMenuItem Texture = new JMenuItem("Texture", Textureicon);
    JMenuItem Smart = new JMenuItem("Smart", Smarticon);
    JMenuItem Noire = new JMenuItem("Noire", Noireicon);
    JMenuItem Acry = new JMenuItem("Acry", Acryicon);
    JMenuItem Aero = new JMenuItem("Aero", Aeroicon);
    JMenuItem Aluminium = new JMenuItem("Aluminium", Aluminiumicon);
    JMenuItem Bernstein = new JMenuItem("Bernstein", Bernsteinicon);
    JMenuItem Fast = new JMenuItem("Fast", Fasticon);
    JMenuItem Graphite = new JMenuItem("Graphite", Graphiteicon);
    JMenuItem HiFi = new JMenuItem("HiFi", HiFiicon);
//

    //All edit option in it
    //All edit option in it
     ImageIcon undoicon=new ImageIcon(getClass().getResource("Images of Notepad Application of software/icons8_undo_30px.png"));
    ImageIcon Redoicon = new ImageIcon(getClass().getResource("Images of Notepad Application of software/icons8_redo_30px_1.png"));
    ImageIcon cuticon = new ImageIcon(getClass().getResource("Images of Notepad Application of software/icons8_cut_30px.png"));
    ImageIcon copyicon = new ImageIcon(getClass().getResource("Images of Notepad Application of software/icons8_copy_30px.png"));
    ImageIcon selectallicon = new ImageIcon(getClass().getResource("Images of Notepad Application of software/icons8_query_inner_join_right_30px.png"));
    ImageIcon pasteicon = new ImageIcon(getClass().getResource("Images of Notepad Application of software/icons8_paste_30px.png"));
    ImageIcon Findicon = new ImageIcon(getClass().getResource("Images of Notepad Application of software/icons8_search_30px.png"));
    ImageIcon Repalceicon = new ImageIcon(getClass().getResource("Images of Notepad Application of software/icons8_find_and_replace_30px_1.png"));
    ImageIcon Gotoicon = new ImageIcon(getClass().getResource("Images of Notepad Application of software/icons8_go_40px.png"));
    ImageIcon timeicon = new ImageIcon(getClass().getResource("Images of Notepad Application of software/icons8_time_40px.png"));

    JMenuItem undo = new JMenuItem("undo", undoicon);
    JMenuItem Redo = new JMenuItem("Redo", Redoicon);
    JMenuItem cut = new JMenuItem("Cut", cuticon);
    JMenuItem Copy = new JMenuItem("Copy", copyicon);
    JMenuItem selectall = new JMenuItem("Select All", selectallicon);
    JMenuItem Paste = new JMenuItem("Paste", pasteicon);
    JMenuItem Find = new JMenuItem("Find", Findicon);
    JMenuItem Replace = new JMenuItem("Replace", Repalceicon);
    JMenuItem Goto = new JMenuItem("Go To", Gotoicon);
    JMenuItem time = new JMenuItem("Time/Date", timeicon);

    //All format option in it
    ImageIcon wordwrapicon = new ImageIcon(getClass().getResource("Images of Notepad Application of software/icons8_word_30px.png"));
    ImageIcon Fonticons = new ImageIcon(getClass().getResource("Images of Notepad Application of software/icons8_f_30px_1.png"));
    JCheckBoxMenuItem wordwrap = new JCheckBoxMenuItem("Wordwrap", wordwrapicon);
    JMenuItem Fonts = new JMenuItem("Font", Fonticons);
//
    //Color
    ImageIcon BACKGROUNDCOLORicon = new ImageIcon(getClass().getResource("Images of Notepad Application of software/icons8_color_wheel_30px.png"));
    ImageIcon TEXTCOLORicon = new ImageIcon(getClass().getResource("Images of Notepad Application of software/icons8_color_dropper_30px.png"));
    JMenuItem BACKGROUNDCOLOR = new JMenuItem("BACKGROUND COLOR", BACKGROUNDCOLORicon);
    JMenuItem TEXTCOLOR = new JMenuItem("TEXT COLOR", TEXTCOLORicon);
//
//    All view
    ImageIcon metalsicons = new ImageIcon(getClass().getResource("Images of Notepad Application of software/icons8_metal_40px_1.png"));
    ImageIcon nimbusicons = new ImageIcon(getClass().getResource("Images of Notepad Application of software/icons8_roller_coaster_40px_1.png"));
    ImageIcon CDEmotificons = new ImageIcon(getClass().getResource("Images of Notepad Application of software/icons8_triskelion_40px.png"));
    ImageIcon windowsicons = new ImageIcon(getClass().getResource("Images of Notepad Application of software/icons8_favorite_window_40px_1.png"));
    ImageIcon windowsclassicicons = new ImageIcon(getClass().getResource("Images of Notepad Application of software/icons8_microsoft_word_window_40px.png"));

    JCheckBoxMenuItem statusbar = new JCheckBoxMenuItem("Statusbar");
    JMenu LookandFeel = new JMenu("Look And Feel");
    JMenuItem Metal = new JMenuItem("Metal", metalsicons);
    JMenuItem Nimbus = new JMenuItem("New Window", nimbusicons);
    JMenuItem CDEmotif = new JMenuItem("CDE Motif", CDEmotificons);
    JMenuItem windows = new JMenuItem("Windows", windowsicons);
    JMenuItem windowclassic = new JMenuItem("Window Classic", windowsclassicicons);
//
    //All help
    ImageIcon Abouticon = new ImageIcon(getClass().getResource("Images of Notepad Application of software/icons8_about_30px.png"));
    JMenuItem About = new JMenuItem("About", Abouticon);

    Cursor c1 = new Cursor(Cursor.HAND_CURSOR);
    static JTextArea TEXTAREA = new JTextArea();
    public static NotepadApplication n = new NotepadApplication();
    UndoManager u = new UndoManager();

    NotepadApplication() {
         setTitle("Notepad Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(90, 65, 840, 650);
        setLocationRelativeTo(null);
        ImageIcon i = new ImageIcon(getClass().getResource("Images of Notepad Application of software/icons8_notepad_127px_2.png"));
        i.getIconHeight();
        setIconImage(i.getImage());

        jc = new JFileChooser(".");
        
        addcomponents();
        addactionlisterner();
         scrollbar();
        TextArea();
        windowClosing();
        caretlistener();
        cursor();
        Shortcutkey();
       
    }




public void scrollbar()
{
                  //THIS IS USED TO WRITE TEXT IN NOTE PAD WE USED THIS CLASS
        JScrollPane pane = new JScrollPane(TEXTAREA);

        pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        pane.setBorder(BorderFactory.createEmptyBorder());

        pane.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            @Override
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                if (evt.isControlDown()) {
                    TEXTAREA.setFont(new java.awt.Font(TEXTAREA.getFont().getFontName(), TEXTAREA.getFont().getStyle(),
                            evt.getUnitsToScroll() > 0 ? TEXTAREA.getFont().getSize() - 2
                                    : TEXTAREA.getFont().getSize() + 2));
                }
            }
        });
           add(pane);
}
    public void addcomponents() {
        
        setJMenuBar(menubar);
        //menubar
        menubar.add(File);
        menubar.add(Edit);
        menubar.add(Format);

        menubar.add(Theme);
        menubar.add(coLor);
        menubar.add(view);
        menubar.add(Help);

        //File
        File.add(New);
        File.add(NewWindow);
        File.add(Open);
        File.add(save);
        File.add(SaveAs);
        File.add(Print);
        File.add(Exit);

//        Edit
        Edit.add(undo);
        Edit.add(Redo);
        Edit.add(cut);
        Edit.add(Copy);
        Edit.add(selectall);
        Edit.add(Paste);
        Edit.add(Find);
        Edit.add(Replace);
        Edit.add(Goto);
        Edit.add(time);

        Theme.add(Texture);
        Theme.add(Smart);
        Theme.add(Noire);
        Theme.add(Acry);
        Theme.add(Aero);
        Theme.add(Aluminium);
        Theme.add(Bernstein);
        Theme.add(Fast);
        Theme.add(Graphite);
        Theme.add(HiFi);

        //COLOR
        coLor.add(BACKGROUNDCOLOR);
        coLor.add(TEXTCOLOR);

        //Format
        Format.add(wordwrap);
        Format.add(Fonts);

        //view
        view.add(statusbar);
        view.add(LookandFeel);

        LookandFeel.add(Metal);
        LookandFeel.add(Nimbus);
        LookandFeel.add(CDEmotif);
        LookandFeel.add(windows);
        LookandFeel.add(windowclassic);

        //Format
        Help.add(About);
    }

    public void cursor() {

        //MENUBAR OPTION USING HAND CRUSOR
        menubar.setCursor(c1);

        //FILE OPTION USING HAND CRUSOR
        File.setCursor(c1);
        New.setCursor(c1);
        NewWindow.setCursor(c1);
        Open.setCursor(c1);
        save.setCursor(c1);
        Print.setCursor(c1);
        Exit.setCursor(c1);

        //EDIT OPTION USING HAND CRUSOR
        Edit.setCursor(c1);
        undo.setCursor(c1);
        Redo.setCursor(c1);
        cut.setCursor(c1);
        Copy.setCursor(c1);
        selectall.setCursor(c1);
        Paste.setCursor(c1);
        Find.setCursor(c1);
        Replace.setCursor(c1);
        Goto.setCursor(c1);

        //FORMAT OPTION USING HAND CRUSOR
        Format.setCursor(c1);
        wordwrap.setCursor(c1);
        Fonts.setCursor(c1);

        //COLOR OPTION USING HAND CRUSOR
        coLor.setCursor(c1);
        TEXTCOLOR.setCursor(c1);
        BACKGROUNDCOLOR.setCursor(c1);

        //Theme Option Using Hand Cursor
        Texture.setCursor(c1);
        Smart.setCursor(c1);
        Noire.setCursor(c1);
        Aero.setCursor(c1);
        Aluminium.setCursor(c1);
        Bernstein.setCursor(c1);
        Fast.setCursor(c1);
        Graphite.setCursor(c1);
        HiFi.setCursor(c1);

        //view
        view.setCursor(c1);
        view.setCursor(c1);
        statusbar.setCursor(c1);
        LookandFeel.setCursor(c1);
        Metal.setCursor(c1);
        Nimbus.setCursor(c1);
        CDEmotif.setCursor(c1);
        windows.setCursor(c1);
        windowclassic.setCursor(c1);

        //HELP OPTION USING HAND CRUSOR
        Help.setCursor(c1);
        About.setCursor(c1);
    }

    public void Shortcutkey() {
        //shortcut keys
        //    File Option Shortcutkeys
        New.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        NewWindow.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, ActionEvent.CTRL_MASK + SHIFT_MASK));
        Open.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        save.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        SaveAs.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, ActionEvent.CTRL_MASK + SHIFT_MASK));
        Print.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        Exit.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, ActionEvent.CTRL_MASK));

        //edit Option Shortcutkeys
        undo.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        Redo.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
        cut.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        Copy.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        selectall.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        Paste.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        Find.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, ActionEvent.CTRL_MASK));
        Replace.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        Goto.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, ActionEvent.CTRL_MASK));
        time.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, ActionEvent.CTRL_MASK));
        //Format Option Shortcutkeys
        wordwrap.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        Fonts.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, ActionEvent.CTRL_MASK));

        //Color Option ShortcutKeys
        TEXTCOLOR.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, ActionEvent.CTRL_MASK));
        BACKGROUNDCOLOR.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, ActionEvent.CTRL_MASK));

        //Themes shorcut Keys
        Texture.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, ActionEvent.CTRL_MASK));
        Smart.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, ActionEvent.CTRL_MASK));
        Noire.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, ActionEvent.CTRL_MASK));
        Acry.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, ActionEvent.CTRL_MASK));
        Aero.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, ActionEvent.CTRL_MASK));
        Aluminium.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, ActionEvent.CTRL_MASK));
        Bernstein.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, ActionEvent.CTRL_MASK));
        Fast.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, ActionEvent.CTRL_MASK));
        Graphite.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F10, ActionEvent.CTRL_MASK));
        HiFi.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F11, ActionEvent.CTRL_MASK));

        About.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, ActionEvent.CTRL_MASK));
    }



    public void TextArea() {
        
        //TEXTAREA
        TEXTAREA.setFont(new Font("Time New Roman", Font.PLAIN, 18));
        TEXTAREA.setText("\t\t\tHELLO!\n\t\tJAVA DEVELOPER ABDUL SAMI BUTT");
        TEXTAREA.setLineWrap(true);
        TEXTAREA.setWrapStyleWord(true);
        TEXTAREA.getDocument().addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                u.addEdit(e.getEdit());

            }
        });
    }

    public void caretlistener() {

        //Caret Listener
        statusBar = new JLabel("||Ln 1, Col 1", JLabel.CENTER);
        add(new JScrollPane(TEXTAREA), BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);
        add(new JLabel("    "), BorderLayout.EAST);
        add(new JLabel("    "), BorderLayout.WEST);


        TEXTAREA.addCaretListener(
                new CaretListener() {
            public void caretUpdate(CaretEvent e) {
                int lineNumber = 0, column = 0, pos = 0;

                try {
                    pos = TEXTAREA.getCaretPosition();
                    lineNumber = TEXTAREA.getLineOfOffset(pos);
                    column = pos - TEXTAREA.getLineStartOffset(lineNumber);
                } catch (Exception excp) {
                }
                if (TEXTAREA.getText().length() == 0) {
                    lineNumber = 0;
                    column = 0;
                }
                statusBar.setText("||       Ln " + (lineNumber + 1) + ", Col " + (column + 1));
            }
        });
    }

    public void windowClosing() {
        //window closing 
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                int n;
// Display dialogbox
                n = JOptionPane.showOptionDialog(null, "Do you want to save your changes?", "Notepad Application",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                if (n == JOptionPane.NO_OPTION) {
                    System.exit(0);
                } else if (n == JOptionPane.CLOSED_OPTION) {
                    setVisible(true);
                } else if (n == JOptionPane.YES_OPTION) {

                    save();
                    System.exit(0);
                }
            }
        });
    }

    public void addactionlisterner() {
        //adding action listener IN FILE OPTION
        New.addActionListener(this);
        NewWindow.addActionListener(this);
        Open.addActionListener(this);
        save.addActionListener(this);
        SaveAs.addActionListener(this);
        Print.addActionListener(this);
        Exit.addActionListener(this);

//        //adding action listener IN EDIT OPTION
        undo.addActionListener(this);
        Redo.addActionListener(this);
        cut.addActionListener(this);
        Copy.addActionListener(this);
        selectall.addActionListener(this);
        Paste.addActionListener(this);
        Find.addActionListener(this);
        Replace.addActionListener(this);
        Goto.addActionListener(this);
        time.addActionListener(this);
        
        //adding action listener IN FORMAT OPTION
        wordwrap.addActionListener(this);
        Fonts.addActionListener(this);

        Texture.addActionListener(this);
        Smart.addActionListener(this);
        Noire.addActionListener(this);
        Acry.addActionListener(this);
        Aero.addActionListener(this);
        Aluminium.addActionListener(this);
        Bernstein.addActionListener(this);
//        Fast.addActionListener(this);
        Graphite.addActionListener(this);
        HiFi.addActionListener(this);

        //adding action listener IN COLOR OPTION
        TEXTCOLOR.addActionListener(this);
        BACKGROUNDCOLOR.addActionListener(this);

        //adding action listener to look and feel
        statusbar.addActionListener(this);
        Metal.addActionListener(this);
        Nimbus.addActionListener(this);
        CDEmotif.addActionListener(this);
        windows.addActionListener(this);
        windowclassic.addActionListener(this);

        //adding action listener IN HELP OPTION
        About.addActionListener(this);

    }

    private void save() {
        PrintWriter font = null;

        try {
            if (filename == null) {
                saveAs();
            } else {
                font = new PrintWriter(new FileWriter(filename));
                String s = TEXTAREA.getText();
                StringTokenizer st = new StringTokenizer(s, System.getProperty("line.separator"));
                while (st.hasMoreElements()) {
                    font.println(st.nextToken());
                }

            }

        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            if (font != null) {
                font.close();
            }
        }

    }

    private void saveAs() {
        PrintWriter font = null;
        int retval = -1;
        try {
            retval = jc.showSaveDialog(this);
            if (retval == JFileChooser.APPROVE_OPTION) {
                if (jc.getSelectedFile().exists()) {
                    int option = JOptionPane.showConfirmDialog(rootPane, "Do you want to replace this file?", "Confirmation", JOptionPane.OK_CANCEL_OPTION);

                    if (option == 0) {
                        font = new PrintWriter(new FileWriter(jc.getSelectedFile()));
                        String s = TEXTAREA.getText();
                        StringTokenizer st = new StringTokenizer(s, System.getProperty("line.separator"));
                        while (st.hasMoreElements()) {
                            font.println(st.nextToken());
                        }
                        JOptionPane.showMessageDialog(rootPane, "File saved");
                        fileContent = TEXTAREA.getText();
                        filename = jc.getSelectedFile().getName();
                        setTitle(filename = jc.getSelectedFile().getName());
                    } else {
                        saveAs();
                    }
                } else {
                    font = new PrintWriter(new FileWriter(jc.getSelectedFile()));
                    String s = TEXTAREA.getText();
                    StringTokenizer st = new StringTokenizer(s, System.getProperty("line.separator"));
                    while (st.hasMoreElements()) {
                        font.println(st.nextToken());
                    }
                    JOptionPane.showMessageDialog(rootPane, "File saved");
                    fileContent = TEXTAREA.getText();
                    filename = jc.getSelectedFile().getName();
                    setTitle(filename = jc.getSelectedFile().getName());
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (font != null) {
                font.close();
            }
        }
    }

  
            private void open() {
        try {
            int retval = jc.showOpenDialog(this);
            if (retval == JFileChooser.APPROVE_OPTION) {
                TEXTAREA.setText(null);
                Reader in = new FileReader(jc.getSelectedFile());
                char[] buff = new char[100000];
                int nch;
                while ((nch = in.read(buff, 0, buff.length)) != -1) {
                    TEXTAREA.append(new String(buff, 0, nch));
                }
                filename = jc.getSelectedFile().getName();
            setTitle(filename = jc.getSelectedFile().getName());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    
            }
    
    private void clear() {
        TEXTAREA.setText(null);
        filename = null;
        fileContent = null;
        filename = null;
        fileContent = null;

    }

    private void goTo() {
        int lineNumber = 0;
        try {
            lineNumber = TEXTAREA.getLineOfOffset(TEXTAREA.getCaretPosition()) + 1;
            String tempStr = JOptionPane.showInputDialog(this, "Enter Line Number:", "" + lineNumber);
            if (tempStr == null) {
                return;
            }
            lineNumber = Integer.parseInt(tempStr);
            TEXTAREA.setCaretPosition(TEXTAREA.getLineStartOffset(lineNumber - 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {

     if (e.getActionCommand().equalsIgnoreCase("New")) {

            TEXTAREA.setText(null);
        } 
        
       
   else if (e.getActionCommand().equalsIgnoreCase("New Window")) {

            new NotepadApplication().setVisible(true);
        } 
       
          
    else if (e.getActionCommand().equalsIgnoreCase("Open")) {
          open();
        } 
    
   
    else if (e.getActionCommand().equalsIgnoreCase("Save")) {

            save();
           
        } 
    
  
  else if (e.getActionCommand().equalsIgnoreCase("SaveAs")) {

            saveAs();
        } 
  
  
  else if (e.getActionCommand().equalsIgnoreCase("Print")) {
            try {
                TEXTAREA.print();
            } catch (PrinterException ex) {
                Logger.getLogger(NotepadApplication.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
  
  
  else if (e.getActionCommand().equalsIgnoreCase("Exit")) {
            System.exit(0);

        } 
  
  
  else if (e.getActionCommand().equalsIgnoreCase("undo")) {
            u.undo();
        } 
  
  
  else if (e.getActionCommand().equalsIgnoreCase("Redo")) {
            u.redo();
        } 
  
    
    else if (e.getActionCommand().equalsIgnoreCase("Find")) {
        
                    new FindAndReplace(n, false);
                } 
               
       
     else if (e.getActionCommand().equalsIgnoreCase("Replace")) {
        
                    new FindAndReplace(n, true);
                } 
     
 else if (e.getActionCommand().equalsIgnoreCase("Go To")) {

            goTo();
        } 
 
 
 else if (e.getActionCommand().equalsIgnoreCase("Time/Date")) {

            TEXTAREA.insert(new Date().toString(), TEXTAREA.getSelectionStart());
        } 
 
 
 else if (e.getActionCommand().equalsIgnoreCase("cut")) {
            TEXTAREA.cut();
        } 
 
 
 else if (e.getActionCommand().equalsIgnoreCase("Copy")) {
            TEXTAREA.copy();
        } 
 



 else if (e.getActionCommand().equalsIgnoreCase("Paste")) {
            TEXTAREA.paste();
        } 
 
 
 else if (e.getActionCommand().equalsIgnoreCase("wordwrap")) {
                 if (wordwrap.isSelected()) {
                    TEXTAREA.setLineWrap(true);
                     TEXTAREA.setWrapStyleWord(true);
                } else {
                     TEXTAREA.setLineWrap(false);
                     TEXTAREA.setWrapStyleWord(false);
                }
            }

         
 
  
 else if (e.getActionCommand().equalsIgnoreCase("Fonts")) {
            JFontChooser f = new JFontChooser();
            JOptionPane.showMessageDialog(null, f, "Please Choose Font", JOptionPane.PLAIN_MESSAGE);
            TEXTAREA.setFont(f.getSelectedFont());
        }
 
 
 else if (e.getActionCommand().equalsIgnoreCase("BACKGROUND COLOR")) {

            JColorChooser colorchooser = new JColorChooser();
            Color color = JColorChooser.showDialog(null, "PICK I COLOR I GUESS", Color.WHITE);
            TEXTAREA.setBackground(color);
            JOptionPane.showMessageDialog(null, "Well Done! Your Background Color is changed", "Notepad Application", JOptionPane.INFORMATION_MESSAGE);

        } 
 
 
 else if (e.getActionCommand().equalsIgnoreCase("TEXT COLOR")) {

            JColorChooser colorchooser = new JColorChooser();
            Color color = JColorChooser.showDialog(null, "PICK I COLOR I GUESS", Color.WHITE);
            TEXTAREA.setForeground(color);
            JOptionPane.showMessageDialog(null, "Well Done! Your Text Color is changed", "Notepad Application", JOptionPane.INFORMATION_MESSAGE);

        } 
 
   
 else if (e.getActionCommand().equalsIgnoreCase("Statusbar")) {

            statusBar.setVisible(statusbar.isSelected());
        } 
 
 else if (e.getActionCommand().equalsIgnoreCase("Texture")) {

            try {
                String str = "com.jtattoo.plaf.texture.TextureLookAndFeel";
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                UIManager.setLookAndFeel(str);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            new NotepadApplication().setVisible(true);
            JOptionPane.showMessageDialog(null, "Well Done! Your Theme is changed", "Notepad Application", JOptionPane.INFORMATION_MESSAGE);
        } 
 
 
 else if (e.getActionCommand().equalsIgnoreCase("Smart")) {

            try {
                String str = "com.jtattoo.plaf.smart.SmartLookAndFeel";
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                UIManager.setLookAndFeel(str);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            new NotepadApplication().setVisible(true);
            JOptionPane.showMessageDialog(null, "Well Done! Your Theme is changed", "Notepad Application", JOptionPane.INFORMATION_MESSAGE);
        } 
 
 
 else if (e.getActionCommand().equalsIgnoreCase("Noire")) {

            try {
                String str = "com.jtattoo.plaf.noire.NoireLookAndFeel";
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                UIManager.setLookAndFeel(str);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            new NotepadApplication().setVisible(true);
            JOptionPane.showMessageDialog(null, "Well Done! Your Theme is changed", "Notepad Application", JOptionPane.INFORMATION_MESSAGE);
        } 
 
 
 else if (e.getActionCommand().equalsIgnoreCase("Aero")) {

            try {
                String str = "com.jtattoo.plaf.aero.AeroLookAndFeel";
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                UIManager.setLookAndFeel(str);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            new NotepadApplication().setVisible(true);
            JOptionPane.showMessageDialog(null, "Well Done! Your Theme is changed", "Notepad Application", JOptionPane.INFORMATION_MESSAGE);

        } 
 
 
 else if (e.getActionCommand().equalsIgnoreCase("Aluminium")) {

            try {
                String str = "com.jtattoo.plaf.aluminium.AluminiumLookAndFeel";
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                UIManager.setLookAndFeel(str);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            new NotepadApplication().setVisible(true);
            JOptionPane.showMessageDialog(null, "Well Done! Your Theme is changed", "Notepad Application", JOptionPane.INFORMATION_MESSAGE);
        } 
 
 
 else if (e.getActionCommand().equalsIgnoreCase("Bernstein")) {

            try {
                String str = "com.jtattoo.plaf.bernstein.BernsteinLookAndFeel";
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                UIManager.setLookAndFeel(str);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            new NotepadApplication().setVisible(true);
            JOptionPane.showMessageDialog(null, "Well Done! Your Theme is changed", "Notepad Application", JOptionPane.INFORMATION_MESSAGE);
        }


 else if (e.getActionCommand().equalsIgnoreCase("Fast")) {

            try {
                String str = "com.jtattoo.plaf.fast.FastLookAndFeel";
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                UIManager.setLookAndFeel(str);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            new NotepadApplication().setVisible(true);
            JOptionPane.showMessageDialog(null, "Well Done! Your Theme is changed", "Notepad Application", JOptionPane.INFORMATION_MESSAGE);
        } 
 
 else if (e.getActionCommand().equalsIgnoreCase("Graphite")) {

            try {
                String str = "com.jtattoo.plaf.graphite.GraphiteLookAndFeel";
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                UIManager.setLookAndFeel(str);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            new NotepadApplication().setVisible(true);
            JOptionPane.showMessageDialog(null, "Well Done! Your Theme is changed", "Notepad Application", JOptionPane.INFORMATION_MESSAGE);
        } 
 
 else if (e.getActionCommand().equalsIgnoreCase("HiFi")) {

            try {
                String str = "com.jtattoo.plaf.hifi.HiFiLookAndFeel";
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                UIManager.setLookAndFeel(str);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            new NotepadApplication().setVisible(true);
            JOptionPane.showMessageDialog(null, "Well Done! Your Theme is changed", "Notepad Application", JOptionPane.INFORMATION_MESSAGE);
        } 
 
 
 else if (e.getActionCommand().equalsIgnoreCase("Metal")) {

            try {
                String str = "javax.swing.plaf.metal.MetalLookAndFeel";
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                UIManager.setLookAndFeel(str);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            new NotepadApplication().setVisible(true);
            JOptionPane.showMessageDialog(null, "Well Done! Your Theme is changed", "Notepad Application", JOptionPane.INFORMATION_MESSAGE);
        } 
 
 
 else if (e.getActionCommand().equalsIgnoreCase("Nimbus")) {

            try {
                String str = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                UIManager.setLookAndFeel(str);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            new NotepadApplication().setVisible(true);
            JOptionPane.showMessageDialog(null, "Well Done! Your Theme is changed", "Notepad Application", JOptionPane.INFORMATION_MESSAGE);
        } 
 
 
 else if (e.getActionCommand().equalsIgnoreCase("CDEmotif")) {

            try {
                String str = "com.sun.java.swing.plaf.motif.MofitLookAndFeel";
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                UIManager.setLookAndFeel(str);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            new NotepadApplication().setVisible(true);
            JOptionPane.showMessageDialog(null, "Well Done! Your Theme is changed", "Notepad Application", JOptionPane.INFORMATION_MESSAGE);
        } 
 
 
 else if (e.getActionCommand().equalsIgnoreCase("windows")) {

            try {
                String str = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                UIManager.setLookAndFeel(str);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            new NotepadApplication().setVisible(true);
            JOptionPane.showMessageDialog(null, "Well Done! Your Theme is changed", "Notepad Application", JOptionPane.INFORMATION_MESSAGE);
        }

 else if (e.getActionCommand().equalsIgnoreCase("windowclassic")) {

            try {
                String str = "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel";
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                UIManager.setLookAndFeel(str);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            new NotepadApplication().setVisible(true);
            JOptionPane.showMessageDialog(null, "Well Done! Your Theme is changed", "Notepad Application", JOptionPane.INFORMATION_MESSAGE);
        }

 else if (e.getActionCommand().equalsIgnoreCase("About")) {

            new About().setVisible(true);
        }

    }

    public static void main(String args[]) throws Exception {
      try {
             FlatMaterialDarkerContrastIJTheme.setup();
           }  
           catch (Exception e) {
               e.printStackTrace();
            }
        new NotepadApplication().setVisible(true);
    }

    public static JTextArea getArea() {
        return TEXTAREA;
    }

}
