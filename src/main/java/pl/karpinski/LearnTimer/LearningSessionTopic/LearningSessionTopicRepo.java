package pl.karpinski.LearnTimer.LearningSessionTopic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface LearningSessionTopicRepo extends JpaRepository<LearningSessionTopic, Long> {
    @Query(nativeQuery = true, value = "SELECT topic FROM learntimerdb.learning_session_topics WHERE topic = :topic and learning_session_id = :sessionId")
    Optional<LearningSessionTopic> findByTopic(@Param("topic") String topic, @Param("sessionId") Long sessionId);
}
