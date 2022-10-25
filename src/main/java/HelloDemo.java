import DAO.TestDAO;
import DTO.Person;
import bean.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.botaniqtlt.libs.DAO.SelectDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class HelloDemo extends JFrame {

//    private  SearchDAO searchDAO;

    private SelectDAO selectDAO;

    private JPanel panelMain;
    private JTextField txtName;
    private JButton btnClick;
    private JTable TablePerson;

    public HelloDemo(SelectDAO selectDAO, TestDAO testDAO) {
        this.selectDAO = selectDAO;
        btnClick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                List<Person> person = testDAO.getPerson();

                //JTable variable name is jTable1_info....
                DefaultTableModel model = (DefaultTableModel) TablePerson.getModel();
                //Clear all the column name on jtable jpanel-4
                model.setColumnCount(0);
//                model.addColumn();


                JOptionPane.showMessageDialog(btnClick, txtName.getText() + " Hello");
//                selectDAO.select();
            }
        });

    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

        ctx.register(AppConfig.class);
        ctx.refresh();
        SelectDAO searchBean = ctx.getBean(SelectDAO.class);
        TestDAO testDAO = ctx.getBean(TestDAO.class);

        HelloDemo h = new HelloDemo(searchBean, testDAO);


        h.setContentPane(h.panelMain);
        h.setTitle("Hellow");
        h.setSize(300, 400);
        h.setVisible(true);
        h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
