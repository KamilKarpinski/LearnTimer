package pl.karpinski.LearnTimer.LearningSessionTopic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import pl.karpinski.LearnTimer.LearningSession.LearningSession;
import pl.karpinski.LearnTimer.LearningSession.LearningSessionRepo;

import java.util.Optional;

@RestController
public class LearningSessionTopicApi {
@Autowired
LearningSessionRepo learningSessionRepo;
@Autowired
LearningSessionTopicRepo learningSessionTopicRepo;

@PostMapping("/api_topic/post")
    public boolean addTopic(@RequestHeader("id") Long sessionId, @RequestBody String topic){
    Optional<LearningSession> learningSession = learningSessionRepo.findById(sessionId);
    Optional<LearningSessionTopic> learningSessionTopic = learningSessionTopicRepo.findByTopic(topic, sessionId);

    if(learningSession.isEmpty() || learningSessionTopic.isPresent()){
        return false;
    }
    learningSessionTopicRepo.save(new LearningSessionTopic(learningSession.get(), topic));
    return true;
}

}
