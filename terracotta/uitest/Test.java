import java.awt.*;
import java.awt.event.*;

public class Test extends Frame implements ActionListener {

  Button cutButton, copyButton, pasteButton;
  public Test() {
    super("Toolbar Example (AWT)");
    setSize(450, 250);
  
    Panel toolbar = new Panel();
    toolbar.setLayout(new FlowLayout(FlowLayout.LEFT));

    cutButton = new Button("Cut");
    cutButton.addActionListener(this);
    toolbar.add(cutButton);

    copyButton = new Button("Copy");
    copyButton.addActionListener(this);
    toolbar.add(copyButton);

    pasteButton = new Button("Paste");
    pasteButton.addActionListener(this);
    toolbar.add(pasteButton);

    add(toolbar, BorderLayout.NORTH);
  }

  public void actionPerformed(ActionEvent ae) {
    System.out.println(ae.getActionCommand());
  }

  public static void main(String args[]) {
    Test tf1 = new Test();
    tf1.setVisible(true);
  }
}
