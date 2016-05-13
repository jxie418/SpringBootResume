package james.xie.resume.api.component.colour;

import java.util.List;
import java.util.Optional;

public interface ColourMapper {
    Optional<ColourInfo> map(final List<String> colour);
}
