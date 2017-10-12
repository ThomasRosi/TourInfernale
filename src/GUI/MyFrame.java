package GUI;

import Game.Character;
import Game.Stage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

/**
 * Created by Thomas on 15-02-17.
 */
public class MyFrame extends JFrame implements KeyListener {

    private Character c = new Character();
    private Stage stage;

    private MenuPanel menuPanel = new MenuPanel();
    private HelpPanel helpPanel = new HelpPanel();
    private LevelPanel levelPanel = new LevelPanel(c);
    private OptionPanel optionPanel = new OptionPanel();
    private PlayPanel playPanel;

    private MenuBouton bPlay, bOptions, bHelp, bExit, bBack, bCredit;
    JMenu m1;
    private JMenuItem opt1, opt2, opt3, opt4, opt5;

    protected static boolean isEn = true;
    protected static String[] en = {"Play","Help","Exit","Options","Choose your level","Back","Help",
                                "Become the future legendary hero by climbing The Infernal Tower.",
                                "Move your character with the keyboard (directional arrows) and dodge traps.",
                                "Find the key hidden somewhere in every stage (and maybe some tools...)",
                                "Find the gate to go to the next stage and then... Find the FINAL STAGE !",
                                "Go as fast as you can to score but be careful with your life !",
                                "Good luck in The Infernal Tower and see you on the top !",
                                "Language :","Credits","Back to Levels","Back to Menu","Back to Options","Exit Game",
                                "You access to the next stage! Congratulations!","You're dead !",
                                "Finish the previous stage to access to this one !",
                                "The game has been reset.","Project name : \"The Infernal Tower\"\n",
                                "Courses : \"Gestion de projets\"\n","School : HEH Technical Campus\n",
                                "Study :  Bachelor degree in Computer Science and Systems opt. Development\n",
                                "Academic year : 2016-2017\n","Cycle : \"Bloc 2\"\n","Authors : Rosi T. & Urbain A.\n"};

    protected static String[] fr = { "Jouer","Aide","Quitter","Options","Choisis ton niveau","Retour","Aide",
                                "Devenez le futur héros légendaire à gravir \"La Tour Infernale\".",
                                "Déplacez votre personnage avec les touches directionnelles du clavier.",
                                "Trouvez la clé cachée dans chaque niveau ainsi que les étoiles bonus !",
                                "Trouvez la sortie pour accéder au niveau suivant et peut-être arriver au sommet de la tour !",
                                "De nombreux pièges ralentiront votre progression, faites attention à vos points de vie !",
                                "Bonne chance dans \"La Tour Infernale\", on se revoie au sommet !",
                                "Langue :","Crédits","Retour aux niveaux","Retour au Menu","Retour aux Options","Quitter le jeu",
                                "Félicitations, vous accédez au niveau suivant !","Vous êtes mort !",
                                "Finissez le niveau précédent pour accéder à celui-ci !",
                                "Le jeu a été réinitialisé.","Nom du projet : \"The Infernal Tower\"\n",
                                "Cours : Gestion de projets\n","Ecole : HEH Campus Technique\n",
                                "Etudes : Bachelier en Informatique et Systèmes opt. développement\n",
                                "Année Académique : 2016-2017\n","Cycle : Bloc 2\n","Auteurs : Rosi T. & Urbain A.\n"};


    public MyFrame() {
        super();
        loadCharacter();
        initComponent();
        initMenuPanel();
        initLevelPanel();
        initHelpPanel();
        initOptionPanel();
        initJMenuBar();
        setFocusable(true);
        this.addKeyListener(this);
        this.setVisible(true);
    }

    private void initComponent() {
        this.setResizable(false);
        this.setSize(1020, 760);
        this.setTitle("Infernal Tower");
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);

        this.setContentPane(menuPanel);
    }

    private void initMenuPanel() {
        int w = this.getSize().width/11;
        int h = this.getSize().height/10;

        if (isEn) {
             bPlay = new MenuBouton(en[0], 4 * w, 4 * h, 3 * w, h);
             bOptions = new MenuBouton(en[3], w, 6 * h, 3 * w, h);
             bHelp = new MenuBouton(en[1], 7 * w, 6 * h, 3 * w, h);
             bExit = new MenuBouton(en[2], 4 * w, 8 * h, 3 * w, h);
        } else {
            bPlay = new MenuBouton(fr[0], 4 * w, 4 * h, 3 * w, h);
            bOptions = new MenuBouton(fr[3], w, 6 * h, 3 * w, h);
            bHelp = new MenuBouton(fr[1], 7 * w, 6 * h, 3 * w, h);
            bExit = new MenuBouton(fr[2], 4 * w, 8 * h, 3 * w, h);
        }

        bPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changePan(levelPanel);
            }
        });

        bHelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changePan(helpPanel);
            }
        });

        bExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveCharacter();
                System.exit(0);
            }
        });

        bOptions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changePan(optionPanel);
            }
        });

        menuPanel.add(bPlay);
        menuPanel.add(bOptions);
        menuPanel.add(bHelp);
        menuPanel.add(bExit);

    }

    private void initLevelPanel() {
        int w = this.getSize().width / 11;
        int h = this.getSize().height / 10;
        int x = 77;

        if (isEn){
            bBack = new MenuBouton(en[5], 4*w, 8*h ,3*w, h);
        } else {
            bBack = new MenuBouton(fr[5], 4*w, 8*h ,3*w, h);
        }

        MenuBouton[] button = new MenuBouton[10];

        for (int i = 0; i < button.length; i++) {
            levelPanel.add(button[i] = new MenuBouton("" + (i + 1) + "", 100 + i * (x + 5), 300, x, x));
        }

        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changePan(menuPanel);
            }
        });

        button[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stage = new Stage(1, c);
                playPanel = new PlayPanel(stage, c);
                changePan(playPanel);
            }
        });

        button[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(c.getLevel() >= 1) {
                    stage = new Stage(2, c);
                    playPanel = new PlayPanel(stage, c);
                    changePan(playPanel);
                } else {
                    cantAccess();

                }
            }
        });

        button[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(c.getLevel() >= 2) {
                    stage = new Stage(3, c);
                    playPanel = new PlayPanel(stage, c);
                    changePan(playPanel);
                } else {
                    cantAccess();
                }
            }
        });


        button[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(c.getLevel() >= 3) {
                    stage = new Stage(4, c);
                    playPanel = new PlayPanel(stage, c);
                    changePan(playPanel);
                } else {
                    cantAccess();
                }
            }
        });


        button[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(c.getLevel() >= 4){
                    stage = new Stage(5, c);
                    playPanel = new PlayPanel(stage, c);
                    changePan(playPanel);
                } else {
                    cantAccess();
                }
            }
        });


        button[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(c.getLevel() >= 5) {
                    stage = new Stage(6, c);
                    playPanel = new PlayPanel(stage, c);
                    changePan(playPanel);
                } else {
                    cantAccess();
                }
            }
        });

        button[6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(c.getLevel() >= 6) {
                    stage = new Stage(7, c);
                    playPanel = new PlayPanel(stage, c);
                    changePan(playPanel);
                } else {
                    cantAccess();
                }
            }
        });

        button[7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(c.getLevel() >= 7) {
                    stage = new Stage(8, c);
                    playPanel = new PlayPanel(stage, c);
                    changePan(playPanel);
                } else {
                    cantAccess();
                }
            }
        });

        button[8].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(c.getLevel() >= 8) {
                    stage = new Stage(9, c);
                    playPanel = new PlayPanel(stage, c);
                    changePan(playPanel);
                } else {
                    cantAccess();
                }
            }
        });

        button[9].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(c.getLevel() >= 9) {
                    stage = new Stage(10, c);
                    playPanel = new PlayPanel(stage, c);
                    changePan(playPanel);
                } else {
                    cantAccess();
                }
            }
        });

        levelPanel.add(bBack);
    }

    private void cantAccess(){
        if(isEn){
            JOptionPane.showMessageDialog(null, en[21]);
        } else {
            JOptionPane.showMessageDialog(null, fr[21]);
        }
    }

    private void initHelpPanel(){
        int w = this.getSize().width/11;
        int h = this.getSize().height/10;

        if (isEn){
            bBack = new MenuBouton(en[5], 4*w, 8*h ,3*w, h);
        } else {
            bBack = new MenuBouton(fr[5], 4*w, 8*h ,3*w, h);
        }

        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changePan(menuPanel);
            }
        });

        helpPanel.add(bBack);
    }

    private void initJMenuBar(){

        JMenuBar mb = new JMenuBar();

        Color c1 = new Color(196, 88, 45);
        Color c2 = new Color(232, 169, 54);

        mb.setBackground(c1);
        mb.setBorderPainted(false);

        JMenu m2 = new JMenu("?");

        if(MyFrame.isEn){
            m1 = new JMenu(en[3]);
            opt1 = new JMenuItem(en[15]);
            opt2 = new JMenuItem(en[16]);
            opt3 = new JMenuItem(en[17]);
            opt4 = new JMenuItem(en[18]);
            opt5 = new JMenuItem(en[6]);
        } else {
            m1 = new JMenu(fr[3]);
            opt1 = new JMenuItem(fr[15]);
            opt2 = new JMenuItem(fr[16]);
            opt3 = new JMenuItem(fr[17]);
            opt4 = new JMenuItem(fr[18]);
            opt5 = new JMenuItem(fr[6]);
        }

        opt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changePan(levelPanel);
            }
        });

        opt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changePan(menuPanel);
            }
        });

        opt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changePan(optionPanel);
            }
        });
        opt4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        opt5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isEn){
                    JOptionPane.showMessageDialog(null, en[8]+"\n"+en[9]+"\n"+en[10]+"\n"+en[11], en[6], JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, fr[8]+"\n"+fr[9]+"\n"+fr[10]+"\n"+fr[11], fr[6], JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        opt1.setBackground(c2);
        opt2.setBackground(c2);
        opt3.setBackground(c2);
        opt4.setBackground(c2);
        opt5.setBackground(c2);
        opt1.setBorderPainted(false);
        opt2.setBorderPainted(false);
        opt3.setBorderPainted(false);
        opt4.setBorderPainted(false);
        opt5.setBorderPainted(false);
        opt1.setBorder(null);

        m1.add(opt1);
        m1.add(opt2);
        m1.add(opt3);
        m1.addSeparator();
        m1.add(opt4);
        m2.add(opt5);
        mb.add(m1);
        mb.add(m2);
        this.setJMenuBar(mb);
    }

    private void initOptionPanel(){

        int w = this.getSize().width/11;
        int h = this.getSize().height/10;
        if (isEn){
            bBack = new MenuBouton(en[5], 4*w, 8*h ,3*w, h);
            bCredit = new MenuBouton(en[14], 6*w, 6*h ,3*w, h);
        } else {
            bBack = new MenuBouton(fr[5], 4*w, 8*h ,3*w, h);
            bCredit = new MenuBouton(fr[14], 6*w,6*h ,3*w, h);

        }
        MenuBouton bFr = new MenuBouton("Fr", 11*w/2, 17*h/4, 3*w/2,h);
        MenuBouton bEn = new MenuBouton("En", 15*w/2,17*h/4,3*w/2,h);
        MenuBouton bReset = new MenuBouton("Reset", 2*w, 6*h, 3*w, h);

        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changePan(menuPanel);
            }
        });

        bFr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isEn){
                    isEn = false;
                    menuPanel = new MenuPanel();
                    helpPanel = new HelpPanel();
                    optionPanel = new OptionPanel();
                    levelPanel = new LevelPanel(c);
                    initMenuPanel();
                    initLevelPanel();
                    initHelpPanel();
                    initOptionPanel();
                    initJMenuBar();
                    changePan(optionPanel);
                }
            }
        });
        bEn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isEn) {
                    isEn = true;
                    menuPanel = new MenuPanel();
                    helpPanel = new HelpPanel();
                    optionPanel = new OptionPanel();
                    levelPanel = new LevelPanel(c);
                    initMenuPanel();
                    initLevelPanel();
                    initHelpPanel();
                    initOptionPanel();
                    initJMenuBar();
                    changePan(optionPanel);
                }
            }
        });

        bReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.setLevel(0);
                for(int i = 0; i < 10; i++){
                    c.setStarIndex(i, 0);
                }
                if(isEn){
                    JOptionPane.showMessageDialog(null, en[22],"Reset",1);
                } else {
                    JOptionPane.showMessageDialog(null, fr[22],"Reset",1);
                }
            }
        });

        bCredit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isEn){
                    JOptionPane.showMessageDialog(null, en[23]+en[24]+en[25]+en[26]+en[27]+en[28]+en[29],en[14],1);

                } else {
                    JOptionPane.showMessageDialog(null, fr[23]+fr[24]+fr[25]+fr[26]+fr[27]+fr[28]+fr[29],fr[14],1);
                }
            }
        });

        optionPanel.add(bFr);
        optionPanel.add(bEn);
        optionPanel.add(bReset);
        optionPanel.add(bCredit);
        optionPanel.add(bBack);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(MyFrame.this.getContentPane() == playPanel) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                MyFrame.this.stage.moveUp();
                playPanel.repaint();
                MyFrame.this.revalidate();
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                MyFrame.this.stage.moveDown();
                playPanel.repaint();
                MyFrame.this.revalidate();
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                MyFrame.this.stage.moveLeft();
                playPanel.repaint();
                MyFrame.this.revalidate();
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                MyFrame.this.stage.moveRight();
                playPanel.repaint();
                MyFrame.this.revalidate();
            }
            if(MyFrame.this.stage.isWon()){
                if(isEn){
                    JOptionPane.showMessageDialog(null, en[19]);
                } else {
                    JOptionPane.showMessageDialog(null, fr[19]);
                }

                if(c.getLevel() < stage.getNum()) {
                    c.setLevel(stage.getNum());
                }
                if(c.getStarIndex(stage.getNum()-1) < stage.getStar()) {
                    c.setStarIndex(stage.getNum() - 1, stage.getStar());
                }
                MyFrame.this.stage.reset();
                changePan(levelPanel);
            }
            if(MyFrame.this.c.getLife() == 0) {
                if(isEn){
                    JOptionPane.showMessageDialog(null, en[20]);
                } else {
                    JOptionPane.showMessageDialog(null, fr[20]);
                }

                MyFrame.this.stage.reset();
                playPanel.repaint();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private void changePan(JPanel pan){
        this.setContentPane(pan);
        this.revalidate();
    }

    private void saveCharacter(){
        String fichier = "resources/save/file.txt";
        try{
            FileWriter fw = new FileWriter(fichier);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(isEn);
            pw.println(c.getLevel());
            for (int i = 0; i< 10 ; i++){
                pw.println(c.getStarIndex(i));
            }
            pw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    private void loadCharacter(){
        String fichier = "resources/save/file.txt";
        String[] verify = new String[12];
        int i = 0;
        try {
            InputStream ips = new FileInputStream(fichier);
            InputStreamReader ipsr = new InputStreamReader(ips);
            BufferedReader br=new BufferedReader(ipsr);
            String ligne;
            while ((ligne=br.readLine())!=null){
                verify[i] = ligne;
                i++;
            }
            isEn = Boolean.parseBoolean(verify[0]);
            c.setLevel(Integer.parseInt(verify[1]));
            for (int j = 2 ; j < 12 ; j ++) {
                c.setStarIndex(j-2, Integer.parseInt(verify[j]));
            }
            br.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
