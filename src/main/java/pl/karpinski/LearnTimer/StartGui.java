package pl.karpinski.LearnTimer;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.karpinski.LearnTimer.LearningSession.LearningSessionApi;
import pl.karpinski.LearnTimer.LearningSessionTopic.LearningSessionTopicApi;

import java.util.Date;

@Route()
public class StartGui extends VerticalLayout {
private Button buttonStart;
private Button buttonStop;
private TextArea textArea;

private TextField textField;
private Button buttonAddTopic;

private Button buttonStopEditing;
private Long currentSessionId = 0L;

@Autowired
    LearningSessionApi learningSessionApi;

@Autowired
LearningSessionTopicApi learningSessionTopicApi;

public StartGui() {
    this.buttonStart = new Button("Start Session");
    this.buttonStop = new Button("Stop Session");
    this.textArea = new TextArea("Current Session Started:");
    this.textField = new TextField("type Sessions topic, after stopping session");
    this.buttonAddTopic = new Button("add Topic");
    this.buttonStopEditing = new Button("stop edditing topics");

    buttonStart.addClickListener(buttonClickEvent -> {
        if(currentSessionId<=0){            //if session isnt started yet
                Date date = new Date();
                currentSessionId = learningSessionApi.startSession(date);
                textArea.setValue(date.toString());
            }}
            );

    buttonStop.addClickListener(buttonClickEvent -> {
        if(currentSessionId > 0) {
            learningSessionApi.stopSession(currentSessionId); //patch session
            remove(buttonStart);
            remove(textArea);
            remove(buttonStop);
            add(textField);
            textField.setValue("");
            add(buttonAddTopic);
            add(buttonStopEditing);
        }
            }
    );

    buttonAddTopic.addClickListener(buttonClickEvent -> {
        if(currentSessionId>0){
        learningSessionTopicApi.addTopic(currentSessionId, textField.getValue()); //patch session
        }
            }
    );

    buttonStopEditing.addClickListener(buttonClickEvent -> {
                    currentSessionId = -1L;
                    remove(textField);
                    remove(buttonAddTopic);
                    remove(buttonStopEditing);
                    add(buttonStart);
                    add(textArea);
                    textArea.setValue("");
                    add(buttonStop);
    }
    );
    add(buttonStart);
    add(textArea);
    add(buttonStop);
}

}
