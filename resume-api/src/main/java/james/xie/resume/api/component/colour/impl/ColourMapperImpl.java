package james.xie.resume.api.component.colour.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import james.xie.resume.api.component.colour.ColourInfo;
import james.xie.resume.api.component.colour.ColourMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.apache.commons.collections.CollectionUtils.isEmpty;

@Slf4j
@Component
public class ColourMapperImpl implements ColourMapper {

    private static final Map<String, String> dGColours = new HashMap<>();

    static {
        dGColours.put("BEIGE", "S");
        dGColours.put("BLACK", "P");
        dGColours.put("BLUE", "J");
        dGColours.put("BRONZE", "B");
        dGColours.put("BROWN", "A");
        dGColours.put("CREAM", "V");
        dGColours.put("GOLD", "G");
        dGColours.put("GREEN", "H");
        dGColours.put("GREY", "L");
        dGColours.put("MAROON", "T");
        dGColours.put("PURPLE", "K");
        dGColours.put("MULTI-COLOURED", "R");
        dGColours.put("NOT STATED", "W");
        dGColours.put("ORANGE", "E");
        dGColours.put("PINK", "D");
        dGColours.put("RED", "C");
        dGColours.put("SILVER", "M");
        dGColours.put("TURQUOISE", "U");
        dGColours.put("WHITE", "N");
        dGColours.put("YELLOW", "F");
    }

    @Override
    public Optional<ColourInfo> map(final List<String> carColours) {
        if (isEmpty(carColours))
            return Optional.empty();

        if (carColours.size() > 1)
            return Optional.of(new ColourInfo("MULTI-COLOURED", "R"));

        //colour size is 1
        final String colour = carColours.get(0);


        for (Map.Entry<String, String> colourEntry : dGColours.entrySet()) {
            final String dGColour = colourEntry.getKey();
            if (colour.toUpperCase().contains(dGColour)) {
                return Optional.of(new ColourInfo(dGColour, colourEntry.getValue()));
            }
        }
        log.info("Could not match colour {}", colour);
        return Optional.empty();
    }

}
