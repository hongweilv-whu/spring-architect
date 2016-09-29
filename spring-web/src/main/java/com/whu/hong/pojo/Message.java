package com.whu.hong.pojo;

/**
 *
 * Created by lvhw on 2016/6/22.
 */
//@XmlRootElement(name = "pizza")

public class Message {
    String name;
    String text;

    public Message(String name, String text) {
        this.name = name;
        this.text = text;
    }

    //@XmlElement
    public String getName() {
        return name;
    }

    //@XmlElement
    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Message{" +
                "name='" + name + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
