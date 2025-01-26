/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
*/
package cgpacalculator;


/**
*
* @author Indravardhan
*/
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class CgpaCalculator {

// Method to calculate grade point based on marks

public static double calculateGradePoint(double marks) {
if (marks >= 90 && marks <= 100) {
return 10.0;
} else if (marks >= 80) {
return 9.0;
} else if (marks >= 70) {
return 8.0;
} else if (marks >= 60) {
return 7.0;
} else if (marks >= 50) {
return 6.0;
} else if (marks >= 40) {
return 5.0;
} else {
return 0.0;
}
}

// Method to get grade based on grade point
public static String getGrade(double gradePoint) {
    if (gradePoint >= 9.0 && gradePoint <= 10.0) {
        return "O";
    } else if (gradePoint >= 8.0 && gradePoint < 9.0) {
        return "A+";
    } else if (gradePoint >= 7.0 && gradePoint < 8.0) {
        return "A";
    } else if (gradePoint >= 6.0 && gradePoint < 7.0) {
        return "B+";
    } else if (gradePoint >= 5.0 && gradePoint < 6.0) {
        return "B";
    } else if (gradePoint >= 4.0 && gradePoint < 5.0) { 
        return "C";
    } else {
        return "F";
    }
}

public static void main(String args[]) {
SwingUtilities.invokeLater(new Runnable() {
    @Override
    public void run() {
        JFrame frame = new JFrame("CGPA Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 350);
        BackgroundPanel backgroundPanel = new BackgroundPanel("background.png");
        backgroundPanel.setLayout(new BorderLayout());
        frame.setContentPane(backgroundPanel);
        
// Layout setup
frame.setLayout(new BorderLayout());

JLabel titleLabel = new JLabel("CGPA Calculator", JLabel.CENTER);
titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
titleLabel.setForeground(Color.WHITE);
frame.add(titleLabel, BorderLayout.NORTH);
        
// Create labels
JLabel numSubjectsLabel = new JLabel("Enter number of subjects:");
numSubjectsLabel.setFont(new Font("Arial", Font.PLAIN, 20));
 numSubjectsLabel.setForeground(Color.WHITE);

JLabel numLabsLabel = new JLabel("Enter the number of labs:");
numLabsLabel.setFont(new Font("Arial", Font.PLAIN, 20));
 numLabsLabel.setForeground(Color.WHITE);

// Create text fields for input
JTextField numSubjectsInput = new JTextField();
numSubjectsInput.setPreferredSize(new Dimension(100, 25)); // Set preferred size for input field

JTextField numLabsInput = new JTextField();
numLabsInput.setPreferredSize(new Dimension(100, 25)); // Set preferred size for input field

// Create a panel for placing labels and text fields vertically
JPanel inputPanel = new JPanel();
 inputPanel.setOpaque(false);
inputPanel.setLayout(new GridLayout(2, 2, 10, 10)); // 2 rows, 2 columns, with space between elements
inputPanel.add(numSubjectsLabel);
inputPanel.add(numSubjectsInput);
inputPanel.add(numLabsLabel);
inputPanel.add(numLabsInput);

// Create another panel to center the inputPanel within the window
JPanel centerPanel = new JPanel();
centerPanel.setOpaque(false);
centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Center alignment
centerPanel.add(inputPanel);

// Add the centered panel to the main frame
frame.add(centerPanel, BorderLayout.CENTER);




// Panel for button at the bottom
JPanel buttonPanel = new JPanel();
buttonPanel.setOpaque(false);
JButton addSubjectsButton = new JButton("Add Subjects");
JButton helpButton = new JButton("Help");
buttonPanel.add(addSubjectsButton);
buttonPanel.add(helpButton);
frame.add(buttonPanel, BorderLayout.SOUTH);
helpButton.addActionListener(e -> {
    Help helpFrame = new Help();
    helpFrame.setVisible(true);
});

addSubjectsButton.addActionListener(e -> {
    int numSubjects;
    int numLabs;
    try {
        numSubjects = Integer.parseInt(numSubjectsInput.getText());
        if (numSubjects <= 0) {
            throw new NumberFormatException("Invalid number of subjects.");
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(frame, "Please enter a valid positive integer for the number of subjects.");
        return;
    }
    
    try {
        numLabs = Integer.parseInt(numLabsInput.getText());
        if (numLabs <= 0) {
            throw new NumberFormatException("Invalid number of labs.");
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(frame, "Please enter a valid positive integer for the number of labs.");
        return;
    }
    
// Create subject input dialog
JPanel marksPanel = new JPanel();
marksPanel.setLayout(new GridLayout(numSubjects + numLabs, 2, 10, 10));  // Two columns: one for labels, one for text fields
JTextField[] marksFields = new JTextField[numSubjects + numLabs];

// Create text fields for subjects marks
for (int i = 0; i < numSubjects; i++) {
    marksPanel.add(new JLabel("Subject " + (i + 1) + " :"));
    marksFields[i] = new JTextField();
    marksFields[i].setPreferredSize(new Dimension(100, 25));  // Set smaller preferred size for the text field
    marksPanel.add(marksFields[i]);
}

// Create text fields for labs marks
for (int i = 0; i < numLabs; i++) {
    marksPanel.add(new JLabel("Lab " + (i + 1) + " :"));
    marksFields[numSubjects + i] = new JTextField();
    marksFields[numSubjects + i].setPreferredSize(new Dimension(100, 25));  // Set smaller preferred size for the text field
    marksPanel.add(marksFields[numSubjects + i]);
}

int option = JOptionPane.showConfirmDialog(frame, marksPanel, "Enter Marks", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

if (option == JOptionPane.OK_OPTION) {
    double totalGradePoints = 0.0;
    boolean validInput = true;
    
// Validate and process the marks input
for (int i = 0; i < numSubjects + numLabs; i++) {
    int marks;
    try {
        marks = Integer.parseInt(marksFields[i].getText());
        if (marks < 0 || marks > 100) {
            throw new NumberFormatException("Marks out of range.");
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(frame, "Invalid marks entered. Please enter a value between 0 and 100.");
        validInput = false;
        break;
    }
    
    double gradePoint = calculateGradePoint(marks);
    totalGradePoints += gradePoint;
}

if (validInput) {
    double cgpa = totalGradePoints / (numSubjects + numLabs);
    cgpa = Math.round(cgpa * 100.0) / 100.0;
    String overallGrade = getGrade(cgpa);
    JOptionPane.showMessageDialog(frame,
            "Your CGPA for the semester is: " + cgpa + "\nYour Overall Grade: " + overallGrade,
            "Results",
            JOptionPane.INFORMATION_MESSAGE);
}
}
});

frame.setVisible(true);
    }
});
}

}
