public class Tag {
    int tagNr = -1;
    boolean besetzt;
    String gerichtsname;

    public Tag(int tagNr){
        this.tagNr = tagNr;
    }

    public void setBesetzt(boolean besetzt){
        this.besetzt = besetzt;
    }

    public void setGerichtsname(String gerichtsname){
        this.gerichtsname = gerichtsname;
    }

    public int getTagNr() {
        return tagNr;
    }

    public boolean getBesetzt(){
        return besetzt;
    }

    public String getGerichtsname(){
        return  gerichtsname;
    }

}
