package adventure;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game {
    
    private JFrame window; 
    private JPanel titlePanel, buttonPanel, mainTextPanel, choiceButtonPanel, playerpanel;
    private JLabel titleLabel,hpLabel,hpLabelNumber, weaponLabel, weaponLabelName ;
    private JButton startButton, choice1, choice2, choice3, choice4;
    private JTextArea mainTextArea;
    int playerHP,monsterHP, silverRing;
    String Weapon, position;
    
    ChoiceHandler choiceHandler = new ChoiceHandler();
    
    
    private static final String GAME_TITLE = "Jason's Adventure";
    private static final Font TITLE_FONT = new Font("Times New Roman", Font.PLAIN, 80);
    private static final Font TEXT_FONT = new Font("Times New Roman", Font.PLAIN, 30);
    private static final Color BACKGROUND_COLOR = Color.BLACK;
    private static final Color TEXT_COLOR = Color.WHITE;
    private static final Color BUTTON_COLOR = new Color(50, 50, 50);
    private static final Color BUTTON_TEXT_COLOR = Color.WHITE;

    public static void main(String[] args) {
        new Game();
    }
    
    public Game(){
        initializeWindow();
        initializeComponents();
        addComponentsToContainer();
        window.setVisible(true);
    }
    
    private void initializeWindow() {
        window = new JFrame(GAME_TITLE);
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(BACKGROUND_COLOR);
        window.setLayout(new BorderLayout());
    }
    
    private void initializeComponents() {
        titlePanel = new JPanel();
        titleLabel = new JLabel(GAME_TITLE);
        titleLabel.setForeground(TEXT_COLOR);
        titleLabel.setFont(TITLE_FONT);
        titlePanel.add(titleLabel);
        titlePanel.setBackground(BACKGROUND_COLOR);
        titlePanel.setPreferredSize(new Dimension(window.getWidth(), window.getHeight() / 2));
        
        buttonPanel = new JPanel();
        startButton = new JButton("START");
        startButton.addActionListener(new TitleScreenHandler());
        customizeButton(startButton);
        buttonPanel.add(startButton);
        buttonPanel.setBackground(BACKGROUND_COLOR);
    }
    
    private void addComponentsToContainer() {
        window.add(titlePanel, BorderLayout.NORTH);
        window.add(buttonPanel, BorderLayout.CENTER);
    }
    
    private void createGameScreen() {
    	window.remove(titlePanel);
    	window.remove(buttonPanel);

    	playerpanel = new JPanel();
    	playerpanel.setBackground(Color.black);
    	playerpanel.setPreferredSize(new Dimension(window.getWidth(), 50)); // Defina um tamanho preferencial para o playerpanel
    	playerpanel.setLayout(new GridLayout(1,4));
    	window.add(playerpanel, BorderLayout.NORTH);
    	
    	hpLabel = new JLabel("HP:");
    	hpLabel.setFont(TEXT_FONT);
    	hpLabel.setForeground(TEXT_COLOR);
    	playerpanel.add(hpLabel);
    	
    	hpLabelNumber = new JLabel();
    	hpLabelNumber.setFont(TEXT_FONT);
    	hpLabelNumber.setForeground(TEXT_COLOR);
    	playerpanel.add(hpLabelNumber);
    	
    	weaponLabel = new JLabel("Weapon:");
    	weaponLabel.setFont(TEXT_FONT);
    	weaponLabel.setForeground(TEXT_COLOR);
    	playerpanel.add(weaponLabel);
    	
    	weaponLabelName = new JLabel();
    	weaponLabelName.setFont(TEXT_FONT);
    	weaponLabelName.setForeground(TEXT_COLOR);
    	playerpanel.add(weaponLabelName);

    	
    	
    
    	
    	mainTextPanel = new JPanel();
    	mainTextPanel.setBounds(100,100,600,250);
    	mainTextPanel.setBackground(Color.black);
    	window.add(mainTextPanel);
    	
    	mainTextArea= new JTextArea("");
    	mainTextArea.setBounds(100,100,600,250);
    	mainTextArea.setBackground(Color.BLACK);
    	mainTextArea.setForeground(TEXT_COLOR);
    	mainTextArea.setFont(TEXT_FONT);
    	mainTextArea.setLineWrap(true);
    	mainTextPanel.add(mainTextArea);
    	
    	
    	choiceButtonPanel = new JPanel();
    	choiceButtonPanel.setLayout(new GridLayout(4,1)); // Ajuste a margem horizontal e vertical entre os botões
    	choiceButtonPanel.setBackground(BACKGROUND_COLOR);
    	window.add(choiceButtonPanel, BorderLayout.SOUTH);

    	choice1 = new JButton("Choice 1");
    	customizeButton(choice1);
    	choice1.addActionListener(choiceHandler);
    	choice1.setActionCommand("c1");
    	choiceButtonPanel.add(choice1);
    	
    	choice2 = new JButton("Choice 2");
    	customizeButton(choice2);
    	choice2.addActionListener(choiceHandler);
    	choice2.setActionCommand("c2");
    	choiceButtonPanel.add(choice2);

    	choice3 = new JButton("Choice 3");
    	customizeButton(choice3);
    	choice3.addActionListener(choiceHandler);
    	choice3.setActionCommand("c3");
    	choiceButtonPanel.add(choice3);

    	choice4 = new JButton("Choice 4");
    	customizeButton(choice4);
    	choice4.addActionListener(choiceHandler);
    	choice4.setActionCommand("c4");
    	choiceButtonPanel.add(choice4);

    	window.revalidate();
    	window.repaint();
    	playerSetup();
    }
    
    private class TitleScreenHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            createGameScreen();
        }
    }
    
    
    
    
    public void playerSetup() {
    	playerHP = 15;
    	monsterHP = 20;
    	Weapon = "Knife";
    	weaponLabelName.setText(Weapon); 
    	hpLabelNumber.setText("" + playerHP); 
    	
    	townGate();
    }
    
    public void townGate() {
    	
    	position="townGate";
    	
    	mainTextArea.setText("Voçe esta de frente ao portão da cidade.\nUm guarda esta na sua frente. \n\nO que vc vai fazer?");
    	
    	choice1.setText("Falar com o Guarda");
    	choice2.setText("Atacar o Guarda");
    	choice3.setText("Fugir");
    	choice4.setText("");
    }
    
    public void talkGuard() {
    	position="talkGuard";
    	
    	mainTextArea.setText("Guarda: Ola estranho.I nunca vi vc por aqui, \nme desculope , mas não podemos deixar um estranho entrar na cidade");
    	
    	choice1.setText(">");
    	choice2.setText("");
    	choice3.setText("");
    	choice4.setText("");
    	
    }
    
    public void attackGuard() {
    	position="attackGuard";
    	
    	mainTextArea.setText("Guarda:Não seja idiota!! \n\n O guarda revida e ele lhe bate com força.\n (Vc recebeu 3 de dano) ");
    	playerHP = playerHP -3;
    	hpLabelNumber.setText(""+playerHP);
    	choice1.setText(">");
    	choice2.setText("");
    	choice3.setText("");
    	choice4.setText("");
    	
    }
    
    public void crossRoad() {
    	position="crossRoad";
    	mainTextArea.setText("Vc se encontra em uma encrusilhada.\nSe vc for ao su , ira voltar para a cidade.");
    	choice1.setText("Ir ao norte");
    	choice2.setText("Ir ao oeste");
    	choice3.setText("Ir ao Sul ");
    	choice4.setText("Ir ao leste");
    }
    
    public void north() {
    	position = "north";
    	mainTextArea.setText("Vc ve um rio. \nVc bebe a agua do rio e descança ao lado do rio.\n\n(Seu HP foi reculperado em 2)");
    	playerHP=playerHP+2;
    	hpLabelNumber.setText(""+playerHP);
    	choice1.setText("Ir ao Sul");
    	choice2.setText("");
    	choice3.setText("");
    	choice4.setText("");
    	
    }
    
    public void east() {
    	position = "east";
    	mainTextArea.setText("Vc Andou para uma floresta e achou uma Espada Longa!\n\n(vc obteve uma espada longa) ");
    	Weapon="Long Sword";
    	weaponLabelName.setText(Weapon);
    	choice1.setText("Ir para Oeste ");
    	choice2.setText("");
    	choice3.setText("");
    	choice4.setText("");
    	
    }
    
    public void west() {
    	position = "west";
    	mainTextArea.setText("Voçe achou um Goblin");
    	choice1.setText("Lutar");
    	choice2.setText("Fugir");
    	choice3.setText("");
    	choice4.setText("");
    	
    }
    
    public void fight() {
    	position = "fight";
    	mainTextArea.setText("Monster HP:"+monsterHP+"\n\n O que vc Faz ?");
    	choice1.setText("Lutar");
    	choice2.setText("Fugir");
    	choice3.setText("");
    	choice4.setText("");
    	
    }
    
    public void playerAttack() {
    	position="playerAttack";
    	
    	int playerDamage =0;
    	
    	if(Weapon.equals("Knife")) {
    	playerDamage = new java.util.Random().nextInt(3);
    	}
    	else if(Weapon.equals("Long Sword")) {
    	playerDamage = new java.util.Random().nextInt(8);	
    	}
    	
    	mainTextArea.setText("Vc atacou o monstro e deu "+playerDamage+" dano");
    	
    	monsterHP=monsterHP-playerDamage;
    	
    	choice1.setText(">");
    	choice2.setText("");
    	choice3.setText("");
    	choice4.setText("");
    }
    
    public void monsterAttack() {
    	position = "monsterAttack";
    	
    	int  monsterDamage = 0;
    	
    	monsterDamage = new java.util.Random().nextInt(6);
    	
    	mainTextArea.setText("monstro lhe atacou e deu "+monsterDamage+" dano");
    	
    	playerHP= playerHP-monsterDamage;
    	hpLabelNumber.setText(""+playerHP);
    	
    	choice1.setText(">");
    	choice2.setText("");
    	choice3.setText("");
    	choice4.setText("");
    	
    }
    
    public void win() {
    	position = "win";
    	
    	mainTextArea.setText("Vc derrotou o monstro!\n O monsto deixou cair um anel !\n\n(You obteve um anel de prata)");
    	
    	silverRing=1;
    	choice1.setText("Ir ao Leste");
    	choice2.setText("");
    	choice3.setText("");
    	choice4.setText("");
    }
    public void lose() {
    	position = "lose";
    	
    	mainTextArea.setText("Vc morreu :)");
    	choice1.setText(">");
    	choice2.setText("");
    	choice3.setText("");
    	choice4.setText("");
    	choice1.setVisible(false);
    	choice2.setVisible(false);
    	choice3.setVisible(false);
    	choice4.setVisible(false);
    }
    public void ending() {
    	position = "ending";
    	
    	mainTextArea.setText("Guarda: Vc matou o Goblin!?\nVlw mano Tu é fera\nBem vindo a cidade\n\n<Acabou>");
    	choice1.setText(">");
    	choice2.setText("");
    	choice3.setText("");
    	choice4.setText("");
    	choice1.setVisible(false);
    	choice2.setVisible(false);
    	choice3.setVisible(false);
    	choice4.setVisible(false);
    }
    
    
    
    public class ChoiceHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            String yourChoice = event.getActionCommand();

            switch (position) {

                case "townGate":
                    switch (yourChoice) {
                        case "c1":
                            if(silverRing==1) {
                            	ending();
                            }
                            else {
                            	talkGuard();
                            }
                            break;
                        case "c2":
                            attackGuard();
                            break;
                        case "c3":
                            crossRoad();
                            break;
                    }
                    break;

                case "talkGuard":
                    switch (yourChoice) {
                        case "c1":
                            townGate();
                            break;
                    }
                    break;

                case "attackGuard":
                    switch (yourChoice) {
                        case "c1":
                            townGate();
                            break;
                    }
                    break;

                case "crossRoad":
                    switch (yourChoice) {
                        case "c1":
                            north();
                            break;
                        case "c2":
                            east();
                            break;
                        case "c3":
                            townGate();
                            break;
                        case "c4":
                            west();
                            break;
                    }
                    break;

                case "north":
                    switch (yourChoice) {
                        case "c1":
                            crossRoad();
                            break;
                    }
                    break;

                case "east":
                    switch (yourChoice) {
                        case "c1":
                            crossRoad();
                            break;
                    }
                    break;

                case "west":
                    switch (yourChoice) {
                        case "c1":
                            fight();
                            break;
                        case "c2":
                            crossRoad();
                            break;
                    }
                    break;

                case "fight":
                    switch (yourChoice) {
                        case "c1":
                            playerAttack();
                            break;
                        case "c2":
                            crossRoad();
                            break;
                    }
                    break;

                case "playerAttack":
                    switch (yourChoice) {
                        case "c1":
                            if (monsterHP < 1) {
                                win();
                            } else {
                                monsterAttack();
                            }
                            break;
                    }
                    break;

                case "monsterAttack":
                    switch (yourChoice) {
                        case "c1":
                            if (playerHP < 1) {
                                lose();
                                break;
                            } else {
                                fight();
                            }
                            break;
                    }
                    break;

                case "win":
                    switch (yourChoice) {
                        case "c1":crossRoad();
                            // Coloque o código correspondente aqui
                            break;
                    }
                    break;
            }
        }
    }
    
    
    private void customizeButton(JButton button) {
        button.setFont(TEXT_FONT);
        button.setBackground(BUTTON_COLOR);
        button.setForeground(BUTTON_TEXT_COLOR);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
        button.setPreferredSize(new Dimension(200, 50));
    }
}
