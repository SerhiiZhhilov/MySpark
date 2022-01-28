package data;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import javax.ws.rs.NotSupportedException;
import java.util.List;

@Builder
public class MyFileDataProvider implements MyDataProvider<String> {

    @Getter
    @NonNull
    private String fileName;

    @Override
    public List<String> retrieveData() {
        throw new NotSupportedException();
    }
}
