import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class App extends JFrame {

    private JLabel numberLabel;
    private JButton generateButton;

    public App() {
        createView();

        setTitle("Gerador de Número Aleatório");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void createView() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        getContentPane().add(panel);

        numberLabel = new JLabel("Clique para gerar um número");
        numberLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        numberLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(numberLabel);

        generateButton = new JButton("Gerar Número");
        generateButton.addActionListener(new GenerateButtonActionListener());
        panel.add(generateButton);
    }

    private class GenerateButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Random random = new Random();
            int randomNumber = random.nextInt(100) + 1; 
            numberLabel.setText("Número sorteado: " + randomNumber);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new App().setVisible(true);
        });
    }
}
