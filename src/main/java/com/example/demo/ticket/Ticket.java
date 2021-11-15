package com.example.demo.ticket;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Ticket {
    @Id
    @SequenceGenerator(name = "ticketName", sequenceName = "ticketName", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ticketName")
    private long id;
    private String title;
    private String description;
    private LocalDate creationDate;
    private char severity;
    private char status;


    public Ticket() {

    }

    public Ticket(long id,String title,
                  String description,
                  LocalDate creationDate,
                  char severity,
                  char status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.severity = severity;
        this.status = status;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public char getSeverity() {
        return severity;
    }

    public void setSeverity(char severity) {
        this.severity = severity;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", severity=" + severity +
                ", status=" + status +
                ", id=" + id +
                '}';
    }
}
