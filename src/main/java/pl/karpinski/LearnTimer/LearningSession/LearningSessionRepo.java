package pl.karpinski.LearnTimer.LearningSession;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearningSessionRepo extends JpaRepository<LearningSession, Long> {

}
