import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        MessagingApp app = new MessagingApp();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("       ------\n        Menu\n       ------");
            System.out.println("1.Send Messages\n2.Read All Messages\n3.Messages of Specific Receiver\n4.Search Message\n5.Delete Message\n6.Display Contacts\n0.Exit");
            System.out.println("\nEnter your choice: ");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    app.sendMessage();
                    break;
                case 2:
                    app.readAllMessages();
                    break;
                case 3:
                    app.readReceiverMessages();
                    break;
                case 4:
                    app.searchMessage();
                    break;
                case 5:
                    app.deleteMessages();
                    break;
                case 6:
                    app.displayContacts();
                    break;
                case 0:
                    System.exit(1);
                    break;
                default:
                    break;
            }
        }
    }
}
