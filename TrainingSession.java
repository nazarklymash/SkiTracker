public class TrainingSession{

    private String date;
    private int timeOfSession;
    private String typeOfSession;
    private String notes;

    public String getDate(){
        return date;
    }

    public int getTimeOfSession(){
        return timeOfSession;
    }

    public String getTypeOfSession(){
        return typeOfSession;
    }

    public String getNotes(){
        return notes;
    }

    public void setDate(String date){
        if (date == null || date.isEmpty() || date.isBlank()){
            throw new IllegalArgumentException("Error: Date has to be defined");
        }
        this.date = date;
    }

    public void setTimeOfSession(int timeOfSession){
        if (timeOfSession <= 0){
            throw new IllegalArgumentException("Error: Time of session has to be > 0");
        }
        this.timeOfSession = timeOfSession;
    }

    public void setTypeOfSession(String typeOfSession){
        if (typeOfSession == null || typeOfSession.isEmpty() || typeOfSession.isBlank()){
            throw new IllegalArgumentException("Error: Type of session has to be defined");
        }
        this.typeOfSession = typeOfSession;
    }

    public void setNotes(String notes){
        this.notes = notes;
    }

    public String toString(){
        return "TrainingSession{date=" + date +
                                ", timeOfSession=" + timeOfSession + 
                                ", typeOfSession=" + typeOfSession + 
                                ", notes=" + notes + "}";
    }
}