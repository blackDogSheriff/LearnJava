package set;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        List<Message> messages = List.of(
                new Message(1, "Hello!"),
                new Message(2, "发工资了吗？"),
                new Message(2, "发工资了吗？"),
                new Message(3, "去哪吃饭？"),
                new Message(3, "去哪吃饭？"),
                new Message(4, "Bye"));
        List<Message> displayMessages = process(messages);
        for (Message message : displayMessages) {
            System.out.println(message.text);
        }
    }

    static List<Message> process(List<Message> received) {
        Set<Message> messages = new TreeSet(new Comparator<Message>() {
            public int compare(Message a, Message b) {
                if (a.sequence == b.sequence) {
                    return 0;
                }
                return a.sequence - b.sequence > 0 ? 1 : -1;
            }
        });

        messages.addAll(received);
        return new ArrayList<Message>(messages);

    }
}

class Message {
    public final int sequence;
    public final String text;

    public Message(int sequence, String text) {
        this.sequence = sequence;
        this.text = text;
    }
}