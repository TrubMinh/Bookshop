import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterForm extends JDialog{
    private JTextField textName;
    private JTextField tfEmail;
    private JTextField tfPhone;
    private JPasswordField Pfpassword;
    private JPasswordField PfConpassword;
    private JTextField tfidnam;
    private JButton BtnRegister;
    private JButton BtnCancer;
    private JPanel Registerpanel;

    public RegisterForm(JFrame parent) {
        super(parent);
        setTitle(" Create a new account");
        setContentPane(Registerpanel);
        setMinimumSize(new Dimension(450, 470));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        BtnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });
        BtnCancer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }
    private void registerUser() {
        String Name =textName.getText();
        String Email=tfEmail.getText();
        String Phone=tfPhone.getText();
        String IDname=tfidnam.getText();
        String Password = String.valueOf(Pfpassword.getPassword());
        String ConfirmPassword = String.valueOf(PfConpassword.getPassword());
        if(Name.isEmpty()||Email.isEmpty()||Phone.isEmpty()||IDname.isEmpty()||Password.isEmpty()){
            JOptionPane.showMessageDialog(this, "please enter all fields","try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(!Password.equals(ConfirmPassword)){
            JOptionPane.showMessageDialog(this,"password doesnt match","try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        user = addUsertodatabase(Name,Email,Phone,IDname,Password);
        if(user!=null){
            dispose();
        }
        else {
            JOptionPane.showMessageDialog(this,"Failed to register new user","try again",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    public User user;
    private User addUsertodatabase(String Name,String Email,String Phone, String IDname, String Password){
        User user = null;
        return user;
//        chỗ này cần liên kết MYSQl tự làm nha
    }

    public static void main(String[] args) {
        RegisterForm myform = new RegisterForm(null);
        User user = myform.user;;
        if(user!=null){
            System.out.println("Đăng ký thành công :"+user.Name);
        }
        else{
            System.out.println("Đăng ký không thành công");
        }

    }

}
