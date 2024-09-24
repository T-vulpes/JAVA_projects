import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Zodiac Calculator");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.black);

        String[] days = new String[31];
        for (int i = 1; i <= 31; i++) {
            days[i - 1] = String.valueOf(i);
        }
        JComboBox<String> dayComboBox = new JComboBox<>(days);
        dayComboBox.setBounds(50, 50, 100, 30);
        frame.add(dayComboBox);

        String[] months = {
            "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"
        };
        JComboBox<String> monthComboBox = new JComboBox<>(months);
        monthComboBox.setBounds(160, 50, 100, 30);
        frame.add(monthComboBox);

        String[] years = new String[105];
        for (int i = 1920; i <= 2024; i++) {
            years[i - 1920] = String.valueOf(i);
        }
        JComboBox<String> yearComboBox = new JComboBox<>(years);
        yearComboBox.setBounds(270, 50, 100, 30);
        frame.add(yearComboBox);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(50, 100, 100, 30);
        submitButton.setBackground(Color.white); // Buton arka plan rengi
        submitButton.setForeground(Color.BLACK); // Buton yazı rengi
        frame.add(submitButton);

        JLabel resultLabel = new JLabel();
        resultLabel.setBounds(50, 150, 300, 30);
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Yazı puntolarını büyütme
        resultLabel.setForeground(Color.WHITE);
        frame.add(resultLabel);

        JLabel zodiacDescriptionLabel = new JLabel();
        zodiacDescriptionLabel.setBounds(50,100, 400, 100);
        zodiacDescriptionLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Yazı puntolarını büyütme
        zodiacDescriptionLabel.setForeground(Color.WHITE);
        frame.add(zodiacDescriptionLabel);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedDay = (String) dayComboBox.getSelectedItem();
                String selectedMonth = (String) monthComboBox.getSelectedItem();
                String selectedYear = (String) yearComboBox.getSelectedItem();

                String zodiacSign = getZodiacSign(Integer.parseInt(selectedDay), selectedMonth);
                String zodiacDescription = getZodiacDescription(zodiacSign);

                resultLabel.setText("Selected Date: " + selectedDay + " " + selectedMonth + " " + selectedYear);
                zodiacDescriptionLabel.setText("Zodiac: " + zodiacSign + " - " + zodiacDescription);
            }
        });

        frame.setVisible(true);
    }

    // Burç hesaplayan metot
    public static String getZodiacSign(int day, String month) {
        switch (month) {
            case "January":
                return (day < 20) ? "Capricorn" : "Aquarius";
            case "February":
                return (day < 19) ? "Aquarius" : "Pisces";
            case "March":
                return (day < 21) ? "Pisces" : "Aries";
            case "April":
                return (day < 20) ? "Aries" : "Taurus";
            case "May":
                return (day < 21) ? "Taurus" : "Gemini";
            case "June":
                return (day < 21) ? "Gemini" : "Cancer";
            case "July":
                return (day < 23) ? "Cancer" : "Leo";
            case "August":
                return (day < 23) ? "Leo" : "Virgo";
            case "September":
                return (day < 23) ? "Virgo" : "Libra";
            case "October":
                return (day < 23) ? "Libra" : "Scorpio";
            case "November":
                return (day < 22) ? "Scorpio" : "Sagittarius";
            case "December":
                return (day < 22) ? "Sagittarius" : "Capricorn";
            default:
                return "Invalid Month";
        }
    }

    // Burç açıklamalarını döndüren metot
    public static String getZodiacDescription(String zodiacSign) {
        switch (zodiacSign) {
            case "Capricorn":
                return "Practical and disciplined.";
            case "Aquarius":
                return "Innovative and humanitarian.";
            case "Pisces":
                return "Compassionate and artistic.";
            case "Aries":
                return "Bold and ambitious.";
            case "Taurus":
                return "Reliable and patient.";
            case "Gemini":
                return "Versatile and communicative.";
            case "Cancer":
                return "Emotional and nurturing.";
            case "Leo":
                return "Confident and charismatic.";
            case "Virgo":
                return "Analytical and meticulous.";
            case "Libra":
                return "Charming and diplomatic.";
            case "Scorpio":
                return "Passionate and resourceful.";
            case "Sagittarius":
                return "Adventurous and philosophical.";
            default:
                return "No description available.";
        }
    }
}
