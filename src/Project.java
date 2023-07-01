import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {
    private Image main;
    String user_type, meterno;

    Project() {

        /* Frame Image */
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third_new.jpg"));
        main = i1.getImage().getScaledInstance(1300, 670, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(main);
        JLabel limage = new JLabel(i3);
        add(limage);

        JMenuBar menubar = new JMenuBar();
        menubar.setBackground(new Color(238, 232, 170));
        setJMenuBar(menubar);

        /* "newInformation" menu creation */
        JMenu newInformation = new JMenu("New Information");
        newInformation.setFont(new Font("Tahoma", Font.BOLD, 15));
        newInformation.setForeground(new Color(3, 7, 82));
        menubar.add(newInformation);

        /* newInformation-MenuItem -> New Faculty and its properties */
        JMenuItem newFaculty = new JMenuItem("New Faculty Information");
        newFaculty.setFont(new Font("regular", Font.BOLD, 16));
        newFaculty.setBackground(Color.WHITE);
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/icon1.png"));
        Image image1 = icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        newFaculty.setIcon(new ImageIcon(image1)); /* It will set the icons to "New Customer" menu item */
        newFaculty.setMnemonic('F');
        newFaculty.addActionListener(this);
        newFaculty.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
        /* Or we can use... */
        /*
         * newFaculty.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,
         * KeyEvent.CTRL_DOWN_MASK));
         */

        newInformation.add(newFaculty);

        /* newInformation-MenuItem -> New Student and its properties */
        JMenuItem newStudent = new JMenuItem("New Student Admission");
        newStudent.setFont(new Font("regular", Font.BOLD, 16));
        newStudent.setBackground(Color.WHITE);
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("icons/icon2.png"));
        Image image2 = icon2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        newStudent.setIcon(new ImageIcon(image2));
        newStudent.setMnemonic('S');
        newStudent.addActionListener(this);
        newStudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        newInformation.add(newStudent);

        /* "View Details" menu creation */
        JMenu viewDetails = new JMenu("View Details");
        viewDetails.setFont(new Font("Tahoma", Font.BOLD, 15));
        viewDetails.setForeground(Color.RED);
        menubar.add(viewDetails);

        /* viewDetails-MenuItem -> Faculty Details and its properties */
        JMenuItem facultyDetails = new JMenuItem("Faculty Details");
        facultyDetails.setFont(new Font("regular", Font.BOLD, 16));
        facultyDetails.setBackground(Color.WHITE);
        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("icons/icon3.png"));
        Image image3 = icon3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        facultyDetails.setIcon(new ImageIcon(image3));
        facultyDetails.setMnemonic('M');
        facultyDetails.addActionListener(this);
        facultyDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        viewDetails.add(facultyDetails);

        /* viewDetails-MenuItem -> Students Details and its properties */
        JMenuItem studentDetails = new JMenuItem("Students Details");
        studentDetails.setFont(new Font("regular", Font.BOLD, 16));
        studentDetails.setBackground(Color.WHITE);
        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("icons/icon4.jpg"));
        Image image4 = icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        studentDetails.setIcon(new ImageIcon(image4));
        studentDetails.setMnemonic('P');
        studentDetails.addActionListener(this);
        studentDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        viewDetails.add(studentDetails);

        /* "Apply Leave" menu creation */
        JMenu applyLeave = new JMenu("Apply Leave");
        applyLeave.setFont(new Font("Tahoma", Font.BOLD, 15));
        applyLeave.setForeground(new Color(3, 7, 82));
        menubar.add(applyLeave);

        /* Apply Leave-MenuItem -> Faculty Leave Information and its properties */
        JMenuItem facultyLeave = new JMenuItem("Faculty Leave");
        facultyLeave.setFont(new Font("regular", Font.BOLD, 16));
        facultyLeave.setBackground(Color.WHITE);
        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("icons/icon5.png"));
        Image image5 = icon5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        facultyLeave.setIcon(new ImageIcon(image5));
        facultyLeave.setMnemonic('K');
        facultyLeave.addActionListener(this);
        facultyLeave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.CTRL_MASK));
        applyLeave.add(facultyLeave);

        /* Apply Leave-MenuItem -> Student Leave Information and its properties */
        JMenuItem studentLeave = new JMenuItem("Student Leave");
        studentLeave.setFont(new Font("regular", Font.BOLD, 16));
        studentLeave.setBackground(Color.WHITE);
        ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("icons/icon6.png"));
        Image image6 = icon6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        studentLeave.setIcon(new ImageIcon(image6));
        studentLeave.setMnemonic('L');
        studentLeave.addActionListener(this);
        studentLeave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        applyLeave.add(studentLeave);

        /* "Leave Details" menu creation */
        JMenu leaveDetails = new JMenu("Leave Details");
        leaveDetails.setFont(new Font("Tahoma", Font.BOLD, 15));
        leaveDetails.setForeground(Color.RED);
        menubar.add(leaveDetails);

        /*
         * Leave Details-MenuItem -> facultyLeaveDetails Information and its properties
         */
        JMenuItem facultyLeaveDetails = new JMenuItem("Faculty Leave Details");
        facultyLeaveDetails.setFont(new Font("regular", Font.BOLD, 16));
        facultyLeaveDetails.setBackground(Color.WHITE);
        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("icons/icon7.png"));
        Image image7 = icon7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        facultyLeaveDetails.setIcon(new ImageIcon(image7));
        // facultyLeaveDetails.setMnemonic('G');
        facultyLeaveDetails.addActionListener(this);
        // facultyLeaveDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,
        // ActionEvent.CTRL_MASK));
        leaveDetails.add(facultyLeaveDetails);

        /* Leave Details-MenuItem -> Student Leave Details and its properties */
        JMenuItem studentLeaveDetails = new JMenuItem("Student Leave Details");
        studentLeaveDetails.setFont(new Font("regular", Font.BOLD, 16));
        studentLeaveDetails.setBackground(Color.WHITE);
        ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource("icons/icon8.png"));
        Image image8 = icon8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        studentLeaveDetails.setIcon(new ImageIcon(image8));
        // studentLeaveDetails.setMnemonic('B');
        studentLeaveDetails.addActionListener(this);
        // studentLeaveDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,
        // ActionEvent.CTRL_MASK));
        leaveDetails.add(studentLeaveDetails);

        /* "Examination" menu creation */
        JMenu examination = new JMenu("Examination");
        examination.setFont(new Font("Tahoma", Font.BOLD, 15));
        examination.setForeground(new Color(3, 7, 82));
        menubar.add(examination);

        /* Examination-MenuItem -> Exam Result Information and its properties */
        JMenuItem examResult = new JMenuItem("Exam Result");
        examResult.setFont(new Font("regular", Font.BOLD, 16));
        examResult.setBackground(Color.WHITE);
        ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource("icons/icon9.png"));
        Image image9 = icon9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        examResult.setIcon(new ImageIcon(image9));
        // examResult.setMnemonic('G');
        examResult.addActionListener(this);
        // examResult.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,
        // ActionEvent.CTRL_MASK));
        examination.add(examResult);

        /* Examination-MenuItem -> Enter Marks */
        JMenuItem enterMarks = new JMenuItem("Enter Marks");
        enterMarks.setFont(new Font("regular", Font.BOLD, 16));
        enterMarks.setBackground(Color.WHITE);
        ImageIcon icon10 = new ImageIcon(ClassLoader.getSystemResource("icons/icon10.png"));
        Image image10 = icon10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        enterMarks.setIcon(new ImageIcon(image10));
        // enterMarks.setMnemonic('B');
        enterMarks.addActionListener(this);
        // enterMarks.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,
        // ActionEvent.CTRL_MASK));
        examination.add(enterMarks);

        /* "Updates Details" menu creation */
        JMenu updateDetails = new JMenu("Updates Details");
        updateDetails.setFont(new Font("Tahoma", Font.BOLD, 15));
        updateDetails.setForeground(Color.RED);
        menubar.add(updateDetails);

        /*
         * Updates Details-MenuItem -> Update Faculty Details Information and its
         * properties
         */
        JMenuItem updateFacultyDetails = new JMenuItem("Update Faculty Details");
        updateFacultyDetails.setFont(new Font("regular", Font.BOLD, 16));
        updateFacultyDetails.setBackground(Color.WHITE);
        ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("icons/icon11.png"));
        Image image11 = icon11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        updateFacultyDetails.setIcon(new ImageIcon(image11));
        // updateFacultyDetails.setMnemonic('G');
        updateFacultyDetails.addActionListener(this);
        // updateFacultyDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,
        // ActionEvent.CTRL_MASK));
        updateDetails.add(updateFacultyDetails);

        /* Updates Details-MenuItem -> Update Student Details */
        JMenuItem updateStudentDetails = new JMenuItem("Update Student Details");
        updateStudentDetails.setFont(new Font("regular", Font.BOLD, 16));
        updateStudentDetails.setBackground(Color.WHITE);
        ImageIcon icon12 = new ImageIcon(ClassLoader.getSystemResource("icons/icon12.png"));
        Image image12 = icon12.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        updateStudentDetails.setIcon(new ImageIcon(image12));
        // updateStudentDetails.setMnemonic('B');
        updateStudentDetails.addActionListener(this);
        // updateStudentDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,
        // ActionEvent.CTRL_MASK));
        updateDetails.add(updateStudentDetails);

        /* "Fee Details" menu creation */
        JMenu feeDetails = new JMenu("Fee Details");
        feeDetails.setFont(new Font("Tahoma", Font.BOLD, 15));
        feeDetails.setForeground(new Color(3, 7, 82));
        menubar.add(feeDetails);

        /* Fee Details-MenuItem -> Fee Structure Information and its properties */
        JMenuItem feeStructure = new JMenuItem("Fee Structure");
        feeStructure.setFont(new Font("regular", Font.BOLD, 16));
        feeStructure.setBackground(Color.WHITE);
        ImageIcon icon13 = new ImageIcon(ClassLoader.getSystemResource("icons/icon13.jpg"));
        Image image13 = icon13.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        feeStructure.setIcon(new ImageIcon(image13));
        // feeStructure.setMnemonic('G');
        feeStructure.addActionListener(this);
        // feeStructure.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,
        // ActionEvent.CTRL_MASK));
        feeDetails.add(feeStructure);

        /* Fee Details-MenuItem -> Student Fee Form */
        JMenuItem studentFeeForm = new JMenuItem("Student Fee Form");
        studentFeeForm.setFont(new Font("regular", Font.BOLD, 16));
        studentFeeForm.setBackground(Color.WHITE);
        ImageIcon icon14 = new ImageIcon(ClassLoader.getSystemResource("icons/icon10.png"));
        Image image14 = icon14.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        studentFeeForm.setIcon(new ImageIcon(image14));
        // studentFeeForm.setMnemonic('B');
        studentFeeForm.addActionListener(this);
        // studentFeeForm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,
        // ActionEvent.CTRL_MASK));
        // feeDetails.add(studentFeeForm);

        /* "Utility" menu creation */
        JMenu utility = new JMenu("Utility");
        utility.setFont(new Font("Tahoma", Font.BOLD, 15));
        utility.setForeground(Color.RED);
        menubar.add(utility);

        /* Utility-MenuItem -> Notepad and its properties */
        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setFont(new Font("regular", Font.BOLD, 16));
        notepad.setBackground(Color.WHITE);
        ImageIcon icon15 = new ImageIcon(ClassLoader.getSystemResource("icons/icon11.png"));
        Image image15 = icon15.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(image15));
        notepad.setMnemonic('N');
        notepad.addActionListener(this);
        notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        utility.add(notepad);

        /* Utility-MenuItem -> Calculator and its properties */
        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setFont(new Font("regular", Font.BOLD, 16));
        calculator.setBackground(Color.WHITE);
        ImageIcon icon16 = new ImageIcon(ClassLoader.getSystemResource("icons/icon12.png"));
        Image image16 = icon16.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calculator.setIcon(new ImageIcon(image16));
        calculator.setMnemonic('C');
        calculator.addActionListener(this);
        calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        utility.add(calculator);

        /* Utility-MenuItem -> Web Browser and its properties */
        JMenuItem webBrowser = new JMenuItem("Web Browser");
        webBrowser.setFont(new Font("regular", Font.BOLD, 16));
        webBrowser.setBackground(Color.WHITE);
        ImageIcon icon17 = new ImageIcon(ClassLoader.getSystemResource("icons/icon9.png"));
        Image image17 = icon17.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        webBrowser.setIcon(new ImageIcon(image17));
        webBrowser.setMnemonic('C');
        webBrowser.addActionListener(this);
        webBrowser.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        utility.add(webBrowser);

        /* "Mexit" menu creation */
        JMenu mexit = new JMenu("Exit");
        mexit.setFont(new Font("Tahoma", Font.BOLD, 15));
        mexit.setForeground(new Color(3, 7, 82));
        menubar.add(mexit);

        /* Mexit-MenuItem -> Exit Information and its properties */
        JMenuItem exit = new JMenuItem("Exit");
        exit.setFont(new Font("regular", Font.BOLD, 16));
        exit.setBackground(Color.WHITE);
        // ImageIcon icon17 = new
        // ImageIcon(ClassLoader.getSystemResource("icons/icon11.png"));
        // Image image17 = icon17.getImage().getScaledInstance(20, 20,
        // Image.SCALE_DEFAULT);
        exit.setIcon(new ImageIcon(image17));
        exit.setMnemonic('W');
        exit.addActionListener(this);
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        mexit.add(exit);

        setTitle("Nalanda College, Biharsharif");
        setVisible(true);
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH); /* For full image */
        setLocationRelativeTo(null);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new Project();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = e.getActionCommand();

        if (msg.equals("New Student Admission")) {
            new NewStudentAdmission();

        } else if (msg.equals("New Faculty Information")) {
            new NewFacultyInformation();

        } else if (msg.equals("Students Details")) {
            new StudentDetails();

        } else if (msg.equals("Faculty Details")) {
            new TeacherDetails();

        } else if (msg.equals("Update Student Details")) {
            new updateStudentDetails();

        } else if (msg.equals("Update Faculty Details")) {
            new UpdateTeacherDetails();

        } else if (msg.equals("Fee Structure")) {
            new FeeStructure();

        } else if (msg.equals("Student Fee Form")) {
            // new StudentFeeForm().setVisible(true);

        } else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception ex) {
            }
        } else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception ex) {
            }
        } else if (msg.equals("Web Browser")) {

            try {
                Runtime.getRuntime().exec("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
            } catch (Exception ex) {
            }
        } else if (msg.equals("Exit")) {
            System.exit(0);

        } else if (msg.equals("Faculty Leave")) {
            new TeacherLeave();

        } else if (msg.equals("Student Leave")) {
            new StudentLeave();

        } else if (msg.equals("Faculty Leave Details")) {
            new TeacherLeaveDetails();

        } else if (msg.equals("Student Leave Details")) {
            new StudentLeaveDetails();

        } else if (msg.equals("Exam Result")) {
            new ExaminationDetails();

        } else if (msg.equals("Enter Marks")) {
            new EnterMarks();

        }

    }

}
