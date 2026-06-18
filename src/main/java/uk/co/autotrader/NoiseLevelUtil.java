package uk.co.autotrader;

import java.util.ArrayList;
import java.util.List;

public class NoiseLevelUtil {
    public List<String> getPrintArrayBasedOnNoise(NoiseLevel noiseLevel, ArrayList<String> output){
        List<String> formattedList = new ArrayList<>();
        switch (noiseLevel) {
            case QUIET: formattedList = output.subList(output.lastIndexOf("**********************"),output.size());
            break;
            case NORMAL: formattedList = output.subList(0,output.indexOf("CAR PURCHASES:"));
            formattedList.addAll(output.subList(output.lastIndexOf("**********************"),output.size()));
            break;
            case VERBOSE: return output;
        }
        return formattedList;
    }
}
