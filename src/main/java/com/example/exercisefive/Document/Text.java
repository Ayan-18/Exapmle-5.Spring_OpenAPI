package com.example.exercisefive.Document;

import com.example.exercisefive.Helper.Indices;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.time.LocalDateTime;

@Document(indexName = Indices.TEXT_INDEX)
@Setting(settingPath = "static/text.json")
public class Text {

    @Id
    @Field(type = FieldType.Keyword)
    private String id;
    @Field(type = FieldType.Text)
    private String text;
    @Field(type = FieldType.Date, format = DateFormat.date_hour_minute_second_millis)
    private LocalDateTime dateReg;

    public LocalDateTime getDateReg() {
        return dateReg;
    }

    public void setDateReg(LocalDateTime dateReg) {
        this.dateReg = dateReg;
    }

    public Text(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public Text() {
    }

    public Text(String text) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Text{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
