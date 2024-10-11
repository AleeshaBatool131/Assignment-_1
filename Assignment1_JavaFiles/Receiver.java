public class Receiver {
    private final String name;
    private final String number;
    private final Message message;

    public Receiver(String name, String number, Message message) {
        this.name = name;
        this.number = number;
        this.message=message;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public Message getMessage() {
        return message;
    }
    @Override
    public String toString(){
        return String.format("Receiver:\nName: %s\nPhone Number: %s\nMessage: \n%s",name,number,message.toString());
    }

    @Override
    public boolean equals(Object obj){
        Receiver temp = (Receiver) obj;
        return (name.equals(temp.getName()))&&( number.equals(temp.getNumber()));
    }
}
