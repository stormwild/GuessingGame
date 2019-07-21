package games.guessing.GuessingGame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * GuessingGame
 *
 */
public class GuessingGame extends JFrame {
    private static final long serialVersionUID = 1L;
    private static String[] defaultFontNames = { "PT Sans", "Helvetica Neue", "Tahoma", "SansSerif" };
    private String titleText = "Hi-Lo Guessing Game";
    private String headerFont = FontHelper.getFirstAvailableFontName(defaultFontNames);
    private Font bodyFont = new Font(headerFont, Font.PLAIN, 16);

    private int num;
    private int tries;

    // Header
    private JLabel headerLabel = new JLabel(titleText);

    // Guess
    private String guessStr = "Guess a number between 1 and 100: ";
    private JLabel guessLabel = new JLabel(guessStr);

    // Guess TextField
    private JTextField guessTextField = new JTextField();

    // Output
    private JLabel outputLabel = new JLabel();

    public GuessingGame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(titleText);
        getContentPane().setLayout(null);

        // Header Label
        headerLabel.setFont(new Font(headerFont, Font.BOLD, 24));
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerLabel.setBounds(0, 0, 450, 50);
        getContentPane().add(headerLabel);

        // Guess Label
        guessLabel.setFont(bodyFont);
        guessLabel.setHorizontalAlignment(SwingConstants.LEFT);
        guessLabel.setBounds(24, 55, 275, 24);
        getContentPane().add(guessLabel);

        // Guess Field
        guessTextField.setFont(bodyFont);
        guessTextField.setHorizontalAlignment(SwingConstants.LEFT);
        guessTextField.setBounds(275 + 16, 55, 100, 24);
        guessTextField.setToolTipText("Press Enter to submit.");
        guessTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("event: " + e.paramString());
                checkGuess();
            }
        });
        getContentPane().add(guessTextField);

        // Output
        outputLabel.setFont(bodyFont);
        outputLabel.setHorizontalAlignment(SwingConstants.CENTER);
        outputLabel.setBounds(24, 80, 400, 50);
        getContentPane().add(outputLabel);
    }

    public void init() {
        num = (int) (Math.random() * 100 + 1);
        tries = 0;
    }

    public static void main(String[] args) {

        GuessingGame game = new GuessingGame();
        game.init();
        game.setSize(new Dimension(450, 300));
        game.setVisible(true);
    }

    public void checkGuess() {
        String guessText = guessTextField.getText();
        String message = "";

        try {

            int guess = Integer.parseInt(guessText);

            if (guess < num) {
                message = guess + " is too low. Try again.";
            } else if (guess > num) {
                message = guess + " is too high. Try again.";
            } else {
                message = guess + " is correct. You win!";
            }
            outputLabel.setText(message);
        } catch (Exception e) {
            message = "Enter a whole number between 1 and 100.";
        } finally {
            outputLabel.setText(message);
            guessTextField.requestFocus();
            guessTextField.selectAll();
        }
    }
}
