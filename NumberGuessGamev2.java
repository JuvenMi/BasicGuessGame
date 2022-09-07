package swingGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGuessGamev2 extends JFrame{
    private JPanel pnlMain;
    private JLabel lblMaxRangeMsg;
    private JTextField ftxtReadMaxRange;
    private JButton btnSelectRandomNum;
    private JLabel lblSelectedMessage;
    private JLabel lblReadGuess;
    private JTextField ftxtReadGuess;
    private JButton btnIsCorrectGuess;
    private JLabel lblUporDown;
    private JLabel lblTextTryNum;
    private JLabel lblTryNum;
    private JButton btnSystemRandomShow;
    private JLabel lblShowNum;

    int randomNum, temp, temp2, tryNum = 0;

    public NumberGuessGamev2(){
        //settings of app
        add(pnlMain);
        setTitle("Number Guess Game");
        setSize(435,200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        /**
         * Reading num of max range and attach @param temp;
         * Creating random with @func SelectRandom and attach @param randomNum;
         */
        btnSelectRandomNum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                temp = Integer.parseInt(ftxtReadMaxRange.getText());
                randomNum = SelectRandom(temp);
                lblSelectedMessage.setText("Sistem başarıyla rastgele sayıyı seçti");
                btnSystemRandomShow.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        lblShowNum.setText(Integer.toString(randomNum));
                    }
                });
            }
        });
        /**
         * Read user input from Textfield @param ftxtReadGuess;
         * if @param temp2 (user input) and @param randomNum equal
         * setting text @param lblUporDown because new input user guess
         * setting text @param lblTryNum for how many tried
         */
        btnIsCorrectGuess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tryNum++;
                temp2 = Integer.parseInt(ftxtReadGuess.getText());
                if (temp2 == randomNum){
                    lblUporDown.setText("doğru");
                }
                else if (temp2 > randomNum){
                    lblUporDown.setText("random daha küçük ");
                }else {
                    lblUporDown.setText("random daha büyük");
                }
                lblTryNum.setText(Integer.toString(tryNum));
            }
        });
    }

    /**
     * Created select for random num;
     * @param range limit of max range;
     * @return created select num;
     */
    public int SelectRandom(int range){
        return (int)((Math.random() * range) + 1);
    }
}
