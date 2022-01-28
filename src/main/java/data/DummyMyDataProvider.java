package data;

import java.util.ArrayList;
import java.util.List;

public class DummyMyDataProvider implements MyDataProvider<Double> {

    @Override
    public List<Double> retrieveData() {
        List<Double> result = new ArrayList<>();
        result.add(35.5);
        result.add(36.9);
        result.add(25.54655);
        result.add(15.23);
        result.add(64.5667);
        return result;
    }
}
