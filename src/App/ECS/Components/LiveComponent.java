package App.ECS.Components;

import App.ECS.Component;

import java.util.Calendar;

public class LiveComponent extends Component {

    private int score = 0;
    private long time = Calendar.getInstance().getTimeInMillis();

    public LiveComponent () {}


    @Override
    public void init() {

    }

    @Override
    public void update() {

        if(Calendar.getInstance().getTimeInMillis() - time >= 1000) {
            score++;
            time = Calendar.getInstance().getTimeInMillis();
        }

    }

    @Override
    public void draw() {

    }
}
