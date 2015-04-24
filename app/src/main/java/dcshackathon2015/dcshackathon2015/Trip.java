package dcshackathon2015.dcshackathon2015;

/**
 * Created by gj_ on 4/24/2015.
 */
public class Trip {
    private int _id;
    private String _name;
    private int _terminalId;
    private String _availability;

    public Trip(){}

    public Trip(int id, String name, int terminalId, String availability){
        this._id = id;
        this._name = name;
        this._terminalId = terminalId;
        this._availability = availability;
    }

    public void setId(int id){
        this._id = id;
    }

    public int getId(){
        return this._id;
    }

    public void setName(String name){
        this._name = name;
    }

    public String getName(){
        return this._name;
    }

    public void setTerminalId(int id){
        this._terminalId = id;
    }

    public int getTerminalId(){
        return this._terminalId;
    }

    public void setAvailability(String a){
        this._availability = a;
    }

    public String getAvailability(){
        return this._availability;
    }

}
