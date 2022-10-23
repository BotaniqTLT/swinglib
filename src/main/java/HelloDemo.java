import bean.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.botaniqtlt.libs.DAO.SearchDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HelloDemo extends JFrame {

    private JPanel panelMain;
    private JTextField txtName;
    private JButton btnClick;

    public HelloDemo() {
        btnClick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(btnClick, txtName.getText() + " Hello");
            }
        });
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

        ctx.register(AppConfig.class);
        ctx.refresh();
        SearchDAO searchBean = ctx.getBean(SearchDAO.class);


        HelloDemo h = new HelloDemo();

        h.setContentPane(h.panelMain);
        h.setTitle("Hellow");
        h.setSize(300,400);
        h.setVisible(true);
        h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
