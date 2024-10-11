import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Message{
    final String messageId;
    private String content;
    private String dateTime;
    private String status;

    public static int id = 0;

    public Message(String content, String status){
        this.messageId=String.format("MSG%07d",++id);
        this.content = content;
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE dd-MM-yyyy HH:mm:ss");
        this.dateTime= current.format(formatter);
        this.status=status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString(){
        return String.format("Message ID: %s\nContent: %s\nStatus: %s\n %s",messageId,content,status,dateTime);
    }
}