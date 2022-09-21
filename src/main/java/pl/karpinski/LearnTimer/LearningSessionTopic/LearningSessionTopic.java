package pl.karpinski.LearnTimer.LearningSessionTopic;


import org.springframework.lang.NonNull;
import pl.karpinski.LearnTimer.LearningSession.LearningSession;

import javax.persistence.*;

@Entity
@Table(name = "learning_session_topics")
public class LearningSessionTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @ManyToOne
    private LearningSession learningSession;

    @NonNull
    private String topic;

    public LearningSessionTopic( @NonNull LearningSession learningSession, @NonNull String topic) {
        this.learningSession = learningSession;
        this.topic = topic;
    }

    public LearningSessionTopic() {
    }

}
