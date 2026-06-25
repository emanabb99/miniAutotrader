package uk.co.autotrader.model;

import java.util.ArrayList;
import java.util.List;

public class NoiseLevelUtil {
    public List<String> getPrintArrayBasedOnNoise(NoiseLevel noiseLevel, ArrayList<String> output) {
        List<String> formattedList = new ArrayList<>();
        switch (noiseLevel) {
            case QUIET:
                formattedList = output.subList(0, output.indexOf("**********************"));
                formattedList.addAll(output.subList(output.lastIndexOf("**********************"), output.size()));
                break;
            case NORMAL:
                int indexCarPuchase = 0;
                for (int i = 0; i < output.size(); i++) {
                    if (output.get(i).equals("CAR PURCHASES:")) {
                        indexCarPuchase = i;
                    }
            }
                formattedList = output.subList(0, indexCarPuchase-1);
                formattedList.addAll(output.subList(output.lastIndexOf("**********************"), output.size()));
                break;
            case VERBOSE:
                return output;
        }
        return formattedList;
    }
}
