import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    private JPanel mainPanel;
    private JButton flowLayoutButton;
    private JButton borderLayoutButton;
    private JButton boxLayoutButton;
    private JButton cardLayoutButton;
    private JButton gridBagLayoutButton;
    private JButton gridLayoutButton;

    public Main() {
        setTitle("Layout Demo App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        mainPanel = new JPanel(new GridLayout(3, 2));

        flowLayoutButton = new JButton("FlowLayout");
        borderLayoutButton = new JButton("BorderLayout");
        boxLayoutButton = new JButton("BoxLayout");
        cardLayoutButton = new JButton("CardLayout");
        gridBagLayoutButton = new JButton("GridBagLayout");
        gridLayoutButton = new JButton("GridLayout");

        mainPanel.add(flowLayoutButton);
        mainPanel.add(borderLayoutButton);
        mainPanel.add(boxLayoutButton);
        mainPanel.add(cardLayoutButton);
        mainPanel.add(gridBagLayoutButton);
        mainPanel.add(gridLayoutButton);

        setContentPane(mainPanel);

        flowLayoutButton.addActionListener(e -> {
            new FlowLayoutFrame().setVisible(true);
        });

        borderLayoutButton.addActionListener(e -> {
            new BorderLayoutFrame().setVisible(true);
        });

        gridLayoutButton.addActionListener(e -> {
            new GridLayoutFrame().setVisible(true);
        });

        boxLayoutButton.addActionListener(e -> {
            new BoxLayoutFrame().setVisible(true);
        });

        cardLayoutButton.addActionListener(e -> {
            new CardLayoutFrame().setVisible(true);
        });

        gridBagLayoutButton.addActionListener(e -> {
            new GridBagLayoutFrame().setVisible(true);
        });

        setVisible(true);
    }


    class FlowLayoutFrame extends JFrame {
        public FlowLayoutFrame() {
            setTitle("Flow Layout");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(500, 400);
            setLocationRelativeTo(null);

            setLayout(new FlowLayout(FlowLayout.CENTER));

            add(new JButton("Przycisk 1"));
            add(new JButton("Przycisk 2"));
            add(new JButton("Przycisk 3"));
            add(new JButton("Przycisk 4"));
        }
    }

    class BorderLayoutFrame extends JFrame {
        public BorderLayoutFrame() {
            setTitle("Border Layout");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(500, 400);
            setLocationRelativeTo(null);

            setLayout(new BorderLayout());

            add(new JButton("Przycisk 1"), BorderLayout.WEST);
            add(new JButton("Przycisk 2"), BorderLayout.EAST);
            add(new JButton("Przycisk 3"), BorderLayout.SOUTH);
            add(new JButton("Przycisk 4"), BorderLayout.NORTH);
            add(new JButton("Przycisk 5"), BorderLayout.CENTER);
        }
    }


    class GridLayoutFrame extends JFrame {
        public GridLayoutFrame() {
            setTitle("Grid Layout");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(500, 400);
            setLocationRelativeTo(null);

            setLayout(new GridLayout(3, 3));

            for (int i = 1; i <= 9; i++) {
                add(new JButton("Przycisk " + i));
            }
        }
    }


    class BoxLayoutFrame extends JFrame {
        public BoxLayoutFrame() {
            setTitle("Box Layout");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(500, 400);
            setLocationRelativeTo(null);

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            panel.add(new JButton("Przycisk 1"));
            panel.add(new JButton("Przycisk 2"));
            panel.add(new JButton("Przycisk 3"));
            panel.add(new JButton("Długi Przycisk 4"));

            add(panel);
        }
    }

    class CardLayoutFrame extends JFrame {
        private CardLayout cardLayout;
        private JPanel panel;

        public CardLayoutFrame() {
            setTitle("Card Layout");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(500, 400);
            setLocationRelativeTo(null);

            cardLayout = new CardLayout();
            panel = new JPanel(cardLayout);

            JPanel card1 = new JPanel();
            JPanel card2 = new JPanel();
            JPanel card3 = new JPanel();

            card1.add(new JLabel("Card 1"));
            card2.add(new JLabel("Card 2"));
            card3.add(new JLabel("Card 3"));

            panel.add(card1, "Card 1");
            panel.add(card2, "Card 2");
            panel.add(card3, "Card 3");

            JPanel panel2 = new JPanel();

            JButton wstecz = new JButton("Wstecz");
            JButton dalej = new JButton("Dalej");

            wstecz.addActionListener(e -> {
                cardLayout.previous(panel);
            });

            dalej.addActionListener(e -> {
                cardLayout.next(panel);
            });

            panel2.add(wstecz);
            panel2.add(dalej);

            add(panel, BorderLayout.CENTER);
            add(panel2, BorderLayout.SOUTH);
        }
    }

    class GridBagLayoutFrame extends JFrame {
        public GridBagLayoutFrame() {
            setTitle("GridBag Layout");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(500, 400);
            setLocationRelativeTo(null);

            setLayout(new GridBagLayout());

            GridBagConstraints c = new GridBagConstraints();
            c.insets = new Insets(5, 5, 5, 5);

            c.gridx = 1;
            c.gridy = 0;
            c.gridwidth = 2;
            c.fill = GridBagConstraints.NONE;

            add(new JButton("Zaloguj"), c);

            c.gridx = 1;
            c.gridy = 1;
            c.gridwidth = 2;
            add(new JButton("Anuluj"), c);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main();
        });
    }
}
