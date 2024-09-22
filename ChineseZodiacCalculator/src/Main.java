import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Chinese Zodiac Calculator");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel label = new JLabel("Enter your birth year:");
        label.setBounds(50, 50, 200, 30);
        frame.add(label);

        JTextField birthYearField = new JTextField();
        birthYearField.setBounds(200, 50, 100, 30);
        frame.add(birthYearField);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(150, 100, 100, 30);
        frame.add(calculateButton);

        JLabel resultLabel = new JLabel();
        resultLabel.setBounds(50, 150, 300, 100);
        frame.add(resultLabel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = birthYearField.getText();
                try {
                    int birthYear = Integer.parseInt(input);
                    if (birthYear <= 0) {
                        resultLabel.setText("Please enter a valid year.");
                    } else {
                        String zodiacSign = getChineseZodiac(birthYear);
                        String description = getZodiacDescription(zodiacSign);
                        resultLabel.setText("<html>Your sign: " + zodiacSign + "<br>Description: " + description + "</html>");
                    }
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Please enter a valid number.");
                }
            }
        });

        // Set frame visible
        frame.setVisible(true);
    }

    // Method to determine Chinese Zodiac sign
    public static String getChineseZodiac(int year) {
        String[] zodiacSigns = {
            "Monkey", "Rooster", "Dog", "Pig", "Rat", "Ox", 
            "Tiger", "Rabbit", "Dragon", "Snake", "Horse", "Goat"
        };
        int zodiacIndex = year % 12;
        return zodiacSigns[zodiacIndex];
    }

    // Method to get description of each sign
    public static String getZodiacDescription(String zodiacSign) {
        switch (zodiacSign) {
            case "Monkey":
                return "Monkeys are intelligent, witty, and creative.";
            case "Rooster":
                return "Roosters are observant, hardworking, and courageous.";
            case "Dog":
                return "Dogs are loyal, honest, and reliable.";
            case "Pig":
                return "Pigs are generous, compassionate, and diligent.";
            case "Rat":
                return "Rats are clever, quick-witted, and resourceful.";
            case "Ox":
                return "Oxen are strong, dependable, and determined.";
            case "Tiger":
                return "Tigers are brave, confident, and competitive.";
            case "Rabbit":
                return "Rabbits are gentle, quiet, and elegant.";
            case "Dragon":
                return "Dragons are charismatic, energetic, and fearless.";
            case "Snake":
                return "Snakes are wise, enigmatic, and intuitive.";
            case "Horse":
                return "Horses are active, energetic, and adventurous.";
            case "Goat":
                return "Goats are calm, gentle, and sympathetic.";
            default:
                return "Unknown sign.";
        }
    }
}
