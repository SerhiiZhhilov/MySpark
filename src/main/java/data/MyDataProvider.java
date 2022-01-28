package data;

import java.util.List;

public interface MyDataProvider<T> {
    List<T> retrieveData();
}
