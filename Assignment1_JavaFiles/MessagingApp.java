import java.util.Scanner;
public class MessagingApp {
    public Receiver[][] receivers;
    public static int receiversCounter = 0;

    {
        // Initialize the 2D array "receivers"
        receivers = new Receiver[500][500];
        receivers[0][0] = new Receiver("Sara", "1234567", new Message("Hello, Sara", "unseen"));
        receivers[0][1] = new Receiver("Sara", "1234567", new Message("Where are you?", "unseen"));
        receivers[0][2] = new Receiver("Sara", "1234567", new Message("I am waiting for you in the class.", "unseen"));
        receiversCounter++;
        receivers[1][0] = new Receiver("Ali", "1234557", new Message("Hello, Ali", "unseen"));
        receivers[1][1] = new Receiver("Ali", "1234557", new Message("Call me after the class.", "unseen"));
        receivers[1][2] = new Receiver("Ali", "1234557", new Message("Send me the lecture notes.", "unseen"));
        receiversCounter++;
        receivers[2][0] = new Receiver("Mehdi", "1224557", new Message("Send the timetable.", "unseen"));
        receiversCounter++;

    }

    public void sendMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Receiver:\nName:");
        String name = sc.nextLine();
        System.out.println("Phone Number:");
        String number = sc.nextLine();
        System.out.println("Message Content: ");
        String content = sc.nextLine();
        Receiver temp = new Receiver(name, number, new Message(content, "unseen"));
        boolean found = false;
        for (int i = 0; i < receiversCounter; i++) {
            if (receivers[i][0] != null && receivers[i][0].equals(temp)) {
                for (int j = 0; j < receivers[i].length; j++) {
                    if (receivers[i][j] == null) {
                        receivers[i][j] = temp;
                        System.out.println("\nMessage sent successfully\n");
                        found = true;
                        break;
                    }
                }
                break;
            }

        }
        if (!found && receiversCounter < receivers.length) {
            receivers[receiversCounter++][0] = temp;
            System.out.println("Message sent successfully\n");
        }

    }

    public void readAllMessages() {
        System.out.println("All Messages\n");
        sortMessages();
        for(int i=0; i<receiversCounter;i++){
            for(int j=0; j<receivers[i].length;j++){
                if(receivers[i][j]!=null){
                    receivers[i][j].getMessage().setStatus("Seen");
                }
            }
        }
    }

    public void readReceiverMessages() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Receiver's Name: ");
        String name = sc.nextLine();
        System.out.println("Receiver's Number: ");
        String number = sc.nextLine();
        System.out.println("\n");
        boolean found = false;
        for (int i = 0; i < receiversCounter; i++) {
            if (receivers[i][0] != null && (receivers[i][0].getName().compareTo(name) == 0 && receivers[i][0].getNumber().compareTo(number) == 0)){
                found = true;
                for (int j = 0; j < receivers[i].length; j++) {
                    if(receivers[i][j]!=null){
                        System.out.println(receivers[i][j]);
                        System.out.println("------------------------------\n");
                        receivers[i][j].getMessage().setStatus("Seen");
                    }
                }
            }
        }
        if (!found) {
            System.out.println("Receiver Not Found");
        }
    }

    public void deleteMessages() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Receiver's Name: ");
        String name = sc.nextLine();
        System.out.println("Receiver's Number: ");
        String number = sc.nextLine();
        System.out.println("\n");
        boolean found = false;
        boolean messageFound = false;
        for (int i = 0; i < receiversCounter; i++) {
            for (int j = 0; j < receivers[i].length; j++) {
                if (receivers[i][j] != null && (receivers[i][j].getName().compareTo(name) == 0 && receivers[i][j].getNumber().compareTo(number) == 0)) {
                    System.out.println(receivers[i][j]);
                    System.out.println("------------------------------\n");
                    found = true;
                }
            }
            if (found) {
                break;
            }
        }
        if (found) {
            System.out.println("Enter Message ID: ");
            String id = sc.nextLine();
            for (int i = 0; i < receiversCounter; i++) {
                for (int j = 0; j < receivers[i].length; j++) {
                    if (receivers[i][j] != null && (receivers[i][j].getMessage().messageId.compareTo(id)) == 0) {
                        receivers[i][j] = null;
                        System.out.println("\nMessage Deleted Successfully\n");
                        messageFound =true;
                        break;
                    }
                }
            }
            if(!messageFound){
                System.out.println("Message not Found\n");
            }

        }
        if (!found) {
            System.out.println("Receiver Not Found\n");
        }
    }

    public void searchMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Message ID: ");
        String id = sc.nextLine();
        boolean found = false;
        for (int i = 0; i < receiversCounter; i++) {
            for (int j = 0; j < receivers[i].length; j++) {
                if (receivers[i][j] != null && (receivers[i][j].getMessage().messageId.compareTo(id)) == 0) {
                    System.out.println(receivers[i][j]);
                    found = true;
                    break;
                }
            }
        }
        if(!found){
            System.out.println("Message not Found\n");
        }
    }

    public void displayContacts() {
        for (int i = 0; i < receiversCounter; i++) {
            for (int j = 0; j < receivers[i].length; j++) {
                if (receivers[i][0] != null) {
                    System.out.println("Name: " + receivers[i][0].getName() + "\nNumber: " + receivers[i][0].getNumber());
                    System.out.println("------------------------------\n");
                    break;
                }
                else{
                    if(receivers[i][j]!=null){
                        System.out.println("Name: " + receivers[i][j].getName() + "\nNumber: " + receivers[i][j].getNumber());
                        System.out.println("------------------------------\n");
                        break;
                    }
                }
            }
        }
    }

    public void sortMessages(){
        Receiver[] tempReceivers = new Receiver[receivers.length];
        int tempIndex = 0;
        for(int i=0; i<receiversCounter;i++){
            for(int j=0; j<receivers[i].length;j++){
                if(receivers[i][j]!=null){
                    tempReceivers[tempIndex++]=receivers[i][j];
                }
            }
        }
        for(int k=0; k<tempIndex; k++){
            for(int l=k+1; l<tempIndex; l++){
                if(tempReceivers[k].getMessage().getDateTime().compareTo(tempReceivers[l].getMessage().getDateTime())<0){
                    Receiver temp = tempReceivers[k];
                    tempReceivers[k]=tempReceivers[l];
                    tempReceivers[l]=temp;
                }
            }
        }
        for(int a = 0; a<tempIndex; a++){
            System.out.println(tempReceivers[a]);
            System.out.println("-------------------\n");
        }
    }
}