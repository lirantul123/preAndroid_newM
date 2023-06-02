package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.*;
import java.util.*;
import java.util.List;
import javax.swing.*;

public class MyFrame extends JFrame{

    Calendar calendar;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String time;
    String day;
    String date;
    private JTextField nameOwn;
    private JTextField money1;

    private List<String> namesList;
    private List<String> moneyList;

    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Clock Program");
        this.setLayout(new FlowLayout());
        this.setSize(400,250);
        this.setResizable(false);
        setLocationRelativeTo(null);

        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("MMMMM dd, yyyy");

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana",Font.PLAIN,18));
        timeLabel.setForeground(new Color(0, 0, 0));
        timeLabel.setBackground(Color.black);
       // timeLabel.setOaque(true);
        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Ink Free",Font.PLAIN,0));

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Ink Free",Font.PLAIN,0));

        nameOwn = new JTextField(20);
        money1 = new JTextField(20);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));


        JLabel nameLabel = new JLabel("Name:");
        panel.add(nameLabel);
        panel.add(nameOwn);

        JLabel moneyLabel = new JLabel("Money:");
        panel.add(moneyLabel);
        panel.add(money1);

        JLabel empty = new JLabel(" ");
        panel.add(empty);

        // Create the submit button
        JButton submitButton = new JButton("Submit");
        panel.add(submitButton);



        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameOwn.getText();  // Get the user input
                String money = money1.getText();
                System.out.printf("Name- %s, moneyOwn- %s", name, money);
                nameOwn.setText("");
                money1.setText("");  // Clear the input field
                namesList.add(name);  // Add the name to the list
                moneyList.add(money+"₪");
                System.out.println();
                //ADD PEOPLE TO LIST...
            }
        });
        JButton showArray = new JButton("Show Array");
        panel.add(showArray);

        // Initialize the names list
        namesList = new ArrayList<>();
        moneyList = new ArrayList<>();

        showArray.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String namesString = String.join(", ", namesList);
                String moneysString = String.join(", ", moneyList);


                if (namesString.isEmpty()) {
                    System.out.println("No names added.");
                } else {
                    System.out.println();
                    System.out.printf("names: [%s]", namesString);
                    System.out.println();;
                    System.out.printf("money amount: [%s]", moneysString);
                }
            }
        });

        // Add the panel to the frame
        add(panel);

        // Display the frame
        setVisible(true);
        for (int i = 0; i < 8; i++) {
            JLabel empty2 = new JLabel(" ");
            panel.add(empty2);

        }

        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        setTime();
    }

    public void setTime() {
        while(true) {
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
