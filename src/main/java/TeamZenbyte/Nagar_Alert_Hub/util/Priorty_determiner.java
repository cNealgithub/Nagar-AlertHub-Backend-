package TeamZenbyte.Nagar_Alert_Hub.util;

public class Priorty_determiner {

    public String mapPriority(double confidence) {
        if (confidence >= 0.85) return "Critical";
        else if (confidence >= 0.65) return "High";
        else if (confidence >= 0.40) return "Medium";
        else return "Low";
    }
}
