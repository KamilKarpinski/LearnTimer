package pl.karpinski.LearnTimer.LearningSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Optional;

@RestController
public class LearningSessionApi {
@Autowired
    LearningSessionRepo learningSessionRepo;

    @PostMapping("/api/startSession")
    public Long startSession(@RequestParam Date date) {
        return learningSessionRepo.save(new LearningSession(date, date)).getId();
    }
    @PatchMapping("/api/startSession")
    public boolean stopSession(@RequestParam  Long currentSessionId) {
        Optional<LearningSession> learningSession = learningSessionRepo.findById(currentSessionId);
        if(learningSession.isPresent()){
            learningSession.get().setEndDate(new Date());
            learningSessionRepo.save(learningSession.get());
            return true;
        }
        return false;
    }
}
