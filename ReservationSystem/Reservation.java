public class Reservation {
    String name, trainNo, trainName, classType, doj, from, to, pnr;

    public Reservation(String name, String trainNo, String classType, String doj, String from, String to) {
        this.name = name;
        this.trainNo = trainNo;
        this.trainName = TrainDatabase.getTrainName(trainNo);
        this.classType = classType;
        this.doj = doj;
        this.from = from;
        this.to = to;
        this.pnr = PNRGen.generatePNR();
    }

    @Override
    public String toString() {
        return pnr + "," + name + "," + trainNo + "," + trainName + "," + classType + "," + doj + "," + from + "," + to;
    }

    public String toPrettyString() {
        return "<html>" +
                "<body style='color: #4B0082; font-family: Comic Sans MS;'>" +
                "🎟️ <b>PNR:</b> " + pnr + "<br>" +
                "👤 <b>Name:</b> " + name + "<br>" +
                "🚆 <b>Train No:</b> " + trainNo + "<br>" +
                "🛤️ <b>Train Name:</b> " + trainName + "<br>" +
                "💺 <b>Class:</b> " + classType + "<br>" +
                "📅 <b>Date:</b> " + doj + "<br>" +
                "📍 <b>From:</b> " + from + " ➡️ " + to +
                "</body></html>";
    }
}
