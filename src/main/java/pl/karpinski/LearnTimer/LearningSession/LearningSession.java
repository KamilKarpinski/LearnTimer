package pl.karpinski.LearnTimer.LearningSession;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name =  "learning_sessions")
public class LearningSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date startDate;
    private Date endDate;
    private double duration;

    public LearningSession( Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.duration = 0;
    }

    public LearningSession() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
        calculateDuration();
    }
    public void calculateDuration(){
        this.duration = (this.endDate.getTime() - this.startDate.getTime())/1000.0;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
}
