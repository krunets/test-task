package by.runets.voting.model;


import lombok.Data;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "answer")
@Data
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "a_id")
    private int id;

    @Column(name = "body")
    private String body;

    @Column(name = "voting_amount")
    private int votingAmount;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="q_id")
    private Question question;

    @OneToMany(mappedBy = "answer")
    List<User> users;
}
