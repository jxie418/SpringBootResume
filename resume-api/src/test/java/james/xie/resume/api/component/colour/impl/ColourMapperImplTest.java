package james.xie.resume.api.component.colour.impl;

import org.junit.Test;
import james.xie.resume.api.component.colour.ColourInfo;
import james.xie.resume.api.component.colour.ColourMapper;

import java.util.Arrays;
import java.util.Optional;

import static java.util.Collections.emptyList;
import static org.junit.Assert.assertEquals;

public class ColourMapperImplTest {

    private ColourMapper colourMapper = new ColourMapperImpl();

    @Test
    public void testMapWhite() throws Exception {
        final Optional<ColourInfo> colourInfo = colourMapper.map(Arrays.asList("Cirrus White"));
        assertEquals(colourInfo.get().getColour(), "WHITE");
        assertEquals(colourInfo.get().getColourCode(), "N");
    }

    @Test
    public void testMapYellow() throws Exception {
        final Optional<ColourInfo> colourInfo = colourMapper.map(Arrays.asList("Yellow/colour"));
        assertEquals(colourInfo.get().getColour(), "YELLOW");
        assertEquals(colourInfo.get().getColourCode(), "F");
    }

    @Test
    public void testMapOneKnownOneUnknownShouldGiveMultiColour(){
        final Optional<ColourInfo> colourInfo = colourMapper.map(Arrays.asList("Yellow/colour", "Does Not Exist"));
        assertEquals(colourInfo.get().getColour(), "MULTI-COLOURED");
        assertEquals(colourInfo.get().getColourCode(), "R");
    }

    @Test
    public void testMapAllUnknown(){
        final Optional<ColourInfo> colourInfo = colourMapper.map(Arrays.asList("Does Not Exist"));
        assertEquals(Optional.empty(), colourInfo);
    }

    @Test
    public void testMapNullColours(){
        final Optional<ColourInfo> colourInfo = colourMapper.map(null);
        assertEquals(Optional.empty(), colourInfo);
    }

    @Test
    public void testMapEmptyList(){
        final Optional<ColourInfo> colourInfo = colourMapper.map(emptyList());
        assertEquals(Optional.empty(), colourInfo);
    }

}