public class SequenceLine {
    private String participantFrom;
    private String participantTo;
    private String message;

    public SequenceLine(String participantFrom, String participantTo, String message) {
        this.participantFrom = participantFrom;
        this.participantTo = participantTo;
        this.message = message;
    }

    public String getParticipantFrom() {
        return participantFrom;
    }

    public String getParticipantTo() {
        return participantTo;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return participantFrom + " -> " + participantTo + " : " + message;
    }
}
