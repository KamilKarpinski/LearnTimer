package pl.karpinski.LearnTimer;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.karpinski.LearnTimer.LearningSession.LearningSessionApi;

import java.util.Date;

@Route()
public class StartGui extends VerticalLayout {
private Button buttonStart;
private Button buttonStop;
private TextArea textArea;

private Long currentSessionId = 0L;

@Autowired
    LearningSessionApi learningSessionApi;

public StartGui() {
    this.buttonStart = new Button("Start Session");
    this.buttonStop = new Button("Stop Session");
    this.textArea = new TextArea("Curren Session Started:");

    buttonStart.addClickListener(buttonClickEvent -> {
        if(currentSessionId<=0){            //if session isnt started yet
                Date date = new Date();
                currentSessionId = learningSessionApi.startSession(date);
                textArea.setValue(date.toString());
            }}
            );

    buttonStop.addClickListener(buttonClickEvent -> {
                learningSessionApi.stopSession(currentSessionId); //patch session
                currentSessionId = -1L;
            }
    );


    add(buttonStart);
    add(textArea);
    add(buttonStop);
}

}
