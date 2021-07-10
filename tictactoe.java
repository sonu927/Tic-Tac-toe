import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class tictactoe implements ActionListener{
    Random random = new Random();
    JFrame f = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JTextField text_field = new JTextField();
    JButton[] buttons = new JButton[9];
    boolean player_turn;

    tictactoe(){
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600,600);
        f.setLayout(new BorderLayout());
        f.getContentPane().setBackground(Color.red);
        f.setVisible(true);

        text_field.setBackground(Color.BLACK);
        text_field.setFont(new Font("Arial",Font.BOLD,75));
        text_field.setForeground(Color.GREEN);
        text_field.setHorizontalAlignment(JLabel.CENTER);
        text_field.setText("Tic-Tac-Toe");
        text_field.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,600,100);
        title_panel.add(text_field);

        for(int i =0;i<9;i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFocusable(false);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setBackground(Color.darkGray);
            buttons[i].addActionListener(this);
        }



        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(Color.gray);

        f.add(title_panel,BorderLayout.NORTH);
        f.add(button_panel);

        whoseturn();
    }
    
    public void whoseturn(){
        try{
        Thread.sleep(2000);
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        if(random.nextInt(2) == 0){
            player_turn = true;
            text_field.setText("X turn"); 
        }
        else{
            player_turn = false;
            text_field.setText("O turn"); 
        }
    }

    public void check(){
        //check Xwin condition
       if(buttons[0].getText() == "X" && buttons[1].getText() == "X" 
        && buttons[2].getText() == "X"){
            Xwins(0, 1, 2);
        }
        if(buttons[3].getText() == "X" && buttons[4].getText() == "X" 
        && buttons[5].getText() == "X"){
            Xwins(3, 4, 5);
        }
        if(buttons[6].getText() == "X" && buttons[7].getText() == "X" 
        && buttons[8].getText() == "X"){
            Xwins(6, 7, 8);
        }
        if(buttons[0].getText() == "X" && buttons[3].getText() == "X" 
        && buttons[6].getText() == "X"){
            Xwins(0, 3, 6);
        }
        if(buttons[1].getText() == "X" && buttons[4].getText() == "X" 
        && buttons[7].getText() == "X"){
            Xwins(2, 4, 7);
        }
        if(buttons[2].getText() == "X" && buttons[5].getText() == "X" 
        && buttons[8].getText() == "X"){
            Xwins(2, 5, 8);
        }
        if(buttons[0].getText() == "X" && buttons[4].getText() == "X" 
        && buttons[8].getText() == "X"){
            Xwins(0, 4, 8);
        }
        if(buttons[2].getText() == "X" && buttons[4].getText() == "X" 
        && buttons[6].getText() == "X"){
            Xwins(2, 4, 6);
        }


        //check O win condition
        if(buttons[0].getText() == "O" && buttons[1].getText() == "O" 
        && buttons[2].getText() == "O"){
            Owins(0, 1, 2);
        }
        if(buttons[3].getText() == "O" && buttons[4].getText() == "O" 
        && buttons[5].getText() == "O"){
            Owins(3, 4, 5);
        }
        if(buttons[6].getText() == "O" && buttons[7].getText() == "O" 
        && buttons[8].getText() == "O"){
            Owins(6, 7, 8);
        }
        if(buttons[0].getText() == "O" && buttons[3].getText() == "O" 
        && buttons[6].getText() == "O"){
            Owins(0, 3, 6);
        }
        if(buttons[1].getText() == "O" && buttons[4].getText() == "O" 
        && buttons[7].getText() == "O"){
            Owins(2, 4, 7);
        }
        if(buttons[2].getText() == "O" && buttons[5].getText() == "O" 
        && buttons[8].getText() == "O"){
            Owins(2, 5, 8);
        }
        if(buttons[0].getText() == "O" && buttons[4].getText() == "O" 
        && buttons[8].getText() == "O"){
            Owins(0, 4, 8);
        }
        if(buttons[2].getText() == "O" && buttons[4].getText() == "O" 
        && buttons[6].getText() == "O"){
            Owins(2, 4, 6);
        }
    }

    public void Xwins(int a,int b,int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        text_field.setText("X Won!! :)");
    }    

    public void Owins(int a ,int b,int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        text_field.setText("O Won!! :)");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i =0 ;i<9;i++){
            if(e.getSource() == buttons[i]){
                if(player_turn){
                    if(buttons[i].getText() == ""){
                        buttons[i].setForeground(Color.red);
                        buttons[i].setText("X");
                        player_turn = false;
                        text_field.setText("O turn");
                        check();
                    }
                }
                else{
                    if(buttons[i].getText() == ""){
                        buttons[i].setForeground(Color.blue);
                        buttons[i].setText("O");
                        player_turn = true;
                        text_field.setText("X turn");
                        check();
                    }    
                }
            }
        }
        
    }
}