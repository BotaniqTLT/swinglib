import DAO.MyData;
import DAO.MyHeaderModel;
import DAO.MyTableModel;
import DAO.TestDAO;
import DTO.Container;
import DTO.MapComboBoxModel;
import DTO.Person;
import bean.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.botaniqtlt.libs.DAO.SelectDAO;

import javax.persistence.Table;
import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class HelloDemo extends JFrame {

//    private  SearchDAO searchDAO;

    private SelectDAO selectDAO;

    private JPanel panelMain;
    private JTextField txtName;
    private JButton btnClick;
    private JTable TablePerson;
    private JComboBox comboBox1;
    private JButton button2;
    private JButton button1;

    public HelloDemo(SelectDAO selectDAO, TestDAO testDAO) {
        this.selectDAO = selectDAO;

        button1.addActionListener(this::onClick);
        TablePerson.getTableHeader().setVisible(true);
        TablePerson.getTableHeader().setColumnModel(new MyHeaderModel("FirstName", "SecondName", "Score"));

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

        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1, "Старался");
        map.put(2, "Пытался");
        map.put(3, "Пыжился");




//        ArrayList<Container<Integer, String>> tempArray = new ArrayList<>();
//        tempArray.add(new Container<>(null, ""));
//        for (Map.Entry<Integer, String> entry : map.entrySet()) {
//            tempArray.add(new Container<>(entry.getKey(), entry.getValue()));
//
//        }
//        ComboBoxModel<Object> cmb = new DefaultComboBoxModel<>(tempArray.toArray());

        MapComboBoxModel<Integer, String> cmb = new MapComboBoxModel<>(map);
        comboBox1.setModel(cmb);
        List<Person> person = testDAO.getPerson();

        this.addRowJTable(person);






        button2.addActionListener((a) -> {
//            Container<Integer, String> selectedItem = (Container<Integer, String>) cmb.getSelectedItem();
            Container<Integer, String> selectedItem = cmb.getSelectedContainer();
            String value = selectedItem.getValue();
            JOptionPane.showMessageDialog(btnClick, value);
        });

    }
    private void onClick(ActionEvent e) {
        java.util.List<MyData> myDataList = Arrays.asList(
                new MyData("first1", "second1", randomScore()),
                new MyData("first2", "second2", randomScore()),
                new MyData("first3", "second3", randomScore()));

        TablePerson.setModel(new MyTableModel(myDataList));
        System.out.println("clicked");

    }

    private int randomScore() {
        Double v = Math.random() * 100;
        return v.intValue();
    }

    public void addRowJTable(List<Person> person) {



        DefaultTableModel model= (DefaultTableModel) TablePerson.getModel();


//        Object  rowData1[] = new Object[3];

        for (int i = 0; i < person.size(); i++) {
            Object  rowData1[] = new Object[3];
            rowData1[0]= person.get(i).getId();
            rowData1[1]= person.get(i).getAge();
            rowData1[2]= person.get(i).getName();
            model.addRow(rowData1);

        }

        TablePerson.getTableHeader().setVisible(true);
        TablePerson.getTableHeader().setColumnModel(new MyHeaderModel("FirstName", "SecondName", "Score"));



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
