package dcshackathon2015.dcshackathon2015;

/**
 * Created by gj_ on 4/24/2015.
 */
public class Terminal {
    private int _id;
    private String _place;

    public Terminal(){}

    public Terminal(int id, String place){
        this._id = id;
        this._place = place;
    }

    public void setId(int id){
        this._id = id;
    }

    public int getId(){
        return this._id;
    }

    public void setPlace(String place){
        this._place = place;
    }

    public String getPlace(){
        return this._place;
    }
}
