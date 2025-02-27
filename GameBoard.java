import javax.swing.*;
import java.awt.*;

public class GameBoard extends JFrame {
    public int Width = 8;
    public int Height = 8;
    public int SquareSize = 80;
    private JPanel[][] squares = new JPanel[Width][Height];
    private String[][] piecesArray;

    public GameBoard() {
        setTitle("Valorant");
        setSize(Width * SquareSize, Height * SquareSize);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(Height, Width));

        for (int y = 0; y < Height; y++) {
            for (int x = 0; x < Width; x++) {
                squares[x][y] = new JPanel();
                squares[x][y].setPreferredSize(new Dimension(SquareSize, SquareSize));
                squares[x][y].setBackground(Color.WHITE);
                add(squares[x][y]);
            }
        }

        piecesArray = new String[Width * Height][2];
        loadPieces();
        populateBoard();
    }

    private int getNumber(int x, int y) {
        return y * Width + x;
    }


    private void populateBoard() {
    for (int y = 0; y < Height; y++) {
        for (int x = 0; x < Width; x++) {
            int index = getNumber(x, y);
            String imagePath = piecesArray[index][0];
            JLabel label = new JLabel();
            label.setHorizontalAlignment(SwingConstants.CENTER);

            if (!imagePath.equals("#FFFFFF")) {
                ImageIcon icon = new ImageIcon(imagePath);
                Image image = icon.getImage();
                Image scaledImage = image.getScaledInstance(SquareSize, SquareSize, Image.SCALE_SMOOTH);
                label.setIcon(new ImageIcon(scaledImage));
            }

            squares[x][y].removeAll();
            squares[x][y].setLayout(new BorderLayout());  // Ensure the label is properly centered
            squares[x][y].add(label, BorderLayout.CENTER);
        }
    }
    revalidate();
    repaint();
}

    private void loadPieces() {
        
        // Red
        int[][] redCoords = {{1,2},{7,2},{1,3},{2,3},{6,3},{7,3},{1,4},{2,4},{3,4},{5,4},{6,4},{7,4},{2,5},{3,5},{4,5},{3,6},{4,6},{5,6}};
        String defaultImagePath = "red.png";
        for (int[] coord : redCoords) {
            int num = getNumber(coord[0] - 1, coord[1] - 1); // Adjust for 0-based indexing
            piecesArray[num][0] = defaultImagePath; // Black hex code
            piecesArray[num][1] = String.valueOf(num);
        }


        // Black
        int[][] blackCoords = {{2,2},{8,2},{3,3},{8,3},{4,4},{8,4},{5,5}};
        defaultImagePath = "black.png";
        for (int[] coord : blackCoords) {
            int num = getNumber(coord[0] - 1, coord[1] - 1); // Adjust for 0-based indexing
            piecesArray[num][0] = defaultImagePath; // Black hex code
            piecesArray[num][1] = String.valueOf(num);
        }


        // LetterV
        int[][] letterVCoords = {{1,8}};
        defaultImagePath = "v.png";
        for (int[] coord : letterVCoords) {
            int num = getNumber(coord[0] - 1, coord[1] - 1); // Adjust for 0-based indexing
            piecesArray[num][0] = defaultImagePath; // Dark Grey hex code
            piecesArray[num][1] = String.valueOf(num);
        }


        // LetterA
        int[][] letterACoords = {{2,8},{6,8}};
        defaultImagePath = "a.png";
        for (int[] coord : letterACoords) {
            int num = getNumber(coord[0] - 1, coord[1] - 1); // Adjust for 0-based indexing
            piecesArray[num][0] = defaultImagePath; // Dark Grey hex code
            piecesArray[num][1] = String.valueOf(num);
        }


        // LetterL
        int[][] letterLCoords = {{3,8}};
        defaultImagePath = "l.png";
        for (int[] coord : letterLCoords) {
            int num = getNumber(coord[0] - 1, coord[1] - 1); // Adjust for 0-based indexing
            piecesArray[num][0] = defaultImagePath; // Dark Grey hex code
            piecesArray[num][1] = String.valueOf(num);
        }


        // LetterO
        int[][] letterOCoords = {{4,8}};
        defaultImagePath = "o.png";
        for (int[] coord : letterOCoords) {
            int num = getNumber(coord[0] - 1, coord[1] - 1); // Adjust for 0-based indexing
            piecesArray[num][0] = defaultImagePath; // Dark Grey hex code
            piecesArray[num][1] = String.valueOf(num);
        }


        // LetterR
        int[][] letterRCoords = {{5,8}};
        defaultImagePath = "r.png";
        for (int[] coord : letterRCoords) {
            int num = getNumber(coord[0] - 1, coord[1] - 1); // Adjust for 0-based indexing
            piecesArray[num][0] = defaultImagePath; // Dark Grey hex code
            piecesArray[num][1] = String.valueOf(num);
        }


        // LetterN
        int[][] letterNCoords = {{7,8}};
        defaultImagePath = "n.png";
        for (int[] coord : letterNCoords) {
            int num = getNumber(coord[0] - 1, coord[1] - 1); // Adjust for 0-based indexing
            piecesArray[num][0] = defaultImagePath; // Dark Grey hex code
            piecesArray[num][1] = String.valueOf(num);
        }


        // letterT
        int[][] letterTCoords = {{8,8}};
        defaultImagePath = "t.png";
        for (int[] coord : letterTCoords) {
            int num = getNumber(coord[0] - 1, coord[1] - 1); // Adjust for 0-based indexing
            piecesArray[num][0] = defaultImagePath; // Dark Grey hex code
            piecesArray[num][1] = String.valueOf(num);
        }



        // Fill remaining slots with "Empty"
        for (int i = 0; i < Width * Height; i++) {
            if (piecesArray[i][0] == null) {
                piecesArray[i][0] = "#FFFFFF"; // Default to white for empty slots
                piecesArray[i][1] = String.valueOf(i);
            }
        }
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameBoard board = new GameBoard();
            board.setVisible(true);
        });
    }
}