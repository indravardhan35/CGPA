/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cgpacalculator;

/**
 *
 * @author Indravardhan
 */
import javax.swing.*;
import java.awt.*;
public class Help extends JFrame {
    public Help() {
        // Set up the frame
        setTitle("Help");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Add a title
        JLabel helpLabel = new JLabel("CGPA Calculator Help", JLabel.CENTER);
        helpLabel.setFont(new Font("Arial", Font.BOLD, 30));
        add(helpLabel, BorderLayout.NORTH);

        // Add help content
        JTextArea helpText = new JTextArea();
        helpText.setText("""
            Instructions for using the CGPA Calculator:
            1. Enter the number of subjects and labs in the respective fields.
            2. Click 'Add Subjects' to input marks for each subject and lab.
            3. Ensure marks are between 0 and 100.
            4. The calculator will compute your CGPA and overall grade.
            5. If you encounter issues, double-check your inputs or refer to these instructions.
            """);
        helpText.setFont(new Font("Arial", Font.PLAIN, 30));
        helpText.setEditable(false); // Make the text area non-editable
        helpText.setLineWrap(true); // Enable line wrapping
        helpText.setWrapStyleWord(true); // Wrap at word boundaries

        JScrollPane scrollPane = new JScrollPane(helpText);
        add(scrollPane, BorderLayout.CENTER);

        // Add a close button
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dispose());
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(closeButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}

