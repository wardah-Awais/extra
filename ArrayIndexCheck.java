//Git Repository
// https://github.com/wardah-Awais/Final-Project

package Project;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class GUI_Interface extends JFrame {
	private JPanel inputField;
	private JTextField txtTitle;
	private JTextArea textArea;

	// Book lists
	private List<String> availableBooks = new ArrayList<>();
	private List<String> borrowedBooks = new ArrayList<>();

	
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				GUI_Interface frame = new GUI_Interface();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}


	public GUI_Interface() {
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 500, 360);
	    inputField = new JPanel();
	    inputField.setLayout(null);
	    inputField.setBackground(Color.PINK); 
	    setContentPane(inputField);

	    JLabel lblNewLabel = new JLabel("Enter Book Title:");
	    lblNewLabel.setBounds(30, 30, 120, 20);
	    lblNewLabel.setForeground(Color.BLACK); 
	    inputField.add(lblNewLabel);

	    txtTitle = new JTextField();
	    txtTitle.setBounds(160, 30, 290, 25);
	    txtTitle.setBackground(new Color(30, 30, 30));
	    txtTitle.setForeground(Color.WHITE);
	    txtTitle.setCaretColor(Color.WHITE);
	    inputField.add(txtTitle);

	    JButton btnAdd = new JButton("Add Book");
	    btnAdd.setBounds(30, 70, 120, 30);
	    btnAdd.setBackground(Color.BLUE); 
	    btnAdd.setForeground(Color.WHITE);
	    inputField.add(btnAdd);

	    JButton btnList = new JButton("List Books");
	    btnList.setBounds(180, 70, 150, 30);
	    btnList.setBackground(Color.GREEN);
	    btnList.setForeground(Color.WHITE);
	    inputField.add(btnList);

	    JButton btnBorrow = new JButton("Borrow Book");
	    btnBorrow.setBounds(350, 70, 120, 30);
	    btnBorrow.setBackground(Color.ORANGE); 
	    btnBorrow.setForeground(Color.WHITE);
	    inputField.add(btnBorrow);

	    JButton btnReturn = new JButton("Return Book");
	    btnReturn.setBounds(30, 111, 120, 30);
	    btnReturn.setBackground( Color.RED); 
	    btnReturn.setForeground(Color.WHITE);
	    inputField.add(btnReturn);

	    JButton btnSearch = new JButton("Search Book");
	    btnSearch.setBounds(180, 111, 150, 30);
	    btnSearch.setBackground(Color.MAGENTA); 
	    btnSearch.setForeground(Color.WHITE);
	    inputField.add(btnSearch);

	    JButton btnClear = new JButton("Clear");
	    btnClear.setBounds(350, 111, 120, 30);
	    btnClear.setBackground(Color.LIGHT_GRAY); 
	    btnClear.setForeground(Color.WHITE);
	    inputField.add(btnClear);
	    
	    JButton btnReplay = new JButton("Replay");
	    btnReplay.setBounds(180, 300, 150, 30);
	    btnReplay.setBackground(Color.YELLOW);
	    btnReplay.setForeground(Color.BLACK);
	    inputField.add(btnReplay);

	    textArea = new JTextArea();
	    textArea.setBounds(30, 160, 440, 130);
	    textArea.setBackground( Color.BLACK);
	    textArea.setForeground(Color.CYAN);
	    textArea.setCaretColor(Color.WHITE);
	    textArea.setLineWrap(true);
	    textArea.setWrapStyleWord(true);
	    inputField.add(textArea);
	    
	    
	    
	    //<<<<<<<<<<<<<<<<< Buttons Logic (Main Logic) >>>>>>>>>>>>>>>>>

	    //button to add books
		btnAdd.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	//.trim() → removes spaces at the beginning and end 
		        String title = txtTitle.getText().trim();
		        // Check if the input is empty
		        if (title.isEmpty()) {
		            textArea.setText(" Please enter a valid book title.");
		            return;
		        }
		     // Check if the book already exists in the availableBooks
		        if (availableBooks.contains(title)) {
		            textArea.setText(" Book already exists in the library.");
		        } 
		        else {
		        	// If not already present, add the book to the list
		            availableBooks.add(title);
		            textArea.setText(" Book added:  " + title);
		        }
		    }
		});

		
	    //button to List available books
		btnList.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // If no books in the list, show message
		        if (availableBooks.isEmpty()) {
		            textArea.setText("---- No available books.----");
		            return;
		        }
		        // Create a string to hold the book list
		        String books = "----  Available Books----- :\n";

		        // Use for loop to go through the list
		        for (int i = 0; i < availableBooks.size(); i++) {
		            String book = availableBooks.get(i);
		            books += "-> " + book + "\n";
		        }
		        // Show the list in the text area
		        textArea.setText(books);
		    }
		});
		
		
		//button to borrow a book
		btnBorrow.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {

		        // Get the book title entered by the user 
		        String title = txtTitle.getText().trim();

		        // If the user not enter name
		        if (title.isEmpty()) {
		            textArea.setText(" Please enter a book title to borrow.");
		            return; 
		        }

		        // If the book is found in the available books list
		        if (availableBooks.contains(title)) {
		            availableBooks.remove(title);         // Remove it from available
		            borrowedBooks.add(title);            // Add it to borrowed list
		            textArea.setText("  Book borrowed: " + title);
		        } 
		        else {
		            // If the book is not in the available list
		            textArea.setText("---- Book not available.----");
		        }
		    }
		});
		
		//button to return a book
		btnReturn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {

		        // Get the book title entered by the user (remove extra spaces)
		        String title = txtTitle.getText().trim();

		        // If no title was entered
		        if (title.isEmpty()) {
		            textArea.setText("Please enter a book title to return.");
		            return; 
		        }

		        // Check if the book is in the borrowed list
		        if (borrowedBooks.contains(title)) {
		            borrowedBooks.remove(title);         // Remove from borrowed list
		            availableBooks.add(title);           // Add back to available list
		            textArea.setText("Book returned: " + title); 
		        } 
		        else {
		            textArea.setText("Book not in borrowed list.");
		        }
		    }
		});

		

		btnSearch.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String title = txtTitle.getText().trim();
		     // If the user did not type anything
		        if (title.isEmpty()) {
		            textArea.setText("Please enter a book title to search.");
		            return;
		        }


		        if (availableBooks.contains(title)) {
		            textArea.setText("Book is available in the library.");
		        } 
		     // Check if it is in the borrowed list
		        else if (borrowedBooks.contains(title)) {
		            textArea.setText("Book is currently borrowed.");
		        } 
		     // If the book is not found in either list
		        else {
		            textArea.setText("Book not found.");
		        }
		    }
		});

		

		btnClear.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Clear the text in the input field
		        txtTitle.setText("");
		        // Clear the text in the output area
		        textArea.setText("");
		    }
		});
		
		
		btnReplay.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Clear both book lists
		        availableBooks.clear();
		        borrowedBooks.clear();

		        // Clear the input and output fields
		        txtTitle.setText("");
		        textArea.setText("Library has been reset. Ready to start again!");

		        // Optional: Confirm replay
		        JOptionPane.showMessageDialog(null, "Library reset completed.");
		    }
		});



	}
}
