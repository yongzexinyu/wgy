import java.util.List;
import java.util.Scanner;

public class CustomerService {
    private Customer currentCustomer;
    private List<Customer> customers;
    public void checkPwd(String cardNum,String cardPwd){
        CustomerData cus= CustomerData.getInstance();
        customers= cus.getList();
    System.out.println("cardNum = " + cardNum);
    System.out.println("cardPwd = " + cardPwd);
    for (Customer c:customers) {
        if(c.getAccount().equals(cardNum) && c.getPwd().equals(cardPwd)){
            currentCustomer=c;
            System.out.println("欢迎"+c.getCname()+"用户，请注意安全");
            TestUtil.oneOption();
            Scanner sc=new Scanner(System.in);
            String option = sc.nextLine();
            choose(option);


        }

    }
}

    private void choose(String option) {
        switch (option){
            case "1":
                System.out.println("查询余额");
                doSelectMoney();
                goHome();
                break;
            case "2":
                System.out.println("取款");
                withdrawMoney();
                goHome();
                break;
            case "3":
                System.out.println("存款");
                deposit();
                goHome();
                break;
            case "4":
                System.out.println("转账");
                goHome();
                break;
            case "5":
                System.out.println("退出");
                System.exit(0);
                goHome();
                break;
        }
    }


    private void deposit() {
        Scanner sc=new Scanner(System.in);
        System.out.println("请选择你要存款的金额1.200 2.500 3.1000");
        double money1 = sc.nextDouble();
        double depositMoney=currentCustomer.getMoney()+money1;
        currentCustomer.setMoney(depositMoney);
        System.out.println("您当前的存款金额为"+depositMoney);
    }

    private void withdrawMoney() {
        Scanner sc=new Scanner(System.in);
        System.out.println("请选择你要取款的金额1.200 2.500 3.1000");
        double money1 = sc.nextDouble();
        double allMoney=currentCustomer.getMoney()-money1;
        currentCustomer.setMoney(allMoney);
        System.out.println("您当前的存款金额为"+allMoney);

    }

    private void doSelectMoney() {
       double money= currentCustomer.getMoney();
        System.out.println("余额为"+money);
    }

    private void goHome() {
        TestUtil.oneOption();
        Scanner sc=new Scanner(System.in);
        String  a=sc.nextLine();
        choose(a);

    }
}
