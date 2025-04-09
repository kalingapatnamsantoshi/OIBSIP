public class TrainDatabase {
    public static String getTrainName(String trainNo) {
        switch (trainNo) {
            case "12345":
                return "Godavari Express";
            case "23456":
                return "Duronto Express";
            case "12727":
                return "Godavari SF Express";
            case "12627":
                return "Karnataka Express";
            case "12841":
                return "Coromandel Express";
            case "12951":
                return "Mumbai Rajdhani Express";
            case "12245":
                return "Howrah Yeshvantpur Duronto";
            case "12009":
                return "Shatabdi Express";
            case "12430":
                return "Rajdhani Express";
            case "22691":
                return "Rajdhani Humsafar Express";
            case "12779":
                return "Goa Express";
            case "12650":
                return "Karnataka Sampark Kranti Express";
            default:
                return "Unknown Train";
        }
    }
}
